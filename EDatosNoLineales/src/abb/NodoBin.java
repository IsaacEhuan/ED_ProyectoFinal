/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abb;

import listas.ListaSimple;

/**
 *
 * @author jorge.reyes
 */
public class NodoBin {
    protected Object dato;
    protected NodoBin izq;
    protected NodoBin der;
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
    public ListaSimple getDuplicados(){
        return duplicados;
    }

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
    
    public void preOrden(){
    System.out.println(dato);//Raiz    
    if(izq!=null)
           izq.preOrden();     
       if(der!=null)
           der.preOrden();
       
    }
    
    public void inOrden(){ //IRD
       if(izq!=null)
           izq.inOrden();
     System.out.println(dato);//Raiz
       if(der!=null)
           der.inOrden();
    }

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
