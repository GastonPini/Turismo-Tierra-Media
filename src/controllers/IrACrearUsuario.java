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

import dao.TipoAtraccionDao;
import model.TipoAtraccion;

@WebServlet("/irACrearUsuario")
public class IrACrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TipoAtraccionDao tipoAtraccionDao;

	public IrACrearUsuario() {
		super();
	}
	
	public void init() {
		tipoAtraccionDao = new TipoAtraccionDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<TipoAtraccion> tiposAtracciones = tipoAtraccionDao.all();
			request.setAttribute("tiposAtracciones", tiposAtracciones);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/usuarios/altaUsuarios.jsp");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
