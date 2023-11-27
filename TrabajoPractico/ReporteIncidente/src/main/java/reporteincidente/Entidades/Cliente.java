
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
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name="cliente")
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;
    
    @Column(name = "razonsocial")
    private String razonSocial;
    
    @Column(name = "cuit")
    private long cuit;
    
    @Column(name="email")
    private String email;
    
    @Column(name="estado")
    private boolean estado;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    //@JoinColumn(name = "Servicio_Id", referencedColumnName = "id")
    private List<Servicio> servicios;

    public Cliente() {
    }

    public Cliente(String razonSocial, long cuit, String email, boolean estado, List<Servicio> servicios) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.email = email;
        this.estado = estado;
        this.servicios = servicios;
    }
    
    


    
}
