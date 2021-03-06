package org.javalearners.aquillianexample;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GreeterTest {

    @Inject
    private Greeter greeter;

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClasses(Greeter.class, PhraseBuilder.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(jar.toString());
        return jar;
    }

    @Test
    public void testCreateGreeting() {
        System.out.println("createGreeting");
        String name = "Lisa";
        String expResult = "Hello, Lisa!";
        String result = greeter.createGreeting(name);
        assertEquals(expResult, result);
    }

}
