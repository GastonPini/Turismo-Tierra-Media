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
import dao.TipoAtraccionDao;
import model.Atraccion;
import model.TipoAtraccion;

@WebServlet("/nuevoAtraccion")
public class CrearAtraccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AtraccionDao atraccionDao;
	private TipoAtraccionDao tipoAtraccionDao;
	
	public void init() {
		tipoAtraccionDao = new TipoAtraccionDao();
		atraccionDao = new AtraccionDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nombre = request.getParameter("Nombre");
			Double presupuesto = Double.parseDouble(request.getParameter("Costo"));
			Double tiempoDisponible = Double.parseDouble(request.getParameter("Tiempo"));
			TipoAtraccion preferencia = tipoAtraccionDao.findById(Integer.valueOf(request.getParameter("Tipo")));
			Integer cupo = Integer.parseInt(request.getParameter("Cupo"));
			
			Integer activo;
			if (null != request.getParameter("activo")) {
				activo = Integer.parseInt(request.getParameter("activo"));
			} else {
				activo = 0;
			}

			
			
			Atraccion atraccion = new Atraccion();
			
			atraccion.setNombre(nombre);
			atraccion.setCosto(presupuesto);
			atraccion.setTiempo(tiempoDisponible);
			atraccion.setTipoAtraccion(preferencia);
			atraccion.setActivo(activo);
			atraccion.setCupo(cupo);

			atraccionDao.create(atraccion);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/atracciones");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
