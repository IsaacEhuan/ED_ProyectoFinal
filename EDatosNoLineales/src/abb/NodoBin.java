/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abb;

import java.util.ArrayList;

/**
 *
 * @author jorge.reyes
 */
public class NodoBin {
    protected Object dato;
    protected NodoBin izq;
    protected NodoBin der;
    protected ArrayList<Integer> duplicados;

    public NodoBin(Object dato, NodoBin izq, NodoBin der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
        duplicados = new ArrayList<Integer>();
    }

    public NodoBin(Object dato){
       this(dato,null,null);
       duplicados = new ArrayList<Integer>();
    }
    
    public NodoBin(){
        this(null);
        duplicados = new ArrayList<Integer>();
    }

    public void add(int i){
        duplicados.add(i);
    }
    public ArrayList<Integer> getDuplicados(){
        return duplicados;
    }

    public void printDuplicados(){
        for(int i: duplicados){
            System.out.print(i +" ");
        }
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
