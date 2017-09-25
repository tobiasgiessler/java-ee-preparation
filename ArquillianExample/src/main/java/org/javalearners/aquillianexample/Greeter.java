package org.javalearners.aquillianexample;

import java.io.PrintStream;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class Greeter {

    @Inject
    private PhraseBuilder phraseBuilder;

    public void greet(PrintStream to, String name) {
        to.println(createGreeting(name));
    }

    public String createGreeting(String name) {
        return phraseBuilder.buildPhrase("hello", name);
    }

}
