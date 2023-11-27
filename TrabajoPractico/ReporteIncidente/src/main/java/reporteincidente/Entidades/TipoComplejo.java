package reporteincidente.Entidades;

public class TipoComplejo implements TipoComplejidad {

    @Override
    public int tiempoDeResolucion() {
        return 24;
    }

    @Override
    public int cantidadTecnicos() {
        return 4;
    }

    @Override
    public int estado() {
        return 2;
    }

}
