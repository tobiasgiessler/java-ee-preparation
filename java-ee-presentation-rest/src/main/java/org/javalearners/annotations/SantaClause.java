package org.javalearners.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SantaClause {

    public void prepareChristmas(List<Object> children) {
        children.stream().forEach((Object child) -> {
            try {
                final Method goodOrEvil = getMethodWithAnnotation(child, GoodOrEvil.class);
                if (Boolean.TRUE.equals(goodOrEvil.invoke(child))) {
                    getMethodWithAnnotation(child, OrderPresent.class).invoke(child);
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public Method getMethodWithAnnotation(Object object, Class annotation) {
        final Method[] methods = object.getClass().getMethods();

        for (final Method method : methods) {
            if (method.isAnnotationPresent(annotation)) {
                return method;
            }
        }

        throw new RuntimeException("annotation not found");
    }

}
