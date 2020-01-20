

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InicioServlet
 */

public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();
		
		ServletConfig configuracion = getServletConfig();
		String nombreDriver = configuracion.getInitParameter("driver");
		salida.print("El driver es"+nombreDriver);
		salida.print("<hr>");
		
		ServletContext contexto = getServletContext();
		String usuario = contexto.getInitParameter("usuario");
		String pwd = contexto.getInitParameter("pwd");
		
		salida.print("El usuarios es:"+usuario);
		salida.print("<hr>");
		salida.print("La constraseña es:"+pwd);
		
		contexto.setAttribute("driver", nombreDriver);
		
		salida.print("<hr>");
		salida.print("<a href='menu'>menu</a>");
		
		Cookie ck = new Cookie("usuario", usuario);
		response.addCookie(ck);
		
		
		salida.print("<form action='acceder'>");
		salida.print("<input type='submit' value='ir'>");
		salida.print("</form>");
		
		salida.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
