
package reporteincidente.Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "incidente")
public class Incidente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechainicio")
    private Date fechaInicio;
    
    @Column(name="estado")
    private boolean estado;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne()
    private Tecnico tecnico;

    public Incidente() {
    }

    public Incidente(String descripcion, Date fechaInicio, boolean estado, Cliente cliente, Tecnico tecnico) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.cliente = cliente;
        this.tecnico = tecnico;
    }
    
     
    
}
