/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;


import java.io.File;
import java.util.Scanner;


/**
 *
 * @author A17003603
 */
public class VerificadorArchivo {
    
    public static void verificarExistenciaArchivo(String ruta)throws Exception{
        String rutaAbsoluta = ruta;
        File archivo = new File(rutaAbsoluta);
        if(!archivo.exists()){
            throw new Exception("El archivo 'Egresados.csv' no existe o \n se encuentra en directorio diferente"
                    + "\n Ruta: "+ archivo.getAbsolutePath());
        }
    }
    
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
