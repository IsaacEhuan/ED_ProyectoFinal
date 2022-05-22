package Arboles;


public class Egresado {
    private static int cantidad =0;
    private int index; 
    public String nombre;
    public String profesion;
    public int calificacion;

    public Egresado(String nombre, String profesion, int calificacion){
        this.index= cantidad;
        cantidad++;
        this.calificacion = calificacion;
        this.nombre = nombre;
        this.profesion= profesion;
    }

    public int getIndex(){
        return index;
    }

    public String toString(){
        return String.valueOf(index)+"|"+nombre+","+profesion+","+calificacion;
    }


}
