package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pos.data.UsuarioBIZ;
import pos.data.UsuarioBean;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		procesarAccion(accion,request,response);
	}
	
	public void procesarAccion(String accion, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if ( accion.equals("entrar") ){
			entrar(request,response);
		}
	}
	
	public void entrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idUser = request.getParameter("user");
		String password = request.getParameter("password");
		
		UsuarioBIZ userBIZ = new UsuarioBIZ();
		if ( idUser != null && password != null && !idUser.equals("") && !password.equals("") ){
			if ( userBIZ.comprobarUsuario(idUser,password) ){
			//	UsuarioBean user = userBIZ.recuperaUsuario(idUser);
				request.getSession().setAttribute("usuario", idUser);
				request.getRequestDispatcher("index2.html").include(request,response);
			}else{
				request.getRequestDispatcher("falloUsuario.html").include(request,response);
			}
		}
		
	}

}