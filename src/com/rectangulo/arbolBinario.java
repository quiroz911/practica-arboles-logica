package com.rectangulo;

import java.util.Stack;

public class arbolBinario {

    private nodoDoble raiz;
    nodoDoble padre; //variable global que indica el padre de un dato. Se le asigna valor por medio del metodo padre()

    public nodoDoble getRaiz() {
        return raiz;
    }

    public void setRaiz(nodoDoble raiz) {
        this.raiz = raiz;
    }

    //Metodo que convierte un arbol n-ario en binario
    public arbolBinario(arbolNario arbolito) {
        nodoLG p, q = new nodoLG();
        nodoDoble x, ultimo = new nodoDoble(null);
        Stack<Object> pila = new Stack<Object>(); //Por verificar
        p = arbolito.getRaiz();
        x = new nodoDoble(p.getDato());
        raiz = x;
        ultimo = x;
        p = p.getLiga();
        while (p != null) {
            if (!p.getSwitche()) {
                x = new nodoDoble(p.getDato());
            } else {
                q = (nodoLG) p.getDato();
                x = new nodoDoble(q.getDato());
                pila.push(x);
                pila.push(q.getLiga());
            }
            ultimo.setLigai(x);
            ultimo = x;
            p = p.getLiga();
            while (p != null) {
                if (!p.getSwitche()) {
                    x = new nodoDoble(p.getDato());
                } else {
                    q = (nodoLG) p.getDato();
                    x = new nodoDoble((q.getDato()));
                    pila.push(x);
                    pila.push(q.getLiga());
                }
                ultimo.setLigad(x);
                ultimo = x;
                p = p.getLiga();
            }
            if (!pila.isEmpty()) {
                p = (nodoLG) pila.pop();
                ultimo = (nodoDoble) pila.pop();
            }
        }
    }
    //metodo que retorna si el nodo x es una hoja
    public boolean hoja(nodoDoble x) {
        if (x.getLigad() == null && x.getLigai() == null) {
            return true;
        } else return false;
    }

    public boolean esVacio() {
        if (raiz == null) return true;
        else return false;
    }

    //metodo que devuelve el padre de un dato x, este padre esta asignado a la variable global "padre"
    public void padre(char x, nodoDoble r) {
        if(r!=null){
            if(r.getLigai()!=null){
                //si el dato esta en la izquierda, padre sera la raiz
                if(x == (char) r.getLigai().getDato()){
                    padre = r;
                }
                //si no esta en la izquierda, busca en el subarbol izquierdo
                padre(x,r.getLigai());
            }
            if(r.getLigad()!=null){
                //si el dato esta en la derecha, padre sera la raiz
                if(x == (char) r.getLigad().getDato()){
                    padre = r;
                }
                //si no esta en la derecha, busca en el subarbol derecho
                padre(x,r.getLigad());
            }
        }
    }


    //Metodo que escribe los ancestro de un nodo x
    //Se necesita el metodo de padre
    public void ancestros(char dato, nodoDoble r){
        if(dato == (char) raiz.getDato())return; //se valida que el dato no sea la raiz
        //se halla el padre del dato
        padre(dato,raiz);
        //si el dato es hijo por la izquierda, se imprime el padre
        if(padre.getLigai()== null)return; //se valida que el padre tenga hijo izquierdo
        if(dato == (char) padre.getLigai().getDato()){
            System.out.print(padre.getDato()+ ",");
            ancestros((char)padre.getDato(), r);
        }
        else{
            //se halla el padre del padre
            padre((char)padre.getDato(), raiz);
            //mientras no sea hijo por la izquierda y no se llegue a la raiz, se sigue hallando el padre del padre
            while(dato!= (char) padre.getLigai().getDato() && padre!=raiz){
                padre((char)padre.getDato(), raiz);
            }
            System.out.print(padre.getDato()+",");
        }
    }

    public void inorden(nodoDoble x) {
        if (x != null){
            inorden(x.getLigad());
            System.out.println(x.getDato() + ", ");
            inorden(x.getLigai());
        }
    }

    public void posorden(nodoDoble x) {
        if (x != null){
            posorden(x.getLigai());
            posorden(x.getLigad());
            System.out.println(x.getDato() + ", ");
        }
    }
    public void preorden(nodoDoble x) {
        if (x != null) {
            System.out.println(x.getDato());
            preorden(x.getLigai());
            preorden(x.getLigad());
        }
    }
}