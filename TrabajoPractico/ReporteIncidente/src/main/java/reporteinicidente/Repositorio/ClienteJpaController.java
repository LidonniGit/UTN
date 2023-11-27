/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reporteinicidente.Repositorio;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import reporteincidente.Entidades.Servicio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import reporteincidente.Entidades.Cliente;
import reporteinicidente.Repositorio.exceptions.NonexistentEntityException;

/**
 *
 * @author Li Donni
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ClienteJpaController() {
        emf = Persistence.createEntityManagerFactory("ReporteIncidenteJPA-PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        if (cliente.getServicios() == null) {
            cliente.setServicios(new ArrayList<Servicio>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Servicio> attachedServicios = new ArrayList<Servicio>();
            for (Servicio serviciosServicioToAttach : cliente.getServicios()) {
                serviciosServicioToAttach = em.getReference(serviciosServicioToAttach.getClass(), serviciosServicioToAttach.getId());
                attachedServicios.add(serviciosServicioToAttach);
            }
            cliente.setServicios(attachedServicios);
            em.persist(cliente);
            for (Servicio serviciosServicio : cliente.getServicios()) {
                Cliente oldClienteOfServiciosServicio = serviciosServicio.getCliente();
                serviciosServicio.setCliente(cliente);
                serviciosServicio = em.merge(serviciosServicio);
                if (oldClienteOfServiciosServicio != null) {
                    oldClienteOfServiciosServicio.getServicios().remove(serviciosServicio);
                    oldClienteOfServiciosServicio = em.merge(oldClienteOfServiciosServicio);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getId());
            List<Servicio> serviciosOld = persistentCliente.getServicios();
            List<Servicio> serviciosNew = cliente.getServicios();
            List<Servicio> attachedServiciosNew = new ArrayList<Servicio>();
            for (Servicio serviciosNewServicioToAttach : serviciosNew) {
                serviciosNewServicioToAttach = em.getReference(serviciosNewServicioToAttach.getClass(), serviciosNewServicioToAttach.getId());
                attachedServiciosNew.add(serviciosNewServicioToAttach);
            }
            serviciosNew = attachedServiciosNew;
            cliente.setServicios(serviciosNew);
            cliente = em.merge(cliente);
            for (Servicio serviciosOldServicio : serviciosOld) {
                if (!serviciosNew.contains(serviciosOldServicio)) {
                    serviciosOldServicio.setCliente(null);
                    serviciosOldServicio = em.merge(serviciosOldServicio);
                }
            }
            for (Servicio serviciosNewServicio : serviciosNew) {
                if (!serviciosOld.contains(serviciosNewServicio)) {
                    Cliente oldClienteOfServiciosNewServicio = serviciosNewServicio.getCliente();
                    serviciosNewServicio.setCliente(cliente);
                    serviciosNewServicio = em.merge(serviciosNewServicio);
                    if (oldClienteOfServiciosNewServicio != null && !oldClienteOfServiciosNewServicio.equals(cliente)) {
                        oldClienteOfServiciosNewServicio.getServicios().remove(serviciosNewServicio);
                        oldClienteOfServiciosNewServicio = em.merge(oldClienteOfServiciosNewServicio);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cliente.getId();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<Servicio> servicios = cliente.getServicios();
            for (Servicio serviciosServicio : servicios) {
                serviciosServicio.setCliente(null);
                serviciosServicio = em.merge(serviciosServicio);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cliente findCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Cliente> buscarPorCuit(Long cuit) {
//        EntityManager em = getEntityManager();
//        Object resultado;
//        try {
//            // Crear y ejecutar la consulta
//            Query query;
//            query = em.createQuery("SELECT e FROM Cliente e WHERE e.cuit = :valor");
//            query.setParameter("valor", cuit);
//
//            // Obtener el resultado de la consulta
//            resultado = query.getSingleResult();
//
//        } catch (EntityNotFoundException enfe) {
//
//            resultado = null;
//
//        } finally {
//            em.close();
//        }
//        return (Cliente) resultado;

        EntityManager em = getEntityManager();
        String jpql = "SELECT u FROM Cliente u WHERE u.cuit = :valor";
        Query query = em.createQuery(jpql);
        query.setParameter("valor", cuit);

        List<Cliente> resultados = query.getResultList();

        return resultados;

    }

}
