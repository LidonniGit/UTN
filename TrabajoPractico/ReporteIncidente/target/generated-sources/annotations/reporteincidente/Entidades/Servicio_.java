package reporteincidente.Entidades;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import reporteincidente.Entidades.Cliente;
import reporteincidente.Entidades.Especialidad;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-26T17:52:42", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile SingularAttribute<Servicio, String> descripcion;
    public static volatile SingularAttribute<Servicio, Cliente> cliente;
    public static volatile SingularAttribute<Servicio, String> tipo;
    public static volatile SingularAttribute<Servicio, Integer> id;
    public static volatile SingularAttribute<Servicio, Especialidad> especialidad;

}