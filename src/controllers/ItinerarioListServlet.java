package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import dao.AtraccionDao;
import dao.ItinerarioDao;
import model.Atraccion;
import model.Itinerario;


@WebServlet("/itinerarios")
public class ItinerarioListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ItinerarioDao ItinerarioDao;
	private AtraccionDao AtraccionDao;

	public void init() {
		ItinerarioDao = new ItinerarioDao();
		AtraccionDao = new AtraccionDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Itinerario> itinerarios = ItinerarioDao.AllById((Integer) request.getSession().getAttribute("UsuarioId"));
			List<Atraccion> atracciones = new ArrayList<Atraccion>();
			
			for (Itinerario itinerario : itinerarios) {
				atracciones.add(AtraccionDao.findById(itinerario.getIdAtraccion()));
			}
			request.setAttribute("atracciones", atracciones);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/itinerarios/list.jsp");
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