
package reporteincidente.Entidades;

public class Complejidad {
    
    private TipoComplejidad comp;

    public Complejidad() {
        
        this.comp= new TipoNormal();   
    }

    public void setComp(TipoComplejidad comp) {
        this.comp = comp;
    }
     
    public void setNivel(int nivel){
        
        if (nivel==1){
            this.comp= new TipoMedian();
        }else {
            this.comp=new TipoComplejo();
        }
    }

    public int getEstado() {
        return comp.estado();
    }

    @Override
    public String toString() {
        return this.comp.tiempoDeResolucion()+"";
    }
    
    
}
