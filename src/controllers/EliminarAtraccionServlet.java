package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import dao.AtraccionDao;
import model.Atraccion;


@WebServlet("/eliminarAtraccion")
public class EliminarAtraccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AtraccionDao AtraccionDao;

	public void init() {
		AtraccionDao = new AtraccionDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Atraccion atraccion = AtraccionDao.findById(id);
			
			atraccion.setActivo(0);
			AtraccionDao.update(atraccion);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/atracciones");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}