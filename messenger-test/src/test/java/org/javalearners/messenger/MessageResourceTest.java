package org.javalearners.messenger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
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
        get("http://localhost:8080/messenger/webapi/messages").then().statusCode(HttpStatus.SC_OK);
    }
}
