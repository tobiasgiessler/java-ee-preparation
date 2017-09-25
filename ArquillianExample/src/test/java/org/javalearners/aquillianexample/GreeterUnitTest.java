package org.javalearners.aquillianexample;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GreeterUnitTest {

    @Inject
    private Greeter greeter;

    @Deployment
    public static JavaArchive createDeployment() {
        final Path filePath = FileSystems.getDefault().getPath(
                "src",
                "test",
                "resources",
                "META-INF",
                "beans.xml");
        final File beansXml = filePath.toFile();
        final JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClasses(Greeter.class, PhraseBuilder.class, PhraseBuilderSimulator.class)
                .addAsManifestResource(beansXml);
        System.out.println(jar.toString());
        return jar;
    }

    @Test
    public void testCreateGreeting() {
        System.out.println("createGreeting");
        String name = "Lisa";
        String expResult = "test value";
        String result = greeter.createGreeting(name);
        assertEquals(expResult, result);
    }

}
