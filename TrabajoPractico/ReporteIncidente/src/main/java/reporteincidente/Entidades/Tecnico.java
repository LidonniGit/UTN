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
@Table(name = "tecnico")
public class Tecnico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private String dni;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "email")
    private String email;

    @Column(name = "whatsapp")
    private String whatsapp;

    @Column(name = "Noti")
    private boolean noti;

    @OneToMany
    private List<Especialidad> especialidad;

    public Tecnico() {
    }

    public Tecnico(String nombre, String apellido, String dni, boolean estado, String email, String whatsapp, boolean noti, List<Especialidad> especialidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.estado = estado;
        this.email = email;
        this.whatsapp = whatsapp;
        this.noti = noti;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " - " + apellido + " - " + dni;
    }

}
