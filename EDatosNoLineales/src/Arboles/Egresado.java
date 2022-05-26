package Arboles;


public class Egresado {
    public String nombre;
    public String profesion;
    public int calificacion;

    public Egresado(String nombre, String profesion, int calificacion){
        this.calificacion = calificacion;
        this.nombre = nombre;
        this.profesion= profesion;
    }



    public String toString(){
        return nombre+"|"+profesion+"|"+String.valueOf(calificacion);
    }


}
