package org.javalearners.annotations;

public class Child {

    private final String name;
    private final boolean getsPresent;

    public Child(String name, boolean getsPresent) {
        this.name = name;
        this.getsPresent = getsPresent;
    }

    @GoodOrEvil
    public boolean getsPresent() {
        return this.getsPresent;
    }

    @OrderPresent
    public void orderPresent() {
        System.out.println("Order present for " + name + " on Amazon");
    }

}
