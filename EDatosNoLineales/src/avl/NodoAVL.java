/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

import abb.NodoBin;

/**
 *
 * @author jorge.reyes
 */
public class NodoAVL extends NodoBin{
    protected int FE;
    protected NodoAVL padre;

    public NodoAVL(){}
    
    public NodoAVL(Object o){
        super(o);
    }
    
    public NodoAVL(Object o,NodoAVL i, NodoAVL d){
        super(o,d,i);
    }
    
    public NodoAVL(Object o,NodoAVL i, NodoAVL d, NodoAVL p){
        super(o,d,i);
        padre = p;
    }
    
    public static int altura(NodoAVL a){
       if (a == null)
           return -1;
       else
           return 1 + 
           Math.max(altura((NodoAVL)a.getIzq()), altura((NodoAVL)a.getDer()));
    }
    
    public void inOrden(){
    if(izq!=null)
           ((NodoAVL)izq).inOrden();
     System.out.print(dato + "| FE :" + FE +" {");//Raiz
     printDuplicados();
     System.out.print("}");
     System.out.println();
       if(der!=null)
           ((NodoAVL)der).inOrden();
    }
    
    public void preOrden(){
        System.out.print(dato + "| FE :" + FE +" {");//Raiz
        printDuplicados();
        System.out.print("}");
        System.out.println();
        if(izq!=null)
           ((NodoAVL)izq).preOrden();     
       if(der!=null)
           ((NodoAVL)der).preOrden();
    }
    
    public void posOrden(){    
        if(izq!=null)
           ((NodoAVL)izq).posOrden();     
       if(der!=null)
           ((NodoAVL)der).posOrden();
           System.out.print(dato + "| FE :" + FE +" {");//Raiz
           printDuplicados();
           System.out.print("}");
           System.out.println();
    }
    
    /**
     * @return the FE
     */
    public int getFE() {
        return FE;
    }

    /**
     * @param FE the FE to set
     */
    public void setFE(int FE) {
        this.FE = FE;
    }

    /**
     * @return the padre
     */
    public NodoAVL getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(NodoAVL padre) {
        this.padre = padre;
    }
    
}
