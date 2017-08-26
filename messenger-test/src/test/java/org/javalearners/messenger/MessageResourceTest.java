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
        get("http://localhost:8080/messenger/webapi/messages")
                .then()
                .statusCode(HttpStatus.SC_OK);
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
}
