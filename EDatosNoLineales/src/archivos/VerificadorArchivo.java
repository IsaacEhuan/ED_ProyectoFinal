/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;


import java.io.File;
import java.util.Scanner;


/**
 * Verifica el formato de archivos de texto
 * @author David Pat
 */
public class VerificadorArchivo {
    
    /**
     * Verifica la existencia de un archivo
     * @param ruta Cadena de la dirección del archivo
     * @throws Exception El archivo no existe
     */
    public static void verificarExistenciaArchivo(String ruta)throws Exception{
        String rutaAbsoluta = ruta;
        File archivo = new File(rutaAbsoluta);
        if(!archivo.exists()){
            throw new Exception("El archivo 'Egresados.csv' no existe o \n se encuentra en directorio diferente"
                    + "\n Ruta: "+ archivo.getAbsolutePath());
        }
    }
    
    /**
     * Verifica el numero de columnas que contiene un archivo de texto
     * @param ruta Cadena de la dirección del archivo
     * @param separador Carcter por el cual separar cada fila del archivo
     * @param columnas numero de columnas deseadas que contenga
     * @throws Exception Numero de columnas no esperado
     */
    public static void verificarNumeroColumnas(String ruta,char separador, int columnas) throws Exception{
        File archivo = new File(ruta);
        Scanner  lector;
        lector = new Scanner(archivo);
        int i =0;
        String[] separar;
        while(lector.hasNextLine()){
            i++;
            String linea = lector.nextLine();
            separar = linea.split(String.valueOf(separador));
            if(separar.length!=columnas){
                lector.close(); 
                throw new Exception("Numero de columnas no esperado.\nRenglon: "+i+"\nN.Columnas: "+separar.length);
            }
        }
        lector.close(); 
    }
    
    /**
     * Verifica si un archivo de texto está o no vacio
     * @param ruta Cadena de la dirección del archivo
     * @throws Exception El archivo está vacio
     */
    public static void verificarArchivoVacio(String ruta) throws Exception{
        File archivo = new File(ruta);
        Scanner  lector;
        lector = new Scanner(archivo);
        if(!lector.hasNextLine()){
            lector.close(); 
            throw new Exception("El archivo está vacio");
        }
        lector.close(); 
        
    }
 
    
}
