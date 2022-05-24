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
    
    public static ArrayList<String[]> obtenerContenido(String ruta, char separador) throws FileNotFoundException{
        ArrayList<String[]> retornar = new ArrayList<String[]>();
        
        File archivo = new File(ruta);
        Scanner  lector;
        lector = new Scanner(archivo);
        String[] separar;
        while(lector.hasNextLine()){
            String linea = lector.nextLine();
            separar = linea.split(String.valueOf(separador));
            retornar.add(separar);
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
    
}
