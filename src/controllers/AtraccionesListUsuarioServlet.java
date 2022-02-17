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
import dao.UsuarioDao;
import model.Atraccion;
import model.Usuario;
import system.Catalogador;


@WebServlet("/atraccionesUsuario")
public class AtraccionesListUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AtraccionDao atraccionDao;
	private Catalogador catalogador;
	private UsuarioDao usuarioDao;
	
	public void init() {
		atraccionDao = new AtraccionDao();
		catalogador = new Catalogador();
		usuarioDao = new UsuarioDao();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Atraccion> atracciones = atraccionDao.allActivos();
			Usuario usuario = usuarioDao.findById((Integer) request.getSession().getAttribute("UsuarioId"));
			
			List<Atraccion> atraccionesOrdenadas = catalogador.listaDeSugerencias(usuario, atracciones);
			
			request.setAttribute("atracciones", atraccionesOrdenadas);
			request.setAttribute("usuario", usuario);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/atracciones/listcompraratracciones.jsp");
			dispatcher.forward(request, response);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
