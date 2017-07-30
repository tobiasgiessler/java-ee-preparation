package org.javalearners.annotations;

public class Kind {
    
    private final String name;
    private final boolean warBrav;

    public Kind(String name, boolean warBrav) {
        this.name = name;
        this.warBrav = warBrav;
    }
    
    public boolean istEinBravesKind() {
        return warBrav;
    }
    
    public void geschenkBestellen() {
        System.out.println("Bestelle Geschenk für " + name);
    }
    
}
