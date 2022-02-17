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

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UsuarioDao usuarioDao;

    public void init() {
        usuarioDao = new UsuarioDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (usuarioDao.validate(username, password)) {
            Usuario usuario = usuarioDao.findByUsername(username);
            request.getSession().setAttribute("currentUser", usuario.getUsername());
            request.getSession().setAttribute("UsuarioId", usuario.getId());
            request.getSession().setAttribute("es_admin", usuario.getEsAdmin());

            RequestDispatcher dispatcher = request.getRequestDispatcher("/saludo");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }

    }

}