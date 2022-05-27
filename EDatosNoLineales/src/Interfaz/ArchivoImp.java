/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;
//
//
/**
 *CLASE EN LA QUE SE OBTIENE INFORMACION DEL ARCHIVO IMPORTADO
 * ABIERTO A DARLE MAS USOS QUE EL ACTUAL
 * @author donco
 */
public class ArchivoImp {

    /**
     * ruta de un archivo
     */
    public static String rutaArchivo;

    /**
     *Archivo sin ninguna ruta
     */
    public ArchivoImp(){}

    /**
     * Archivo con rutaArchivo ingresada
     * @param ruta Cadena de una ruta
     */
    public ArchivoImp(String ruta){
        rutaArchivo=ruta;
    }

    /**
     * Regresa la ruta de un archivo
     * @return ruta de ArchivoImp
     */
    public static String getRuta(){
        return rutaArchivo;
    }
}
