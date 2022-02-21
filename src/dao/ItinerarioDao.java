package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import model.Itinerario;
import util.HibernateUtil;

public class ItinerarioDao {

	public boolean create(Itinerario itinerario) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			session.beginTransaction();

			int lastId = (int) session.createQuery("select max(u.id) from Itinerario u").uniqueResult();
			itinerario.setId(++lastId);

			session.saveOrUpdate(itinerario);
			session.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Itinerario> all() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			return (List<Itinerario>) session.createQuery("from Itinerario u").getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	@SuppressWarnings("unchecked")
	public List<Itinerario> AllById(Integer valueOf) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			return (List<Itinerario>) session.createQuery("FROM Itinerario U WHERE U.idUsuario = :id")
					.setParameter("id", valueOf).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	@SuppressWarnings("unchecked")
	public boolean tieneById(int id, int id2) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			List<Itinerario> itinerario = session
					.createQuery("FROM Itinerario U WHERE U.idUsuario = :idUs AND U.idAtraccion =:idAT")
					.setParameter("idUs", id).setParameter("idAT", id2).getResultList();
			if (!itinerario.isEmpty())
				return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}