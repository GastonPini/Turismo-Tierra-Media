package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import dao.UsuarioDao;
import model.Usuario;


@WebServlet("/usuarios")
public class UsuariosListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDao usuarioDao;
	
	public void init() {
		usuarioDao = new UsuarioDao();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Usuario> usuarios = usuarioDao.all();
			
			request.setAttribute("usuarios", usuarios);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/usuarios/list.jsp");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}