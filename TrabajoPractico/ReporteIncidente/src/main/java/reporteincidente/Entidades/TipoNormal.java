
package reporteincidente.Entidades;


public class TipoNormal implements TipoComplejidad {

    @Override
    public int tiempoDeResolucion() {
        return 1;
    }

    @Override
    public int cantidadTecnicos() {
        return 1;
    }

    @Override
    public int estado() {
        return 0;
    }
    
}
