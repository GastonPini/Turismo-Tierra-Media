package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import model.TipoAtraccion;

import util.HibernateUtil;

public class TipoAtraccionDao {

	public TipoAtraccion findById(Integer id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			return (TipoAtraccion) session.createQuery("FROM TipoAtraccion U WHERE U.id = :id").setParameter("id", id)
					.uniqueResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<TipoAtraccion> all() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			return (List<TipoAtraccion>) session.createQuery("from TipoAtraccion u").getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

}