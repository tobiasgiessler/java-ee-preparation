package org.javalearners.aquillianexample;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;

@Dependent
@Alternative
public class PhraseBuilderSimulator extends PhraseBuilder {
    
    @Override
    public String buildPhrase(String templateId, Object... args) {
        return "test value";
    }
    
}
