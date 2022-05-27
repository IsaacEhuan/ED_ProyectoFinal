/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abb;

/**
 * Execepcion lanzada cuando un dato no se encuentra en un Arbol
 * @author jorge.reyes
 */
public class ItemNotFoundException extends RuntimeException{
    
    /**
     *Crea una nueva excepcion con el mensaje ingresado
     * @param msg Mensaje de la execepción
     */
    public ItemNotFoundException(String msg){
      super(msg);
    }
    
}
