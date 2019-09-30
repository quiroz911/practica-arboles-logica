package com.rectangulo;

public class Main {

    public static void main(String[] args) {
        arbolNario y = new arbolNario("(a(x(b),c))");
        arbolBinario zora = new arbolBinario(y);
    }
}