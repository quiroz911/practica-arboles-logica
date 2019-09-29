package com.rectangulo;

import java.util.Stack;

public class arbolNario extends nodoLG {

    private nodoLG raiz;

    public arbolNario(Object dato) {
        super(dato);
        nodoLG x = new nodoLG(dato);
        x.setDato(dato);
        x.setSwitche(false);
        raiz = x;
    }

    public arbolNario(String hilera) {
        int n = hilera.length();
        char[] s;
        s = hilera.toCharArray();
        Stack<nodoLG> pila = new Stack<nodoLG>();
        nodoLG x = new nodoLG(null);
        nodoLG ultimo = x;
        for (int i = 1; i < n; i++) {
            if (esAtomo(s[i])) {
                ultimo.setSwitche(false);
                ultimo.setDato(s[i]);
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
