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
import dao.PromocionDao;
import model.Atraccion;
import model.Promocion;
import nomodel.Absoluta;
import nomodel.AxB;
import nomodel.Porcentual;


@WebServlet("/nuevaPromocion")
public class CrearPromocionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PromocionDao PromocionDao;
	private AtraccionDao AtraccionDao;

	public void init() {
		PromocionDao = new PromocionDao();
		AtraccionDao = new AtraccionDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nombre = request.getParameter("nombre");
			String tipo = request.getParameter("tipo");
			String datoExtra = request.getParameter("datoExtra");
			Promocion promocion;
			
			if (tipo.equals("Porcentual")) {
				promocion = new Porcentual(datoExtra);
			} else if (tipo.equals("Absoluta")) {
				promocion = new Absoluta(datoExtra);
			} else {
				Atraccion atraccionExtra = AtraccionDao.findByNombre(datoExtra);
				promocion = new AxB(atraccionExtra);
			}
			promocion.setNombre(nombre);

			PromocionDao.create(promocion);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/promociones");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
