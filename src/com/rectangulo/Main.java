package com.rectangulo;

public class Main {

    public static void main(String[] args) {
        // arbol prueba
        arbolNario y = new arbolNario("(a(x(b),c))");
        arbolBinario zora = new arbolBinario(y);
        arbolNario z= new arbolNario("(a(b(c,d(e)),f,g(h,i(j,k(l)),m,n)))");
        arbolBinario zarbol = new arbolBinario(z);
        y.escribirNario();
        z.escribirNario();


        //inicio pruebas para padre
        nodoDoble x = zora.getRaiz();
        zora.padre('c',zora.getRaiz());
        System.out.println(zora.padre.getDato());
        //fin pruebas para padre

        // inicio pruebas para ancestro
        System.out.println();
        zora.ancestros('b', zora.getRaiz());
    }
}