package org.javalearners.cdi.service;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GreetingServiceTest {
    
    private static Weld weld;
    private static WeldContainer weldContainer;
    
    public GreetingServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        weld = new Weld();
        weldContainer = weld.initialize();
    }
    
    @AfterClass
    public static void tearDownClass() {
        weld.shutdown();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of phraseGreeting method, of class GreetingService.
     */
    @Test
    public void testPhraseGreeting() {
        System.out.println("phraseGreeting");
        String name = "Lisa";
        GreetingService instance = weldContainer.select(GreetingService.class).get();
//        GreetingService instance = new GreetingService();
        String expResult = "Hello, Lisa.";
        String result = instance.phraseGreeting(name);
        assertEquals(expResult, result);
    }
    
}
