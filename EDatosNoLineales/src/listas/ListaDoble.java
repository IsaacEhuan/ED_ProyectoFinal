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
public class ListaDoble extends ListaD{

    @Override
    public void insertaInicio(Object dato) {
        if (vacio())
            inicio = ultimo = new NodoDoble(dato);
        else{
            NodoDoble nuevo = new NodoDoble(dato,inicio,null);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
    }

    @Override
    public void insertaFinal(Object dato) {
        if (vacio()){
           inicio = ultimo = new NodoDoble(dato);           
        }
        else{
          NodoDoble nuevo = new NodoDoble(dato,null,ultimo);
          ultimo.setSiguiente(nuevo);
          ultimo = nuevo;
        }}

    @Override
    public Object eliminaInicio() {
        Object eliminado = null;
        if(vacio())
            System.out.println("Lista vacía");
        else{
          if (inicio == ultimo){
            eliminado = inicio.getDato();
            inicio = ultimo = null; 
          }
          else{
            eliminado = inicio.getDato();
            inicio = inicio.getSiguiente();
            inicio.setAnterior(null);
          }                
        }
        return eliminado;}

    @Override
    public Object eliminaFinal() {
        Object eliminado = null;
        if (vacio()) 
            System.out.println("Lista vacía");
        else{
            if (inicio==ultimo){
                eliminado = ultimo.getDato();
                inicio = ultimo = null;
            }
            else{
                eliminado = ultimo.getDato();
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(null);
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
            NodoDoble antes = null, despues = inicio;
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
                    NodoDoble nuevo = new NodoDoble(dato,despues,antes);
                    antes.setSiguiente(nuevo);
                }        
        }
    }                
    }
    
    public static void main(String[] args) {
        ListaDoble listad = new ListaDoble();
        listad.insertaInicio(1);
        listad.insertaInicio(2);
        listad.insertaInicio(3);
        listad.insertaInicio(4);
        listad.insertaInicio(5);
        listad.insertaFinal(23);
        listad.insertaFinal(56);        
        System.out.println("Impresión normal de la lista");
        listad.imprimir();
        System.out.println("\nImpresión al revés de la lista");
        listad.imprimirAlReves();
        System.out.println("Eliminando elementos de la lista");
        System.out.println(listad.eliminaFinal());
        listad.imprimir();
        while(!listad.vacio()){
            System.out.println("\nEliminando..."+listad.eliminaFinal());
            System.out.println("\nEliminando..."+listad.eliminaInicio());
        }
        /*listad.insertaOrdenado(34);
        listad.insertaOrdenado(15);
        listad.insertaOrdenado(90);
        listad.insertaOrdenado(50);
        listad.insertaOrdenado(3);
        listad.insertaOrdenado(1);
        listad.insertaOrdenado(200);
        listad.insertaOrdenado(60);*/        
        listad.imprimir();
    }
    
}
