package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import model.Atraccion;
import util.HibernateUtil;

public class AtraccionDao {
	
	@SuppressWarnings("unchecked")
	public List<Atraccion> all() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			return (List<Atraccion>) session.createQuery("from Atraccion a")
					.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	@SuppressWarnings("unchecked")
	public List<Atraccion> allActivos() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			return (List<Atraccion>) session.createQuery("from Atraccion a WHERE a.activo = 1")
					.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	public boolean create(Atraccion atraccion) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			session.beginTransaction();

			int lastId = (int) session.createQuery("select max(a.id) from Atraccion a").uniqueResult();
			atraccion.setId(++lastId);

			session.save(atraccion);
			session.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Atraccion atraccion) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			session.beginTransaction();

			session.update(atraccion);
			session.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Atraccion findByNombre(String nombre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
            return (Atraccion) session
            		.createQuery("FROM Atraccion A WHERE A.nombre = :nombre")
            		.setParameter("nombre", nombre)
            		.uniqueResult();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	
	public Atraccion findById(Integer valueOf) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
            return (Atraccion) session
            		.createQuery("FROM Atraccion A WHERE A.id = :id")
            		.setParameter("id", valueOf)
            		.uniqueResult();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

}