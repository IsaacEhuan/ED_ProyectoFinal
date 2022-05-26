package Arboles;



import archivos.LectorArchivo;
import archivos.VerificadorArchivo;
import avl.*;
import listas.*;

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
        for(int i=0;i< lineas;i++){
            String[] actual = lista[i];
            int calificacion = Integer.parseInt(actual[2]);
            listaEgresados[i] = new Egresado(actual[0], actual[1], calificacion);
        }

        //Inicializar siempre asi los arboles, de otra forma la raiz siempre es nula
        Egresado raiz = listaEgresados[0];
        ArbolCalificacion = new ArbolAVL(raiz.calificacion, 0);
        ArbolNombres = new ArbolAVL(raiz.nombre, 0);
        ArbolProfesion = new ArbolAVL(raiz.profesion, 0);

        //Setear Los arboles para el resto del arreglo
        setArboles(listaEgresados);



    }
//-----------------------Funciones de busqueda-------------------------------------
    public static ListaSimple busquedaIndividual(String comparador, ArbolAVL arbol){
       ListaSimple referencias = new ListaSimple();
        boolean band=true;
        NodoAVL nodoActual = arbol.raiz;
       // NodoAVL nodoAux = null;
      
            while(band){
                if(((String)nodoActual.getDato()).equals(comparador)){
                    referencias = nodoActual.getDuplicados();
                    band=false;
                } else{
                    if (((String)nodoActual.getDato()).compareTo(comparador)<0){
                        nodoActual = (NodoAVL)nodoActual.getDer();
                       
                    } else{
                        nodoActual = (NodoAVL)nodoActual.getIzq(); 
                    }
                
                  }
                }
            
        return referencias;
    
    
    }


    public static ListaSimple busquedaIndividual(int comparador, ArbolAVL arbol){
        ListaSimple referencias = new ListaSimple();
        boolean band=true;
        NodoAVL nodoActual = arbol.raiz;
      
            while(band){
                if((int)nodoActual.getDato() == comparador){
                    referencias = nodoActual.getDuplicados();
                    band=false;
                } else{
                    if((int)nodoActual.getDato() > comparador){
                        nodoActual = (NodoAVL)nodoActual.getIzq();
                    } else{
                        nodoActual = (NodoAVL)nodoActual.getDer();
                    }
                }
            }
            
        
        return referencias;
    }

    public static ListaSimple busquedaDoble(int comparador,String comparador2){
        //Esta función puede filtrar el promedio y el otro parametro (profesión)
        ListaSimple promedio = busquedaIndividual(comparador, ArbolCalificacion);
        ListaSimple profesion = busquedaIndividual(comparador2, ArbolProfesion);
        ListaSimple retorno = new ListaSimple();
        Nodo actualProfesion = profesion.getInicio();
        Nodo actualPromedio = promedio.getInicio();

        while (actualProfesion != null && actualPromedio != null){
            if((int)actualProfesion.getDato() == (int)actualPromedio.getDato()){
                retorno.insertaFinal(actualPromedio.getDato());
                actualProfesion = actualProfesion.getSiguiente();
                actualPromedio = actualPromedio.getSiguiente();
            } else{
                if((int)actualProfesion.getDato() < (int)actualPromedio.getDato()){
                    actualProfesion = actualProfesion.getSiguiente();
                } else{
                    actualPromedio = actualPromedio.getSiguiente(); 
                }
            }
            System.out.println("");
        }
        return retorno;
      }
    /*  Esta busqueda no tiene caso, basta con el nombre exacto
    public static void busquedaDoble(String comparador,String comparador2, ArbolAVL arbol){
        //Esta funcion solo puede filtrar nombre y promedio
      
      }*/  

//-------------------------------------------------------------------------------------    

    public static void main(String[] args) {
        
        //Ruta de Pat:
        String nombreArchivo = "C:/Users/picar/Desktop/Software/Estructura de Datos/ProyectoFinal/ED_ProyectoFinal/EDatosNoLineales/src/Interfaz/Egresados.csv";
        
        //Ruta Isaac
        //String nombreArchivo = "C:\\Users\\isaac\\Downloads\\ED_ProyectFinal\\ED_ProyectoFinal\\EDatosNoLineales\\src\\Interfaz\\Egresados.csv";
        
        //Ruta de Daroz:
        //String nombreArchivo = "/home/daroz/Programas/Estrucutra/proyecto/ED_ProyectoFinal/EDatosNoLineales/src/Interfaz/Egresados.csv";

        try {
            obtenerInformacion(nombreArchivo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-Calificacione-");
        ArbolCalificacion.inOrden();
        System.out.println("Indices con 90: ");
        busquedaIndividual(90, ArbolCalificacion).imprimir();
        //System.out.println(ArbolCalificacion.raiz.getDato());
        System.out.println("-Nombre-");
        //ArbolNombres.inOrden();

        System.out.println("-Profesion-");
        ArbolProfesion.inOrden();

        

        System.out.println("");
        System.out.println("");
        //System.out.println(ArbolProfesion.raiz.getDato());

        //System.out.println("Buscando la carrera: Arquitecto");
        //busquedaIndividual("Mdico Cirujano", ArbolProfesion).imprimir();
        System.out.println("");

        /*System.out.println("Buscando el nombre: Jorge Antonio Zumárraga Novelo");
        busquedaIndividual("Jorge Antonio Zumárraga Novelo", ArbolNombres).imprimir();
        System.out.println("");*/
        //busquedaDoble(77, "Médico Veterinario Zootecnista").imprimir();

    }
    
}
