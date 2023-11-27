package reporteincidente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReporteIncidente {

    //creo mi administrador de entidades
    public static EntityManager getEntityManager() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ReporteIncidenteJPA-PU");
        EntityManager manager = factory.createEntityManager();
        return manager;

    }

    public static void main(String[] args) {

//        EntityManager em = getEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        ArrayList<Servicio> listaDeServicio = new ArrayList<>();
//        //COMIENZO MI TRANSACCION
//        tx.begin();
//        Cliente clienteUno = new Cliente("FORD", 2021222324L, "ford@ford.com", true, listaDeServicio);
//        em.persist(clienteUno);
//        //TERMINO MI TRANSACCION
//        tx.commit();
//
//        //COMIENZO MI TRANSACCION
//        tx.begin();
//        Servicio servicio1 = new Servicio("WINDOWS", "TODO SOBRE WINDOWS", clienteUno);
//        em.persist(servicio1);
//        //TERMINO MI TRANSACCION
//        tx.commit();
//
//        //COMIENZO MI TRANSACCION
//        tx.begin();
//        Servicio servicio2 = new Servicio("MAC", "TODO SOBRE MAC", clienteUno);
//        em.persist(servicio2);
//        //TERMINO MI TRANSACCION
//        tx.commit();
//
//        listaDeServicio.add(servicio1);
//        listaDeServicio.add(servicio2);
//        
//        clienteUno.setServicios(listaDeServicio);
//        //COMIENZO MI TRANSACCION
//        tx.begin();
//        em.merge(clienteUno);
//        //TERMINO MI TRANSACCION
//        tx.commit();
//        ArrayList<Servicio> listaDeServicio = new ArrayList<>();
//        Cliente clienteUno = new Cliente("FORD", 2021222324L, "ford@ford.com", true, listaDeServicio);
//        
//       ClienteJpaController clienteJpa=new ClienteJpaController();
//        ServicioJpaController servicioJpa=new ServicioJpaController();
//        
//        clienteJpa.create(clienteUno);
//
//        Servicio servicio1 = new Servicio("WINDOWS", "TODO SOBRE WINDOWS", clienteUno);
//        servicioJpa.create(servicio1);
//        
//        Servicio servicio2 = new Servicio("MAC", "TODO SOBRE MAC", clienteUno);
//        servicioJpa.create(servicio2);
//        
//        
//        listaDeServicio.add(servicio1);
//        listaDeServicio.add(servicio2);
//        
//        clienteUno.setServicios(listaDeServicio);
//        
//        try {
//            clienteJpa.edit(clienteUno);
//        } catch (Exception ex) {
//            Logger.getLogger(ReporteIncidente.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Complejidad complejidad1=new Complejidad();
//        System.out.println(complejidad1.getEstado());
//
//        Especialidad especialidad1=new Especialidad("PHOTOSHOP", complejidad1.getEstado());
//        Especialidad especialidad1 = new Especialidad();
//        Especialidad especialidad2 = new Especialidad();
//        
//
//        EspecialidadJpaController especialidadControl = new EspecialidadJpaController();
//        especialidadControl.create(especialidad1);
//
//        especialidad1=especialidadControl.findEspecialidad(1);
//        especialidad2=especialidadControl.findEspecialidad(3);
//        ArrayList<Especialidad> listaDeEsp=new ArrayList<>();
//        listaDeEsp.add(especialidad1);
//        listaDeEsp.add(especialidad2);
//        
//        Tecnico tecnico1=new Tecnico("FABIAN", "Lidonni", "25252525", true, "lido@gmail.com", "15151515", true, listaDeEsp);
//        TecnicoJpaController tecnicoControl=new TecnicoJpaController();
//        
//        tecnicoControl.create(tecnico1);
//        
//        IncidenteJpaController controlIncidente=new IncidenteJpaController();
//        Cliente clienteBus=new Cliente();
//        
//        clienteBus=clienteJpa.findCliente(1);
//        Incidente incidente1=new Incidente("NO HAY SISTEMA", new Date(23, 11, 25), true, clienteBus, tecnico1);
//                
//        controlIncidente.create(incidente1);
    }
}
