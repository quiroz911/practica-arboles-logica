package com.rectangulo;

import java.sql.SQLOutput;
import java.util.Stack;

public class arbolNario {

    private nodoLG raiz;

    public arbolNario(Object dato) {
        nodoLG x = new nodoLG(dato);
        x.setDato(dato);
        x.setSwitche(false);
        raiz = x;
    }

    //metodo que recibe una hilera y la convierte en arbol n-ario
    public arbolNario(String s){
        int n, i;
        nodoLG primero, ultimo, x;
        Stack pila = new Stack();
        primero = new nodoLG(null);
        ultimo = primero;
        primero.setDato(s.charAt(1));
        n = s.length();
        if (n == 3) {
            return;
        }
        i = 3;
        while (i <= (n - 3)) {
            x = new nodoLG(null);
            ultimo.setLiga(x);
            ultimo = x;
            if (s.charAt(i + 1) == '(') {
                ultimo.setSwitche(true);
                pila.push(ultimo);
                x = new nodoLG(s.charAt(i));
                ultimo.setDato(x);
                ultimo = x;
                i = i + 2;
            } else {
                ultimo.setDato(s.charAt(i));
                if (s.charAt(i + 1) == ')') {
                    i = i + 1;
                    while ((i < (n - 1) && (s.charAt(i) == ')')) && !pila.empty()) {
                        ultimo = (nodoLG) pila.pop();
                        i = i +1;
                    }

                    if (s.charAt(i) == ',') {
                        i = i + 1;
                    }
                } else {
                    i = i + 2;
                }
            }
        }
        raiz=primero;
    }
    //imprime el arbol n-ario como una secuencia de atomos, comas  y parentesis
    public void imprimirNario(nodoLG a){
        System.out.print(a.getDato()+"(");
        nodoLG p = a.getLiga();
        int i = 0;
        while(p!=null){
            i++;
            if(i!=1){
                System.out.print(",");
            }
            if(p.getSwitche()){

                imprimirNario((nodoLG) p.getDato());
            }
            else{
                System.out.print(p.getDato());
            }
            p = p.getLiga();
        }
        System.out.print(")");
    }

    //metodo que invoca imprimirNario y le agrega los parentesis mas externos y la raiz original
    public void escribirNario(){
        System.out.print("(");
        imprimirNario(raiz);
        System.out.print(")");
        System.out.println();
    }

    public nodoLG getRaiz() {
        return raiz;
    }

    public void setRaiz(nodoLG raiz) {
        this.raiz = raiz;
    }
    //metodo que retorna verdadero si el caracter entrado por parametro es una letra en minuscula, falso de lo contrario
    public boolean esAtomo(char hilera){
        return hilera == 'a' || hilera == 'b' || hilera == 'c' || hilera == 'd' || hilera == 'e' || hilera == 'f' || hilera == 'g' || hilera == 'h' || hilera == 'i' || hilera == 'j' || hilera == 'k' || hilera == 'l' || hilera == 'm' || hilera == 'n' || hilera == 'o' || hilera == 'p' || hilera == 'q' || hilera == 'r' || hilera == 's' || hilera == 't' || hilera == 'u' || hilera == 'v' || hilera == 'w' || hilera == 'x' || hilera == 'y' || hilera == 'z';
    }

}
