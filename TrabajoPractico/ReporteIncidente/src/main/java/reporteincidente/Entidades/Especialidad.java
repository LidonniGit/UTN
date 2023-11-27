package reporteincidente.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "especialidad")
public class Especialidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "tipo", unique = true)
    private String tipo;

    @Column(name = "complejidad")
    private int complejidad; 
    @OneToOne(mappedBy = "especialidad")
    private Servicio servicio;

    
    public Especialidad() {
    }

    public Especialidad(String tipo, int complejidad) {
        this.tipo = tipo;
        this.complejidad = complejidad;
       
    }
    
    @Override
    public String toString() {
        return id + " - " + tipo + " - " + complejidad;
    }

}
