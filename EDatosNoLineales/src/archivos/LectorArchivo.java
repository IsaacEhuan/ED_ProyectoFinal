/*

 */
package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pat
 */
public class LectorArchivo {
    
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
    
    public static ArrayList<String> obtenerContenido(String ruta) throws FileNotFoundException{
        ArrayList<String> retornar = new ArrayList<String>();
        File archivo = new File(ruta);
        Scanner  lector;
        lector = new Scanner(archivo);
        while(lector.hasNextLine()){
            String linea = lector.nextLine();
            retornar.add(linea);
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
