/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;
//CLASE EN LA QUE SE OBTIENE INFORMACION DEL ARCHIVO IMPORTADO
//ABIERTO A DARLE MAS USOS QUE EL ACTUAL
/**
 *
 * @author donco
 */
public class ArchivoImp {
    public static String rutaArchivo;
    public ArchivoImp(){}
    public ArchivoImp(String ruta){
        rutaArchivo=ruta;
    }
    public static String getRuta(){
        return rutaArchivo;
    }
}
