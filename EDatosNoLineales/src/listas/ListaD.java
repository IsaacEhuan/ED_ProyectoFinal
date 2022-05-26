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
public abstract class ListaD extends Lista{
    protected NodoDoble inicio;
    protected NodoDoble ultimo;
    
    public boolean vacio(){
        return inicio == null;
    }
    
    public void imprimir(){
        super.setInicio(inicio);
        super.imprimir();
    }
    
    public void imprimirAlReves(){
        if (!vacio()){
            NodoDoble actual = ultimo;
            while(actual!=null){
                System.out.print("<-"+actual.getDato());
                actual = actual.getAnterior();
            }
        }
    }
    
    
}
