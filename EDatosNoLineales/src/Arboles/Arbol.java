package Arboles;

import java.util.ArrayList;
import java.util.Iterator;

import avl.*;

public class Arbol {
    public static ArbolAVL ArbolNombres;
    public static ArbolAVL ArbolProfesion;
    public static ArbolAVL ArbolCalificacion;


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

    public static void main(String[] args) {

        //Creen el arrayList de egresados
        ArrayList<Egresado> lista = new ArrayList<Egresado>();
        lista.add(new Egresado("Abril Guadalupe Escobedo Bojórquez", "Licenciado en Derecho", 77));
        lista.add(new Egresado("David Pat", "Licenciado en Derecho", 77));

        //Inicializar siempre asi los arboles, de otra forma la raiz siempre es nula
        Egresado raiz = lista.get(0);
        ArbolCalificacion = new ArbolAVL(raiz.calificacion, raiz.getIndex());
        ArbolNombres = new ArbolAVL(raiz.nombre, raiz.getIndex());
        ArbolProfesion = new ArbolAVL(raiz.profesion, raiz.getIndex());

        //Setear Los arboles para el resto del arreglo
        setArboles(lista.iterator());


        //Solo hay una calificacion
        System.out.println("-Calificacione-");
        ArbolCalificacion.inOrden();
        
        //Hay dos nombres
        System.out.println("-Nombre-");
        ArbolNombres.inOrden();

        //Solo hay una profesion
        System.out.println("-Profesion-");
        ArbolProfesion.inOrden();

        //Aunque sean de tipo Egresado los nodos, pues solo obtegan el dato que les importa dependiendo del arbol.



    }
    
}
