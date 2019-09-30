package com.rectangulo;

import java.util.Stack;

public class arbolNario {

    private nodoLG raiz;

    public arbolNario(Object dato) {
        nodoLG x = new nodoLG(dato);
        x.setDato(dato);
        x.setSwitche(false);
        raiz = x;
    }

   /* public arbolNario(String hilera) {
        int n = hilera.length();
        char[] s;
        s = hilera.toCharArray();
        Stack<nodoLG> pila = new Stack<nodoLG>();
        nodoLG x = new nodoLG(null);
        nodoLG ultimo = x;
        for (int i = 1; i < n-1; i++) {
            if (esAtomo(s[i])) {
                ultimo.setSwitche(false);
                ultimo.setDato(s[i]);
                if (i == 1) {
                    raiz = ultimo;
                }
            }
            if (s[i]==','){
                x = new nodoLG(null);
                ultimo.setLiga(x);
                ultimo = x;
            }
            if(s[i]=='('){
                pila.push(ultimo);
                x = new nodoLG(null);
                ultimo.setSwitche(true);
                ultimo.setDato(x);
                ultimo = x;
            }
            if(s[i]==')'){
                ultimo = pila.pop();
            }
        }
    }
*/
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

    public nodoLG getRaiz() {
        return raiz;
    }

    public void setRaiz(nodoLG raiz) {
        this.raiz = raiz;
    }

    public boolean esAtomo(char hilera){
        return hilera == 'a' || hilera == 'b' || hilera == 'c' || hilera == 'd' || hilera == 'e' || hilera == 'f' || hilera == 'g' || hilera == 'h' || hilera == 'i' || hilera == 'j' || hilera == 'k' || hilera == 'l' || hilera == 'm' || hilera == 'n' || hilera == 'o' || hilera == 'p' || hilera == 'q' || hilera == 'r' || hilera == 's' || hilera == 't' || hilera == 'u' || hilera == 'v' || hilera == 'w' || hilera == 'x' || hilera == 'y' || hilera == 'z';
    }

}
