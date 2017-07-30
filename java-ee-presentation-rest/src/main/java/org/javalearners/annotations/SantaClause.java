package org.javalearners.annotations;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class SantaClause {
    
    public void prepareChristmas(List<Object> children) {
        children.stream().forEach(child -> {
            // order presents for good children
            Method[] methods = child.getClass().getMethods();
            System.out.println(Arrays.toString(child.getClass().getAnnotations()));
        });
    }
    
}
