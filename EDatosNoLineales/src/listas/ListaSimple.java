/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *Lista simple con solo un enlace al siguiente elemento
 * @author jorge.reyes
 */
public class ListaSimple extends Lista{

    /**
     * Insertar un dato como primer elemento de la lista
     * @param dato dato del nodo
     */
    @Override
    public void insertaInicio(Object dato) {
        if (vacio()){
            inicio = ultimo = new Nodo(dato);
        }
        else{
            inicio = new Nodo(dato,inicio);
        }
    }

    @Override
    public void insertaFinal(Object dato) {
        if (vacio()){
            inicio = ultimo = new Nodo(dato);
        }
        else{
            Nodo temp = new Nodo(dato);
            ultimo.setSiguiente(temp);
            ultimo = temp;
        }
    }

    public void unirFinal(ListaSimple listaFinal){
        Nodo actual = listaFinal.inicio;
        while(actual!= null){
            insertaFinal(actual.dato);
            actual = actual.siguiente;
        }

    }

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
            actual.setSiguiente(null);
            ultimo = actual;
        }
    }
    return eliminado;
    }
    
    public void insertaOrdenado(int dato){
        if (vacio())
            insertaInicio(dato);
        else{
            if (inicio == ultimo)
                if (dato < (Integer)inicio.getDato())
                    insertaInicio(dato);
                else
                    insertaFinal(dato);
            else{
                Nodo antes = null, despues = inicio;
                while(despues!=null && dato > (Integer)despues.getDato()){
                    antes = despues;
                    despues = despues.getSiguiente();
                }
                if (antes==null)
                    insertaInicio(dato);
                else
                    if (despues==null)
                        insertaFinal(dato);
                    else{
                        Nodo nuevo = new Nodo(dato,despues);
                        antes.setSiguiente(nuevo);
                    }        
            }
        }                
    }
    
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        /*lista.insertaInicio(34);
        lista.insertaInicio("Hola");
        lista.insertaInicio(34.5);
        lista.insertaInicio("Otro dato");
        lista.insertaFinal("último");
        lista.imprimir();
        System.out.println("Eliminando el último de la lista...");
        System.out.println("Este elemento es:"+lista.eliminaFinal());
        lista.imprimir();
        System.out.println("\nEliminando el primer elemento de la lista... \n");
        System.out.println(lista.eliminaInicio());
        lista.imprimir();*/
        System.out.println("Inserta en Orden");
        lista.insertaOrdenado(34);
        lista.insertaOrdenado(20);
        lista.insertaOrdenado(50);
        lista.insertaOrdenado(23);
        lista.imprimir();        
    }
}
