package com.rectangulo;

public class nodoDoble {

    private Object dato;
    private nodoDoble ligai, ligad;

    public nodoDoble(Object dato) {
        this.dato = dato;
    }

    public nodoDoble() {
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public nodoDoble getLigai() {
        return ligai;
    }

    public void setLigai(nodoDoble ligai) { this.ligai = ligai;}

    public nodoDoble getLigad() {
        return ligad;
    }

    public void setLigad(nodoDoble ligad) {this.ligad = ligad;}
}