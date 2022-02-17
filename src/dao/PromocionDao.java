package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import model.Promocion;
import model.Usuario;
import util.HibernateUtil;

public class PromocionDao {

	public List<Promocion> all() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			return (List<Promocion>) session.createQuery("from Promocion p").getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	public boolean create(Promocion Promocion) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			session.beginTransaction();

			int lastId = (int) session.createQuery("select max(p.id) from Promocion p").uniqueResult();
			Promocion.setId(++lastId);

			session.save(Promocion);
			session.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Promocion findByNombre(String nombre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
            return (Promocion) session
            		.createQuery("FROM Promocion P WHERE P.nombre = :nombre")
            		.setParameter("nombre", nombre)
            		.uniqueResult();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
}
