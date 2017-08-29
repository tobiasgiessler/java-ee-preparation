package org.javalearners.messenger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import org.apache.http.HttpStatus;
import static org.hamcrest.Matchers.*;

public class MessageResourceTest {

    private final String webapiPath = "http://localhost:8080/messenger/webapi";
    private final JsonObject testMessage = Json.createObjectBuilder()
            .add("author", "mburns")
            .add("message", "Excellent")
            .build();

    public MessageResourceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Deletes all present messages so that tests do not influence each other.
     */
    @Before
    public void setUp() {
        final Response messages = get(webapiPath + "/messages");
        messages.then().statusCode(HttpStatus.SC_OK);
        final List<Integer> messageIds = messages.body().jsonPath().getList("id");

        messageIds.stream().forEach(id -> {
            delete(webapiPath + "/messages/" + id)
                    .then()
                    .statusCode(HttpStatus.SC_NO_CONTENT);
        });
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetMessages() {
        get(webapiPath + "/messages")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testGetMessage() {
        final int messageId = createMessage(testMessage);

        get(webapiPath + "/messages/" + messageId)
                .then()
                .body("author", equalTo(testMessage.getString("author")))
                .body("message", equalTo(testMessage.getString("message")))
                .body("links", anything())
                .body("created", any(String.class));
    }

    @Test
    public void testAddMessage() {
        final JsonObject homerSaysHello = Json.createObjectBuilder()
                .add("author", "hsimpson")
                .add("message", "Hello")
                .build();
        given()
                .contentType(ContentType.JSON)
                .body(homerSaysHello.toString())
                .post(webapiPath + "/messages")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("author", equalTo("hsimpson"))
                .body("message", equalTo("Hello"))
                .body("id", any(Integer.TYPE))
                .body("links", anything())
                .body("created", any(String.class));
    }

    @Test
    public void updateMessage() {
        final int messageId = createMessage(testMessage);
        final JsonObject updatedMessage = Json.createObjectBuilder(testMessage)
                .add("message", "updated message")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(updatedMessage.toString())
                .put(webapiPath + "/messages/" + messageId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("author", equalTo(testMessage.getString("author")))
                .body("message", equalTo(updatedMessage.getString("message")))
                .body("id", any(Integer.TYPE))
                .body("links", anything())
                .body("created", any(String.class));
    }

    private int createMessage(JsonObject message) {
        final Response createResponse = given()
                .contentType(ContentType.JSON)
                .body(message.toString())
                .post(webapiPath + "/messages");

        createResponse.then().statusCode(HttpStatus.SC_CREATED);

        return createResponse.body().jsonPath().get("id");
    }
}
