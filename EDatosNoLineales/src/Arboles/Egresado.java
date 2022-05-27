package Arboles;

/**
 * Contenedor de la información de los egresados, para facilitar el paso de información
 * @author David Pat
 */
public class Egresado {

    /**
     *Nombre del egresado
     */
    public String nombre;

    /**
     *Profesión del egresado
     */
    public String profesion;
    
    /**
     *Calificación del egresado
     */
    public int calificacion;

    /**
     *Consrtructor unico del egresado
     * @param nombre Nombre del egresado
     * @param profesion Profesión del egresado
     * @param calificacion Calificación del egresado
     */
    public Egresado(String nombre, String profesion, int calificacion){
        this.calificacion = calificacion;
        this.nombre = nombre;
        this.profesion= profesion;
    }

    /**
     *Convierte Egresado a cadena
     * @return Cadena con Nombre|Profesion|Calificacion
     */
    @Override
    public String toString(){
        return nombre+"|"+profesion+"|"+String.valueOf(calificacion);
    }


}
