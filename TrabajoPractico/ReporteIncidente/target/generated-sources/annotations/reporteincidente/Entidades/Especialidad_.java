package reporteincidente.Entidades;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import reporteincidente.Entidades.Servicio;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-27T19:03:58", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Especialidad.class)
public class Especialidad_ { 

    public static volatile SingularAttribute<Especialidad, Integer> complejidad;
    public static volatile SingularAttribute<Especialidad, String> tipo;
    public static volatile SingularAttribute<Especialidad, Servicio> servicio;
    public static volatile SingularAttribute<Especialidad, Integer> id;

}