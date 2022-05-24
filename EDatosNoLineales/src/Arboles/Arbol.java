package Arboles;

import java.util.ArrayList;
import java.util.Iterator;

import archivos.LectorArchivo;
import archivos.VerificadorArchivo;
import avl.*;

public class Arbol {
    public static ArbolAVL ArbolNombres;
    public static ArbolAVL ArbolProfesion;
    public static ArbolAVL ArbolCalificacion;

    public static ArrayList<Egresado> listaEgresados;


    public static void setArboles(Iterator<Egresado> listaEgresados){
        //Saltar el primero, que es la raiz
        listaEgresados.next();

        while(listaEgresados.hasNext()){
            Egresado actula = listaEgresados.next();
            int index = actula.getIndex();
            ArbolCalificacion.insertarInt(actula.calificacion, index);
            ArbolNombres.insertarString(actula.nombre, index);
            ArbolProfesion.insertarString(actula.profesion,index);
        }
    }

    public static void obtenerInformacion(String archivo) throws Exception{
        //Obtener Contenido
        VerificadorArchivo.verificarExistenciaArchivo(archivo);
        VerificadorArchivo.verificarArchivoVacio(archivo);
        VerificadorArchivo.verificarNumeroColumnas(archivo, ',', 3);
        
        ArrayList <String[]> lista =LectorArchivo.obtenerContenido(archivo, ',');

        //Construir la lista
        listaEgresados = new ArrayList<Egresado>();
        for(String[] actual: lista){
            int calificacion = Integer.parseInt(actual[2]);
            listaEgresados.add(new Egresado(actual[0], actual[1], calificacion));
        }

        /*
        for(Egresado e: listaEgresados){
            System.out.println(e);
        }
        */

        //Inicializar siempre asi los arboles, de otra forma la raiz siempre es nula
        Egresado raiz = listaEgresados.get(0);
        ArbolCalificacion = new ArbolAVL(raiz.calificacion, raiz.getIndex());
        ArbolNombres = new ArbolAVL(raiz.nombre, raiz.getIndex());
        ArbolProfesion = new ArbolAVL(raiz.profesion, raiz.getIndex());

        //Setear Los arboles para el resto del arreglo
        setArboles(listaEgresados.iterator());



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
