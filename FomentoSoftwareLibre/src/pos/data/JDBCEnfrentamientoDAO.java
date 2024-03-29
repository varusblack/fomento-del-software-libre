package pos.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;

import pos.domain.Aplicacion;
import pos.domain.Enfrentamiento;
import pos.domain.EnfrentamientoImpl;
import pos.domain.Usuario;
import pos.utils.UIDGenerator;

public class JDBCEnfrentamientoDAO implements IEnfrentamientoDAO {

	// Para obtener un objeto Aplicacion mediante la ID utiliza el m�todo
	// getAplicacionByID
	// de la clase JDBCAplicacionDAO

	public List<Enfrentamiento> selectAll() {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		Enfrentamiento enfrentamiento = null;
		List<Enfrentamiento> lista = new ArrayList<Enfrentamiento>();
		String sql = "SELECT * FROM enfrentamientos";
		PreparedStatement stm = null;
		ResultSet result = null;

		try {
			stm = con.prepareStatement(sql);
			result = stm.executeQuery();
			while(result.next()){
				JDBCAplicacionDAO apliDAO = new JDBCAplicacionDAO();
				
				String IDEnfrentamiento = result.getString("IDEnfrentamiento");
				String IDapl1 = result.getString("IDAplicacion1");
				String IDapl2 = result.getString("IDAplicacion2");
				String descripcion = result.getString("descripcion");
				Integer votosAply1 = result.getInt("votosApp1");
				Integer votosAply2 = result.getInt("votosApp2");
				Date fechaCreacion = result.getDate("fechaCreacion");
				Date fechaFin = result.getDate("fechaFin");
				String IDUsuario = result.getString("IDUsuario");
				Aplicacion aplicacion1 = apliDAO.selectAplicacionByID(IDapl1.toString());
				Aplicacion aplicacion2 = apliDAO.selectAplicacionByID(IDapl2.toString());
				enfrentamiento = new EnfrentamientoImpl(IDEnfrentamiento,aplicacion1,aplicacion2,descripcion,fechaCreacion,fechaFin,votosAply1,votosAply2,IDUsuario);
				lista.add(enfrentamiento);
			}
			
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}
		}
		return lista;
	}

	public Enfrentamiento selectEnfrentamientoByID(String IDEnfrentamiento) {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();
		Enfrentamiento enfrentamiento = null;
		String sql = "SELECT * FROM enfrentamientos WHERE (IDEnfrentamiento = ?)";
		PreparedStatement stm = null;
		ResultSet result = null;

		try {
			stm = con.prepareStatement(sql);
			stm.setString(1,IDEnfrentamiento);
			result = stm.executeQuery();
			while(result.next()){
				JDBCAplicacionDAO apliDAO = new JDBCAplicacionDAO();
				
				String IDapl1 = result.getString("IDAplicacion1");
				String IDapl2 = result.getString("IDAplicacion2");
				String descripcion = result.getString("descripcion");
				Integer votosAply1 = result.getInt("votosApp1");
				Integer votosAply2 = result.getInt("votosApp2");
				Date fechaCreacion = result.getDate("fechaCreacion");
				Date fechaFin = result.getDate("fechaFin");
				String IDUsuario = result.getString("IDUsuario");
				Aplicacion aplicacion1 = apliDAO.selectAplicacionByID(IDapl1.toString());
				Aplicacion aplicacion2 = apliDAO.selectAplicacionByID(IDapl2.toString());
				enfrentamiento = new EnfrentamientoImpl(IDEnfrentamiento,aplicacion1,aplicacion2,descripcion,fechaCreacion,fechaFin,votosAply1,votosAply2,IDUsuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}
		}
		return enfrentamiento;
	}

	public List<Enfrentamiento> selectEnfrentamientoByUserCreator(String IDUser) {
		Connection con = (Connection) ConnectionManager.getInstance()
		.checkOut();

		JDBCAplicacionDAO apliDAO = new JDBCAplicacionDAO();
		List<Enfrentamiento> listaEnf = new ArrayList<Enfrentamiento>();
		Enfrentamiento enfrentamiento = null;
		String sql = "SELECT * FROM enfrentamientos WHERE ( IDUsuario = ? )";
		PreparedStatement stm = null;
		ResultSet result = null;
		
		try{
			stm = con.prepareStatement(sql);
			stm.setString(1,IDUser);
			result = stm.executeQuery();
			while(result.next()){
				String IDEnfrentamiento = result.getString("IDEnfrentamiento");
				String IDapl1 = result.getString("IDAplicacion1");
				String IDapl2 = result.getString("IDAplicacion2");
				String descripcion = result.getString("descripcion");
				Integer votosAply1 = result.getInt("votosApp1");
				Integer votosAply2 = result.getInt("votosApp2");
				Date fechaCreacion = result.getDate("fechaCreacion");
				Date fechaFin = result.getDate("fechaFin");
				String IDUsuario = result.getString("IDUsuario");
				Aplicacion aplicacion1 = apliDAO.selectAplicacionByID(IDapl1.toString());
				Aplicacion aplicacion2 = apliDAO.selectAplicacionByID(IDapl2.toString());
				enfrentamiento = new EnfrentamientoImpl(IDEnfrentamiento,aplicacion1,aplicacion2,descripcion,fechaCreacion,fechaFin,votosAply1,votosAply2,IDUsuario);
				listaEnf.add(enfrentamiento);				
			}
			
		}catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}
		}
		return listaEnf;
	}

	@Override
	public void insertEnfrentamiento(Enfrentamiento enfrentamiento, Usuario usuario) {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		String sql = "INSERT INTO enfrentamientos (IDEnfrentamiento,IDAplicacion1,IDAplicacion2,descripcion,votosApp1,votosApp2,fechaCreacion,fechaFin,IDUsuario,finalizado) VALUES (?,?,?,?,?,?,?,?,?,?) ";
		PreparedStatement stm = null;

		String IDEnfrentamiento = UIDGenerator.getInstance().getKey();
		
		Aplicacion aplicacion1 = enfrentamiento.getAplicacion1();
		Aplicacion aplicacion2 = enfrentamiento.getAplicacion2();
		String IDAply1 = aplicacion1.getIDAplicacion();
		String IDAply2 = aplicacion2.getIDAplicacion();
		String descripcion = enfrentamiento.getDescripcion();
		Date fechaCreacion = enfrentamiento.getFechaCreacion();
		Date fechaFin = enfrentamiento.getFechaFin();
		// Votos se inicializan a 0
		try {
			
			stm = con.prepareStatement(sql);
			stm.setString(1,IDEnfrentamiento);
			stm.setString(2, IDAply1);
			stm.setString(3, IDAply2);
			stm.setString(4, descripcion);
			stm.setInt(5, 0);// votosApp1
			stm.setInt(6, 0);// votosApp2
			stm.setDate(7, (java.sql.Date) fechaCreacion);
			stm.setDate(8, (java.sql.Date) fechaFin);
			stm.setString(9,usuario.getIdUser());
			stm.setInt(10, 0);//por defecto, finalizado = 0

			stm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {

			}
		}
	}

	public void votar(String IDEnfrentamiento, String IDUser,String IDAplicacion) {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		String sql = "INSERT INTO votosusuarioenfrentamiento(IDEnfrentamiento,IDUsuario,IDAplicacion) VALUES (?,?,?)";
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, IDEnfrentamiento);
			stm.setString(2, IDUser);
			stm.setString(3, IDAplicacion);
			stm.executeUpdate();

			puntuar(con, IDEnfrentamiento, IDAplicacion);
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {

			}
		}
	}

	private void puntuar(Connection con, String IDEnfrentamiento,
			String IDAplicacion) {
		String sql1 = "UPDATE enfrentamientos SET enfrentamientos.votosApp1 = ? WHERE enfrentamientos.IDEnfrentamiento = ?";
		String sql2 = "UPDATE enfrentamientos SET enfrentamientos.votosApp2 = ? WHERE enfrentamientos.IDEnfrentamiento = ?";
		PreparedStatement stm = null;

		Enfrentamiento currentEnfrentamiento = selectEnfrentamientoByID(IDEnfrentamiento);
		String IDAply1 = currentEnfrentamiento.getAplicacion1()
				.getIDAplicacion();
		Integer votosAply1 = currentEnfrentamiento.getVotosAplicacion1();
		Integer votosAply2 = currentEnfrentamiento.getVotosAplicacion2();

		try {
			if (IDAplicacion.equals(IDAply1)) {
				stm = con.prepareStatement(sql1);
				stm.setInt(1, (votosAply1 + 1));
				stm.setString(2, IDEnfrentamiento);
				stm.executeUpdate();
			} else {
				stm = con.prepareStatement(sql2);
				stm.setInt(1, (votosAply2 + 1));
				stm.setString(2, IDEnfrentamiento);
				stm.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {

			}
		}
	}

	
	public List<String> getIDUsuariosVotantes(String IDEnfrentamiento){
		Connection con = (Connection) ConnectionManager.getInstance().checkOut();
		
		PreparedStatement stm = null;
		ResultSet result = null;
		List<String> listaIds = new ArrayList<String>();
		String sql = "SELECT IDUsuario FROM votosusuarioenfrentamiento WHERE IDEnfrentamiento = ?";
		
		try{
			stm = con.prepareStatement(sql);
			stm.setString(1,IDEnfrentamiento);
			result = stm.executeQuery();
			
			while(result.next()){
				String iduser = result.getString("IDUsuario");
				listaIds.add(iduser.toString());
			}
		}catch (SQLException e){
			System.out.println("SQLMessage"+e.getMessage());
			System.out.println("SQLState"+e.getSQLState());
			System.out.println("ErrorCode"+e.getErrorCode());
		} finally {
			try{
				if(stm != null){
					stm.close();
				}
				if(result != null){
					result.close();
				}
			}catch (SQLException e){
				
			}
		}
		return listaIds;
	}

	public void finalizarEnfrentamiento(Enfrentamiento enfrentamiento){
		Connection con = (Connection) ConnectionManager.getInstance().checkOut();
		String sql = "UPDATE enfrentamientos SET enfrentamientos.finalizado = 1 WHERE enfrentamientos.IDEnfrentamiento = ?";
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1,enfrentamiento.getIDEnfrentamiento());
			stm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}				
			} catch (SQLException e) {

			}
		}
	}
	
	public List<Enfrentamiento> selectEnfrentamientosVigentes() {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		Enfrentamiento enfrentamiento = null;
		List<Enfrentamiento> lista = new ArrayList<Enfrentamiento>();
		String sql = "SELECT * FROM enfrentamientos WHERE finalizado=0";
		PreparedStatement stm = null;
		ResultSet result = null;

		try {
			stm = con.prepareStatement(sql);
			result = stm.executeQuery();
			JDBCAplicacionDAO apliDAO = new JDBCAplicacionDAO();
			while(result.next()){
				
				String IDEnfrentamiento = result.getString("IDEnfrentamiento");
				String IDapl1 = result.getString("IDAplicacion1");
				String IDapl2 = result.getString("IDAplicacion2");
				String descripcion = result.getString("descripcion");
				Integer votosAply1 = result.getInt("votosApp1");
				Integer votosAply2 = result.getInt("votosApp2");
				Date fechaCreacion = result.getDate("fechaCreacion");
				Date fechaFin = result.getDate("fechaFin");
				String IDUsuario = result.getString("IDUsuario");
				Aplicacion aplicacion1 = apliDAO.selectAplicacionByID(IDapl1.toString());
				Aplicacion aplicacion2 = apliDAO.selectAplicacionByID(IDapl2.toString());
				enfrentamiento = new EnfrentamientoImpl(IDEnfrentamiento,aplicacion1,aplicacion2,descripcion,fechaCreacion,fechaFin,votosAply1,votosAply2,IDUsuario);
				lista.add(enfrentamiento);
			}
			
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}
		}
		return lista;
	}
	
	public List<Enfrentamiento> selectEnfrentamientosVotadosPorUsuario(Usuario usuario){
		List<Enfrentamiento> enfrentamientosVotados = new ArrayList<Enfrentamiento>();
		Enfrentamiento enfrentamiento = null;
		ResultSet result = null;
		PreparedStatement stm = null;
		Connection con = (Connection) ConnectionManager.getInstance().checkOut();
		String sql = "SELECT * FROM votosusuarioenfrentamiento WHERE IDUsuario = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1,usuario.getIdUser());
			result = stm.executeQuery();
			while(result.next()){
				String IDEnfrentamiento = result.getString("IDEnfrentamiento");
				enfrentamiento = this.selectEnfrentamientoByID(IDEnfrentamiento);
				enfrentamientosVotados.add(enfrentamiento);
			}
			
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}
		}
		return enfrentamientosVotados;
	}
}
