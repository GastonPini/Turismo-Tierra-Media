package dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import model.Usuario;
import util.HibernateUtil;


public class UsuarioDao {

	public boolean validate(String username, String password) {

		Usuario user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			user = (Usuario) session.createQuery("FROM Usuario U WHERE U.username = :username")
					.setParameter("username", username).uniqueResult();

			if (user != null && user.getPassword().equals(password)) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean create(Usuario usuario) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.beginTransaction();

			int lastId = (int) session.createQuery("select max(u.id) from Usuario u").uniqueResult();
			usuario.setId(++lastId);

			session.saveOrUpdate(usuario);
			session.getTransaction().commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Usuario usuario) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.beginTransaction();

			session.update(usuario);
			session.getTransaction().commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(Usuario usuario) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.beginTransaction();

			session.delete(usuario);
			session.getTransaction().commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> all() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			List<Usuario> a = (List<Usuario>) session.createQuery("FROM Usuario u").getResultList();
			return a;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> allActivos() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			List<Usuario> a = (List<Usuario>) session.createQuery("FROM Usuario u WHERE u.activo = 1").getResultList();
			return a;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	public Usuario findByUsername(String username) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			return (Usuario) session.createQuery("FROM Usuario U WHERE U.username = :username")
					.setParameter("username", username).uniqueResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario findById(Integer valueOf) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			return (Usuario) session.createQuery("FROM Usuario U WHERE U.id = :id").setParameter("id", valueOf)
					.uniqueResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}