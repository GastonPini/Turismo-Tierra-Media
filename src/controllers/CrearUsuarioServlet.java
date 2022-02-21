package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import dao.TipoAtraccionDao;
import dao.UsuarioDao;
import model.TipoAtraccion;
import model.Usuario;


@WebServlet("/nuevoUsuario")
public class CrearUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDao usuarioDao;

	private TipoAtraccionDao tipoAtraccionDao;

	public void init() {
		usuarioDao = new UsuarioDao();
		tipoAtraccionDao = new TipoAtraccionDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Double presupuesto = Double.parseDouble(request.getParameter("dineroDisponible"));
			Double tiempoDisponible = Double.parseDouble(request.getParameter("tiempoDisponible"));
			TipoAtraccion preferencia = tipoAtraccionDao.findById(Integer.valueOf(request.getParameter("preferencia")));

			Integer esAdmin;
			if (null != request.getParameter("es_admin")) {
				esAdmin = Integer.parseInt(request.getParameter("es_admin"));
			} else {
				esAdmin = 0;
			}

			Integer activo;
			if (null != request.getParameter("activo")) {
				activo = Integer.parseInt(request.getParameter("activo"));
			} else {
				activo = 0;
			}

			Usuario usuario = new Usuario();

			usuario.setUsername(username);
			usuario.setPassword(password);
			usuario.setDineroDisponible(presupuesto);
			usuario.setTiempoDisponible(tiempoDisponible);
			usuario.setAtraccionPreferida(preferencia);
			usuario.setEsAdmin(esAdmin);
			usuario.setActivo(activo);

			usuarioDao.create(usuario);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/usuarios");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}