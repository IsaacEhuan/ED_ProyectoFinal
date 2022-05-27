/*

 */
package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Lee los archivos de texto 
 * @author David Pat
 */
public class LectorArchivo {
    
    /**
     * Obtiene todo el contenido de un archivo de texto, separandolo por columnas y filas. 
     * @param ruta Cadena de la dirección del archivo
     * @param separador carcter por el cual separar cada fila del archivo
     * @return Arreglo con arreglos de Cadenas con el contenido del archivo
     * @throws FileNotFoundException
     */
    public static String[][] obtenerContenido(String ruta, char separador) throws FileNotFoundException{
        int lineas = lineasArchivo(ruta);
        String[][] retornar = new String[lineas][];
        
        File archivo = new File(ruta);
        Scanner  lector;
        lector = new Scanner(archivo);
        String[] separar;
        int i =0;
        while(lector.hasNextLine()){
            String linea = lector.nextLine();
            separar = linea.split(String.valueOf(separador));
            retornar[i] = separar;
            i++;
        }
        lector.close(); 
        return retornar;
    }
    

    private static int lineasArchivo(String ruta) throws FileNotFoundException{
        File archivo = new File(ruta);
        Scanner  lector;
        lector = new Scanner(archivo);
        int i=0;
        while(lector.hasNextLine()){
            lector.nextLine();
            i++;
        }
        lector.close();
        return i; 

    }
    
}
