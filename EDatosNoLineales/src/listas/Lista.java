/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author jorge.reyes
 */
public abstract class Lista {
    protected Nodo inicio;
    protected Nodo ultimo;
    protected String nombre;
    
    public Lista(){
        this("lista");
    }
    
    public Lista(String nombre){
        this.nombre = nombre;
        inicio = ultimo = null;
    }
    
    public abstract void insertaInicio(Object dato);
    public abstract void insertaFinal(Object dato);
    public abstract Object eliminaInicio();
    public abstract Object eliminaFinal();   

    /**
     * @return the inicio
     */
    public Nodo getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the ultimo
     */
    public Nodo getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean vacio(){
        return inicio==null;
    }

    public int tamanio(){
        Nodo actual = inicio;
        int i=0;
        while (actual!=null){
            i++;
            actual = actual.getSiguiente();
        }

        return i;
    }
    
    public void imprimir(){
    Nodo actual = inicio;
        while (actual!=null){
            System.out.print(actual.getDato()+ " ");
            actual = actual.getSiguiente();
        }
    }
    
}
