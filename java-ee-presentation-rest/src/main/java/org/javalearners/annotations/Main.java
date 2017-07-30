package org.javalearners.annotations;

import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        final Child max = new Child("Max", true);
        final Kind moritz = new Kind("Moritz", true);
        final Hijo francisco = new Hijo();
        francisco.setNombre("Francisco Franco");
        
        List<Object> children = Arrays.asList(max, moritz, francisco);
        
        new SantaClause().prepareChristmas(children);
    }
    
}
