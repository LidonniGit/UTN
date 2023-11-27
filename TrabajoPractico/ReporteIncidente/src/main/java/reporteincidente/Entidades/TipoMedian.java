
package reporteincidente.Entidades;


public class TipoMedian implements TipoComplejidad {

    @Override
    public int tiempoDeResolucion() {
       return 12;
    }

    @Override
    public int cantidadTecnicos() {
       return 2;
    }

    @Override
    public int estado() {
        return 1;
       
    }
    
}
