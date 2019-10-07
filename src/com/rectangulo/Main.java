package com.rectangulo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("1.Ingresar hilera de abre parentesis, comas y cierre parentesis");
        System.out.println("2.Imprimir arbol representado");
        System.out.println("3.Mostrar grado del arbol n-ario"); //no esta listo
        System.out.println("4.Altura"); //no esta listo
        System.out.println("5.Numero de hojas");
        System.out.println("6.Ancestros de un dato"); //no esta listo
        System.out.println("7.Recorrido inorden");
        System.out.println("8.Recorrido preorden");
        System.out.println("9.Recorrido posorden");
        System.out.println("10.Grado de un dato"); //no esta listo
        System.out.println("11.Recorrido por niveles"); //no esta listo
        System.out.println("12.salir del programa");
        Scanner sc = new Scanner(System.in);
        arbolNario arbolNario1 = null;
        arbolBinario arbolBinario1 = null;
        boolean salir = false;

        while(!salir) {
            System.out.println("Seleccione una opcion:");
            String opcion = sc.nextLine();
            switch (opcion) {
                case "1": {
                    System.out.println("Ingrese la hilera");
                    String hilera = sc.nextLine();
                    arbolNario1 = new arbolNario(hilera);
                    arbolBinario1 = new arbolBinario(arbolNario1);
                    break;
                }
                case "2": {
                    if (arbolNario1 != null) {
                        arbolNario1.escribirNario();
                    } else {
                        System.out.println("Ingrese primero un arbol para poder imprimir");
                    }
                    break;
                }
                case "3": {//grado del arbol
                    if(arbolBinario1!=null){
                        int grado = arbolBinario1.gradoArbol(arbolBinario1.getRaiz());
                        System.out.println("El grado del arbol es: "+grado);
                    }
                    else{
                        System.out.println("Ingrese primero un arbol para poder buscar");
                    }
                    break;
                }
                case "4":{//altura del arbol
                    break;
                }
                case "5":{//numero de hojas
                    break;
                }
                case "6":{//ancestros de un dato
                    System.out.println("Ingrese el dato al que le quiere buscar los ancestros");
                    char dato = sc.nextLine().charAt(0);
                    if(arbolBinario1!=null) {
                        arbolBinario1.ancestros(dato, arbolBinario1.getRaiz());
                        System.out.println();
                    }
                    else{
                        System.out.println("Ingrese primero un arbol para poder buscar");
                    }
                    break;
                }
                case "7":{//recorrido inorden
                    break;
                }
                case "8":{//recorrido preorden
                    break;
                }
                case "9":{//recorrido posorden
                    break;
                }
                case "10":{//grado de un dato
                    System.out.println("Ingrese el dato al que le quiere buscar el grado:");
                    char x = sc.nextLine().charAt(0);
                    if(arbolBinario1!=null) {
                        System.out.println("El grado del dato es: "+arbolBinario1.gradoDato(x));
                    }
                    else{
                        System.out.println("Ingrese primero un arbol para poder buscar");
                    }
                    break;
                }
                case "11":{//recorrido por niveles
                    break;
                }
                case "12":{
                    salir = true;
                    break;
                }
            }
        }
    }
}