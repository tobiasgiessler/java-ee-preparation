package org.javalearners.chapter3.jsf;

import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class CustomerSessionBean {

    public List<Name> getCustomerNames() {
        final Name homer = new Name();
        homer.setValue("Homer Simpson");
        final Name mrBurns = new Name();
        mrBurns.setValue("Mr. Burns");
        final Name moe = new Name();
        moe.setValue("Moe");
        
        return Arrays.asList(homer, mrBurns, moe);
    }
}
