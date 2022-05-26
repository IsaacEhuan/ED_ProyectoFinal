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
public class ListaSimpleC extends ListaCirc{

    @Override
    public void insertaInicio(Object dato) {
        if (vacio()){
            inicio = ultimo = new Nodo(dato);
            ultimo.setSiguiente(inicio);
        }
        else{
            inicio = new Nodo(dato,inicio);
            ultimo.setSiguiente(inicio);
        }}

    @Override
    public void insertaFinal(Object dato) {
          if (vacio()){
            inicio = ultimo = new Nodo(dato);
            ultimo.setSiguiente(inicio);
        }
        else{
            Nodo temp = new Nodo(dato);
            ultimo.setSiguiente(temp);
            ultimo = temp;
            ultimo.setSiguiente(inicio);
        }}

    @Override
    public Object eliminaInicio() {
         Object eliminado = null;
    if (vacio())
            System.out.println("La lista está vacía");
    else{
        if(inicio==ultimo){
            eliminado = inicio.getDato();
            inicio = ultimo = null;
        }
        else{
            eliminado = inicio.getDato();
            inicio = inicio.getSiguiente();
            ultimo.setSiguiente(inicio);
        }
    }
    return eliminado;
    }

    @Override
    public Object eliminaFinal() {
        Object eliminado = null;
    if (vacio())
            System.out.println("La lista está vacía");
    else{
        if(inicio==ultimo){
            eliminado = ultimo.getDato();
            inicio = ultimo = null;
        }
        else{
            Nodo actual = inicio;
            while (actual.getSiguiente()!= ultimo){
                actual = actual.getSiguiente();
            }
            eliminado = ultimo.getDato();
            actual.setSiguiente(inicio);
            ultimo = actual;
        }
    }
    return eliminado;
    }
    
    public void insertaOrdenado(int dato){
    
    }
    
    public static void main(String[] args) {
        ListaSimpleC listac = new ListaSimpleC();
        listac.insertaInicio("Hola");
        listac.insertaInicio(34);
        listac.insertaFinal(23.4);
        listac.insertaInicio("Catorce");
        listac.imprimir();
        System.out.println("\nEliminando..."+listac.eliminaFinal());
        listac.imprimir();
        while(!listac.vacio()){
            System.out.println("\nQuitando..."+listac.eliminaInicio());
            listac.imprimir();
        }
    }
}
