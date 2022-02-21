package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import model.Usuario;


@WebServlet("/saludo")
public class Saludo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private UsuarioDao usuarioDao;
    
    public void init() {
		usuarioDao = new UsuarioDao();
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = (String) request.getSession().getAttribute("currentUser");
        request.setAttribute("usuario", usuario);
        
       
        int UsuarioId = (Integer) request.getSession().getAttribute("UsuarioId");
        request.setAttribute("UsuarioId", UsuarioId);

        int es_admin = (Integer) request.getSession().getAttribute("es_admin");
        request.setAttribute("es_admin", es_admin);
        
        Usuario objUsuario = usuarioDao.findById(UsuarioId);
        request.setAttribute("objUsuario", objUsuario);

        if(es_admin == 1) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/interfaces/pantallaAdmin.jsp");
            dispatcher.forward(request, response);
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/interfaces/pantallaUsuario.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        doGet(request, response);
    }

}