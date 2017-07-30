package org.javalearners.annotations;

public class Hijo {
    
    private String nombre;
    private boolean dictador;
    private boolean inocente;
    
    public void obsequiarAlgoAAlguien() {
        System.out.println("Pide un regalo para " + nombre);
    } 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean esUnDictador() {
        return dictador;
    }

    public void setDictador(boolean esUnDictador) {
        this.dictador = esUnDictador;
    }

    @GoodOrEvil
    public boolean esInocente() {
        return inocente;
    }

    public void setInocente(boolean esInocente) {
        this.inocente = esInocente;
    }
    
}
