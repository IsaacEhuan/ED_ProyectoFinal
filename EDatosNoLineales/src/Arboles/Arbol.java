package Arboles;



import archivos.LectorArchivo;
import archivos.VerificadorArchivo;
import avl.*;

public class Arbol {
    public static ArbolAVL ArbolNombres;
    public static ArbolAVL ArbolProfesion;
    public static ArbolAVL ArbolCalificacion;

    public static Egresado[] listaEgresados;


    public static void setArboles(Egresado[] listaEgresados){
        //Saltar el primero, que es la raiz 
        for(int i=1; i< listaEgresados.length; i++){
            Egresado actula = listaEgresados[i];
            ArbolCalificacion.insertarInt(actula.calificacion, i);
            ArbolNombres.insertarString(actula.nombre, i);
            ArbolProfesion.insertarString(actula.profesion,i);
        }
    }

    public static void obtenerInformacion(String archivo) throws Exception{
        //Obtener Contenido
        VerificadorArchivo.verificarExistenciaArchivo(archivo);
        VerificadorArchivo.verificarArchivoVacio(archivo);
        VerificadorArchivo.verificarNumeroColumnas(archivo, ',', 3);
        
        String[][] lista =LectorArchivo.obtenerContenido(archivo, ',');
        int lineas = lista.length;
        System.out.println(lineas);


        //Construir la lista
        listaEgresados = new Egresado[lineas];
        /*
        for(String[] actual: lista){
            int calificacion = Integer.parseInt(actual[2]);
            listaEgresados[i] = new Egresado(actual[0], actual[1], calificacion);
            System.out.println(listaEgresados[i]);
        }
        */
        for(int i=0;i< lineas;i++){
            String[] actual = lista[i];
            int calificacion = Integer.parseInt(actual[2]);
            listaEgresados[i] = new Egresado(actual[0], actual[1], calificacion);
        }

        /*
        for(Egresado e: listaEgresados){
            System.out.println(e);
        }
        */

        //Inicializar siempre asi los arboles, de otra forma la raiz siempre es nula
        Egresado raiz = listaEgresados[0];
        ArbolCalificacion = new ArbolAVL(raiz.calificacion, 0);
        ArbolNombres = new ArbolAVL(raiz.nombre, 0);
        ArbolProfesion = new ArbolAVL(raiz.profesion, 0);

        //Setear Los arboles para el resto del arreglo
        setArboles(listaEgresados);



    }

    public static void main(String[] args) {

        //Creen el arrayList de egresados
        /*
        ArrayList<Egresado> lista = new ArrayList<Egresado>();
        lista.add(new Egresado("Abril Guadalupe Escobedo Bojórquez", "Licenciado en Derecho", 77));
        lista.add(new Egresado("David Pat", "Licenciado en Derecho", 77));
        */

        //Como usar la clase
        String nombreArchivo = "C:/Users/picar/Desktop/Software/Estructura de Datos/ProyectoFinal/ED_ProyectoFinal/EDatosNoLineales/src/Interfaz/Egresados.csv";

        try {
            obtenerInformacion(nombreArchivo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-Calificacione-");
        ArbolCalificacion.inOrden();
        
        System.out.println("-Nombre-");
        ArbolNombres.inOrden();

        System.out.println("-Profesion-");
        ArbolProfesion.inOrden();



    }
    
}
