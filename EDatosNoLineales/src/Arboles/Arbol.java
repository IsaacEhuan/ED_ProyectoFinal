package Arboles;



import archivos.LectorArchivo;
import archivos.VerificadorArchivo;
import avl.*;
import listas.*;

/**
 * Clase en la cual se encuentran los tres Arboles AVL de manera publica, asi como el Arreglode los Egresados
 * @author David Pat
 */
public class Arbol {

    /**
     * ArbolAVL que contiene Cadenas con los nombres de los Egresados en cada Nodo. Un solo nombre por nodo,  estas no se repiten.
     * Tiene una lista con todos los nombres repetidos, al no haber nombres repetidos esta lista solo tiene un elemento
     */
    public static ArbolAVL ArbolNombres;

    /**
     *ArbolAVL que contiene las Cadenas con las Profesiones de los Egresados en cada Nodo. Una sola profesión por nodo, estas no se repiten.
     *Cada nodo contiene una lista con todos los indices en donde las profesiones son repetidas.
     */
    public static ArbolAVL ArbolProfesion;

    /**
     *ArbolAVL que contiene Enteros con las Calificaciones de los Egresados en cada Nodo. Una sola calificación por nodo, estas no se repiten.
     * Cada nodo contiene una lista con todos los indices en donde las Calificacion es repetida.
     */
    public static ArbolAVL ArbolCalificacion;

    /**
     *Arreglo con todos los egresados
     */
    public static Egresado[] listaEgresados;

    /**
     * Inicializa los tres Arboles AVL para los Nombre, Profesiones y Calificaciones
     * @param listaEgresados lista estatica de la clase donde se encuentran los Egresados
     */
    public static void setArboles(Egresado[] listaEgresados){
        //Saltar el primero, que es la raiz 
        for(int i=1; i< listaEgresados.length; i++){
            Egresado actula = listaEgresados[i];
            ArbolCalificacion.insertarInt(actula.calificacion, i);
            ArbolNombres.insertarString(actula.nombre, i);
            ArbolProfesion.insertarString(actula.profesion,i);
            
        }
    }

    /**
     *Inicializa el arreglo de Egresados, asi como construye los tres Arboles AVL necesarios
     * @param archivo Ruta del archivo para obtener la información 
     * @throws Exception Arroja el mensaje verificando el formato del archivo
     */
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

    /**
     *Busqueda de una cadena entre los nodos de un Arbol AVL, regresando la lista de sus repeticiones
     * @param comparador cadea a encontrar entre los datos de los Nodos del arbol
     * @param arbol ArbolAVL en el cula buscar
     * @return Lista simple que contiene solo los indices de ListaEgresados, ordenada de manera ascendente
     */
    public static ListaSimple busquedaIndividual(String comparador, ArbolAVL arbol) {
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

    /**
     *Busqueda de un entero entre los nodos de un Arbol AVL, regresando la lista de sus repeticiones
     * @param comparador entero a encontrar entre los datos de los Nodos del arbol
     * @param arbol ArbolAVL en el cula buscar
     * @return Lista simple que contiene solo los indices de ListaEgresados, ordenada de manera ascendente
     */
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

    /**
     * Busqueda avanzada en la cual se obtienen todos los indices que intersectan las condiciones ingresadas  
     * @param comparador Entero a bucar en el Arbol de Calificaciones
     * @param comparador2 Cadena a buscar en el Arbol de Nombres
     * @return Lista simple de los indices de ListaEgresados coincidentes con las condiciones de los dos parametros
     */
    public static ListaSimple busquedaDobleNombre(int comparador,String comparador2){
        //Esta función puede filtrar el promedio y el otro parametro (nombre)
        ListaSimple promedio = busquedaIndividual(comparador, ArbolCalificacion);
        ListaSimple nombre = busquedaIndividual(comparador2, ArbolNombres);
        ListaSimple retorno = new ListaSimple();
        Nodo actualNombre = nombre.getInicio();
        Nodo actualPromedio = promedio.getInicio();

        while (actualNombre != null && actualPromedio != null){
            if((int)actualNombre.getDato() == (int)actualPromedio.getDato()){
                retorno.insertaFinal(actualPromedio.getDato());
                actualNombre = actualNombre.getSiguiente();
                actualPromedio = actualPromedio.getSiguiente();
            } else{
                if((int)actualNombre.getDato() < (int)actualPromedio.getDato()){
                    actualNombre = actualNombre.getSiguiente();
                } else{
                    actualPromedio = actualPromedio.getSiguiente(); 
                }
            }
            System.out.println("");
        }
        return retorno;
      }

    /**
     * Busqueda avanzada en la cual se obtienen todos los indices que intersectan las condiciones ingresadas  
     * @param comparador Cadena a bucar en el Arbol de Profesiones
     * @param comparador2 Cadena a buscar en el Arbol de Nombres
     * @return Lista simple de los indices de ListaEgresados coincidentes con las condiciones de los dos parametros
     */
    public static ListaSimple busquedaDobleNombreProf(String comparador,String comparador2){
        //Esta función puede filtrar el nombre y el otro parametro (profesión)
        ListaSimple profesion = busquedaIndividual(comparador, ArbolProfesion);
        ListaSimple nombre = busquedaIndividual(comparador2, ArbolNombres);
        ListaSimple retorno = new ListaSimple();
        Nodo actualNombre = nombre.getInicio();
        Nodo actualProfesion = profesion.getInicio();

        while (actualNombre != null && actualProfesion != null){
            if((int)actualNombre.getDato() == (int)actualProfesion.getDato()){
                retorno.insertaFinal(actualProfesion.getDato());
                actualNombre = actualNombre.getSiguiente();
                actualProfesion = actualProfesion.getSiguiente();
            } else{
                if((int)actualNombre.getDato() < (int)actualProfesion.getDato()){
                    actualNombre = actualNombre.getSiguiente();
                } else{
                    actualProfesion = actualProfesion.getSiguiente(); 
                }
            }
            System.out.println("");
        }
        return retorno;
      }
    
    /**
     * Busqueda avanzada en la cual se obtienen todos los indices que intersectan las condiciones ingresadas  
     * @param comparador Entero a bucar en el Arbol de Calificaciones
     * @param comparador2 Cadena a bucar en el Arbol de Profesiones
     * @return Lista simple de los indices de ListaEgresados coincidentes con las condiciones de los dos parametros
     */
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

    /**
     * Demostración de las funcionalidades de la clase
     * @param args
     */

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
        ArbolCalificacion.ListaInOrden().imprimir();
        System.out.println();
        ArbolCalificacion.inOrden();
        System.out.println("Indices con 90: ");
        //busquedaIndividual(90, ArbolCalificacion).imprimir();
        //System.out.println(ArbolCalificacion.raiz.getDato());
        System.out.println("-Nombre-");
        ArbolNombres.ListaInOrden().imprimir();
        ArbolNombres.inOrden();

        System.out.println("-Profesion-");
        //ArbolProfesion.inOrden();

        

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
