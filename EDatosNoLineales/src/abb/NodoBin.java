/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abb;

import listas.ListaSimple;

/**
 *Nodo que tiene un dato izquierdo y uno derecho
 * @author jorge.reyes
 */
public class NodoBin {

    /**
     *Dato del nodo
     */
    protected Object dato;

    /**
     *Nodo izquierdo de este nodo
     */
    protected NodoBin izq;

    /**
     *Nodo derecho de este nodo
     */
    protected NodoBin der;

    /**
     *Lista simple con los indices de un estructura de datos
     */
    protected ListaSimple duplicados;

    public NodoBin(Object dato, NodoBin izq, NodoBin der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
        duplicados = new ListaSimple();
    }

    public NodoBin(Object dato){
       this(dato,null,null);
       duplicados = new ListaSimple();
    }
    
    public NodoBin(){
        this(null);
        duplicados = new ListaSimple();
    }

    public void add(int i){
        duplicados.insertaFinal(i);
    }

    /**
     * Lista simple con los indices de un estructura de datos en donde se encuentra exactamente el mismo dato
     * @return Lista simple con duplicados
     */
    public ListaSimple getDuplicados(){
        return duplicados;
    }

    /**
     * Imprime en consola la lista de duplicados
     */
    public void printDuplicados(){
        duplicados.imprimir();
    }
    
    /**
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }

    public void posOrden(){
       if(izq!=null)
           izq.posOrden();     
       if(der!=null)
           der.posOrden();
       System.out.println(dato);//Raiz
    }
    
    /**
     * impresion en consola preOrden
     */
    public void preOrden(){
    System.out.println(dato);//Raiz    
    if(izq!=null)
           izq.preOrden();     
       if(der!=null)
           der.preOrden();
       
    }
    
    /**
     *Impresion en consola InOrden
     */
    public void inOrden(){ //IRD
       if(izq!=null)
           izq.inOrden();
     System.out.println(dato);//Raiz
       if(der!=null)
           der.inOrden();
    }

    /**
     *Funcion que retorna todos los indices InOrden del Arbol que tiene como raiz este NodoBin  
     * @param cabezera Referencia de la lista simple en donde se quiere obtener el resultado
     */
    public void ListaInOrden(ListaSimple cabezera){
        if(izq!=null){
            izq.ListaInOrden(cabezera);
        }
        cabezera.unirFinal(duplicados);
        if(der!=null){
            der.ListaInOrden(cabezera);
        }
    }
    
    /**
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * @return the izq
     */
    public NodoBin getIzq() {
        return izq;
    }

    /**
     * @param izq the izq to set
     */
    public void setIzq(NodoBin izq) {
        this.izq = izq;
    }

    /**
     * @return the der
     */
    public NodoBin getDer() {
        return der;
    }

    /**
     * @param der the der to set
     */
    public void setDer(NodoBin der) {
        this.der = der;
    }
    
    
}
