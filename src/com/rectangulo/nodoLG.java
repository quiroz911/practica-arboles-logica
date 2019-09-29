package com.rectangulo;

public class nodoLG {

    private Object dato;
    private nodoLG liga;
    private boolean switche;

    public nodoLG(){};

    public nodoLG(Object dato) {
        this.dato = dato;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public nodoLG getLiga() {
        return liga;
    }

    public void setLiga(nodoLG liga) {
        this.liga = liga;
    }

    public boolean isSwitche() {
        return switche;
    }

    public void setSwitche(boolean switche) {
        this.switche = switche;
    }
}
