package com.rectangulo;

import java.util.Stack;

public class arbolBinario {

    private nodoDoble raiz;
    nodoDoble padre; //variable global que indica el padre de un dato. Se le asigna valor por medio del metodo padre()
    int gradoArbol;
    int hojas;

    public nodoDoble getRaiz() {
        return raiz;
    }

    public void setRaiz(nodoDoble raiz) {
        this.raiz = raiz;
    }

    public nodoDoble getPadre() {
        return padre;
    }

    public void setPadre(nodoDoble padre) {
        this.padre = padre;
    }

    public int getGradoArbol() {
        return gradoArbol;
    }

    public void setGradoArbol(int gradoArbol) {
        this.gradoArbol = gradoArbol;
    }

    public int getHojas() {
        return hojas;
    }

    public void setHojas(int hojas) {
        this.hojas = hojas;
    }

    //Metodo que convierte un arbol n-ario en binario
    public arbolBinario(arbolNario arbolito) {
        nodoLG p, q = new nodoLG();
        nodoDoble x, ultimo = new nodoDoble(null);
        Stack<Object> pila = new Stack<Object>();
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
    public int gradoPadre(){
        nodoDoble p = raiz;
        int cont=0;
        if(p.getLigai()!=null){
            p = p.getLigai();
            while(p!=null){
                p = p.getLigad();
                cont++;
            }
        }
        return cont;
    }

    public int gradoDato(char dato){
        int cont=0;
        nodoDoble p = new nodoDoble();
        //se halla el padre del dato, si el dato es el padre, se llama el metodo de grado de padre
        if(dato == (char) raiz.getDato()){
            return gradoPadre();
        }
        padre(dato, raiz);
        //Se busca donde esta el dato a partir del padre
        if(dato == (char) padre.getLigai().getDato()){
            p = padre.getLigai();
        }
        else{
            p = padre.getLigad();
        }
        //se avanza por la izquierda si se puede
        nodoDoble q = p.getLigai();
        while(q!=null){
            cont++; //se empieza a avanzar por la derecha hasta llegar a nulo aumentando cada vez el contador
            q = q.getLigad();
        }
        return cont;
    }

    public int gradoArbol(nodoDoble r){
        //si el nodo tiene un hijo solo por la izquierda, entonces el grado es el grado del hijo izquierdo
        if(r.getLigai()!=null && r.getLigad()==null){
            gradoArbol = gradoArbol(r.getLigai());
            return gradoArbol;
        }
        //si el nodo tiene un hijo solo por la derecha, entonces el grado es el grado del hijo derecho
        if(r.getLigad()!=null && r.getLigai()==null){
            gradoArbol = gradoArbol(r.getLigad());
            return gradoArbol;
        }
        //si el nodo no tiene hijos, su grado es cero
        if(r.getLigai()==null && r.getLigad()==null){
            return 0;
        }
        //si no ocurre ninguno de los anteriores casos, quiere decir que tiene ambos hijos. El grado sera el mayor entre ambos
        gradoArbol = mayorEntre(gradoArbol(r.getLigai()),gradoArbol(r.getLigad()));
        return gradoArbol;
    }
    //retorna el mayor entre dos numeros
    public int mayorEntre(int x, int y){
        if(x>y){
            return x;
        }
        else{
            return y;
        }
    }
    //imprime el numero de hojas del arbol, utilizando recorrido en preorden. Una hoja es un nudo cuyo campo de liga izquierda es nulo en este caso.
    public void numHojasNario(nodoDoble a){
        if (a != null){
            if(a.getLigai() == null){ hojas = hojas + 1;}
            numHojasNario(a.getLigai());
            numHojasNario(a.getLigad());
        }
    }
    //imprime el arbol en inorden
    public void inorden(nodoDoble x) {
        if (x != null){
            inorden(x.getLigai());
            System.out.print(x.getDato());
            inorden(x.getLigad());
        }
    }
    //imprime el arbol en posorden
    public void posorden(nodoDoble x) {
        if (x != null){
            posorden(x.getLigai());
            posorden(x.getLigad());
            System.out.print(x.getDato());
        }
    }
    //imprime el arbol en preorden
    public void preorden(nodoDoble x) {
        if (x != null) {
            System.out.print(x.getDato());
            preorden(x.getLigai());
            preorden(x.getLigad());
        }
    }
}