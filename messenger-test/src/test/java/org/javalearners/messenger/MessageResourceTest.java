package org.javalearners.messenger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.*;
import java.lang.reflect.Array;
import javax.json.Json;
import javax.json.JsonObject;
import org.apache.http.HttpStatus;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author tobi
 */
public class MessageResourceTest {
    
    public MessageResourceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
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
                .post("http://localhost:8080/messenger/webapi/messages")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("author", equalTo("hsimpson"))
                .body("message", equalTo("Hello"))
                .body("id", any(Integer.TYPE))
                .body("links", anything())
                .body("created", any(String.class));
    }
}
