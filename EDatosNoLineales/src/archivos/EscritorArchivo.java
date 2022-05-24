/*

 */
package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author pat
 */
public class EscritorArchivo {

    public static void escribirArray(String direccion, ArrayList<Object> Lista) throws IOException {
        File archivo = new File(direccion);
        //Escritores
        FileWriter escriva;
        escriva = new FileWriter(archivo);
        PrintWriter escritor = new PrintWriter(escriva);

        //Bucle escribir
        for (Object o : Lista) {
            escritor.println(o);
        }
        escritor.close();
    }

}
