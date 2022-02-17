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
import dao.ItinerarioDao;
import dao.UsuarioDao;
import model.Atraccion;
import model.Itinerario;
import model.Usuario;
import system.Catalogador;


@WebServlet("/UsuarioComprarAtraccion")
public class UsuarioComprarAtraccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AtraccionDao atraccionDao;
	private UsuarioDao usuarioDao;
	private ItinerarioDao itinerarioDao;
	
	public void init() {
		usuarioDao = new UsuarioDao();
		atraccionDao = new AtraccionDao();
		itinerarioDao = new ItinerarioDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Atraccion atraccion = atraccionDao.findById(Integer.parseInt(request.getParameter("AtraccionId")));
			Usuario usuario = usuarioDao.findById((Integer) request.getSession().getAttribute("UsuarioId"));
			Itinerario itinerario = new Itinerario();
			
			itinerario.setIdAtraccion(atraccion.getId());
			itinerario.setIdUsuario(usuario.getId());
			
			usuario.comprar(atraccion);
			atraccion.comprado();
			
			usuarioDao.update(usuario);
			atraccionDao.update(atraccion);
			itinerarioDao.create(itinerario);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/atraccionesUsuario");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
