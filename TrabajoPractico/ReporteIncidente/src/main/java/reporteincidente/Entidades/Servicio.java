
package reporteincidente.Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "servicio")
public class Servicio implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @ManyToOne
    //@JoinColumn(name = "cliente_id",referencedColumnName = "id")
    private Cliente cliente;

       
    @OneToOne
    private Especialidad especialidad;
   
    
    public Servicio() {
    }

    public Servicio(String tipo, String descripcion, Cliente cliente, Especialidad especialidad) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.especialidad = especialidad;
    }

     public Servicio(String tipo, String descripcion, Especialidad especialidad) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.especialidad = especialidad;
        this.cliente=null;
    }
   
    @Override
    public String toString() {
        return id+" - "+tipo+ " - "+descripcion;
    }
    
}
