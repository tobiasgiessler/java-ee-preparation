package org.javalearners.annotations;

public class Kind {

    private final String name;
    private final boolean warBrav;

    public Kind(String name, boolean warBrav) {
        this.name = name;
        this.warBrav = warBrav;
    }

    @GoodOrEvil
    public boolean istEinBravesKind() {
        return warBrav;
    }

    @OrderPresent
    public void geschenkBestellen() {
        System.out.println("Bestelle Geschenk für " + name + " auf Ebay");
    }

}
