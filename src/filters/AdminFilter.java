package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import dao.UsuarioDao;
import model.Usuario;


//	@WebFilter("/login") // no se usa
public class AdminFilter implements Filter {
	private Integer ES_ADMIN = 1;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String username = (String) ((HttpServletRequest)request).getParameter("username");
		UsuarioDao asistenteDao = new UsuarioDao();
		Usuario usuario = asistenteDao.findByUsername(username);
		
		if (ES_ADMIN.equals(usuario.getEsAdmin())) {
			
			chain.doFilter(request, response);
			
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/interfaces/pantallaUsuario.jsp");
			dispatcher.forward(request, response);			
		}
	}

}