package com.rectangulo;

import java.util.Stack;

public class arbolBinario {

    private nodoDoble raiz;

    public nodoDoble getRaiz() { return raiz; }

    public void setRaiz(nodoDoble raiz) {
        this.raiz = raiz;
    }

    public arbolBinario(arbolNario arbolito) {
        nodoLG p,q = new nodoLG();
        nodoDoble x, ultimo = new nodoDoble(null);
        Stack<Object> pila = new Stack<Object>(); //Por verificar
        p = arbolito.getRaiz();
        x = new nodoDoble(p.getDato());
        raiz = x;
        ultimo = x;
        p = p.getLiga();
        while(p!=null){
            if(!p.getSwitche()){
                x = new nodoDoble(p.getDato());
            }
            else{
                q = (nodoLG) p.getDato();
                x = new nodoDoble(q.getDato());
                pila.push(x);
                pila.push(q.getLiga());
            }
            ultimo.setLigai(x);
            ultimo = x;
            p = p.getLiga();
            while(p!=null){
                if(!p.getSwitche()){
                    x = new nodoDoble(p.getDato());
                }
                else{
                    q = (nodoLG) p.getDato();
                    x = new nodoDoble((q.getDato()));
                    pila.push(x);
                    pila.push(q.getLiga());
                }
                ultimo.setLigad(x);
                ultimo = x;
                p = p.getLiga();
            }
            if(!pila.isEmpty()){
                p = (nodoLG) pila.pop();
                ultimo = (nodoDoble) pila.pop();
            }
        }
    }

    public boolean hoja(nodoDoble x){
        if(x.getLigad()==null && x.getLigai()==null){return true;}
        else return false;
    }

    public boolean esVacio () {
        if (raiz == null) return true;
        else return false;
    }

    public nodoDoble padre(nodoDoble x, nodoDoble p){
        nodoDoble q = new nodoDoble();
        nodoDoble pad = new nodoDoble();
        q = null;
        if (x != null){
            if(x.getLigai() != null){
                q = x.getLigai();
                if (q == p){
                    pad = x;
                }
            }
            if (pad == null){
                if (x.getLigad() != null){
                    q = x.getLigad();
                    if(q == p){
                        pad = x;
                    }
                }
                if (pad == null){ pad = padre(x.getLigai(), p); }
                if (pad == null){ pad = padre(x.getLigad(), p);}
            }
        }
        return pad;
    }

    public void ancestros(nodoDoble x){
        nodoDoble p = new nodoDoble();
        Stack<nodoDoble> pila = new Stack<nodoDoble>();
        p = padre(getRaiz(), x);
        while(p != null){
            pila.push(p);
            p = padre(getRaiz(), p);
        }
        while(!pila.empty()){
            p = (nodoDoble)pila.pop();
            System.out.println(p.getDato());

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
        if (x != null){
            System.out.println(x.getDato());
            preorden(x.getLigai());
            preorden(x.getLigad());
        }
    }

}