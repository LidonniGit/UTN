package reporteincidente.Entidades;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import reporteincidente.Entidades.Especialidad;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-27T19:03:58", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Tecnico.class)
public class Tecnico_ { 

    public static volatile SingularAttribute<Tecnico, String> whatsapp;
    public static volatile SingularAttribute<Tecnico, Boolean> estado;
    public static volatile SingularAttribute<Tecnico, Boolean> noti;
    public static volatile SingularAttribute<Tecnico, String> apellido;
    public static volatile SingularAttribute<Tecnico, Integer> id;
    public static volatile SingularAttribute<Tecnico, String> nombre;
    public static volatile ListAttribute<Tecnico, Especialidad> especialidad;
    public static volatile SingularAttribute<Tecnico, String> dni;
    public static volatile SingularAttribute<Tecnico, String> email;

}