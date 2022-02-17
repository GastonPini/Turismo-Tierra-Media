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

import dao.PromocionDao;
import model.Promocion;


/**
 * Servlet implementation class AtraccionesListServlet
 */
@WebServlet("/promocionesUsuario")
public class PromocionesListUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PromocionDao PromocionDao;
	
	public void init() {
		PromocionDao = new PromocionDao();
	}
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Promocion> promocion = PromocionDao.all();
			request.setAttribute("promociones", promocion);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/promociones/listcomprarpromociones.jsp");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
