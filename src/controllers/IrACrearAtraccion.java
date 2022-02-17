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

import dao.AtraccionDao;
import dao.TipoAtraccionDao;
import model.Atraccion;
import model.TipoAtraccion;

@WebServlet("/irACrearAtraccion")
public class IrACrearAtraccion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AtraccionDao AtraccionDao;

	public IrACrearAtraccion() {
		super();
	}

	public void init() {
		AtraccionDao = new AtraccionDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Atraccion> atracciones = AtraccionDao.all();
			request.setAttribute("atracciones", atracciones);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/atracciones/altaAtraccion.jsp");
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
