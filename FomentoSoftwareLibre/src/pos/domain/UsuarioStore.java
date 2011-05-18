package pos.domain;

import java.util.List;

import pos.data.IUsuarioDAO;
import pos.data.JDBCUsuarioDAO;

public class UsuarioStore implements IUsuarioDAO {
	
	private JDBCUsuarioDAO userDAO;
	
	/**
	 * 	CONSTRUCTOR DE LA CLASE
	 */
	public UsuarioStore(){
		userDAO = new JDBCUsuarioDAO();
	}
	
	public boolean comprobarUsuario(String idUser, String password){
		return userDAO.comprobarUsuario(idUser,password);
	}
	
	public Usuario recuperarUsuario(String nombreUsuario){
		return userDAO.recuperarUsuario(nombreUsuario);
	}
	
	public Usuario recuperarUsuarioByIdUsuario(String idUser){
		return userDAO.recuperarUsuario(idUser);
	}
	
	public void insertarUsuario(Usuario user){
		userDAO.insertarUsuario(user);
	}
	
	public List<Usuario> recuperarTODOS(){
		return userDAO.recuperarTODOS();
	}
	
	public void borrarUsuario(String idUser){
		userDAO.borrarUsuario(idUser);
	}
	
	public void actualizarUsuario(Usuario u){
		userDAO.actualizarUsuario(u);
	}
	
	public Usuario recuperarUsuarioByNick(String nick){
		return userDAO.recuperarUsuarioByNick(nick);
	}
	
	public void actualizaKarmaUsuario(String idUser, int karma){
		userDAO.actualizaKarmaUsuario(idUser, karma);
	}
}
