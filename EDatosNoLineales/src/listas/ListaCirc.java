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
public abstract class ListaCirc extends Lista {
    
    @Override
    public void imprimir(){
    Nodo actual = inicio;
    if (!vacio())
        if (inicio == ultimo)
                System.out.println(actual.getDato());
        else{
            do{
                System.out.print(actual.getDato()+"->");
                actual = actual.getSiguiente();
            }while(actual!=inicio);
            
        }
    }
    
}
