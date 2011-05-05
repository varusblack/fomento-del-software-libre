package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Encuesta;
import pos.domain.EncuestaImpl;

public class JDBCEncuestaDAO implements IEncuestaDAO {
	
	 private Connection conn;
	 private IPreguntaDAO pdao;
	 
	 public JDBCEncuestaDAO (){
		 conn = ConnectionManager.getInstance().checkOut();
		 pdao = new JDBCPreguntaDAO();
	 }
	 
	 protected void finalize() {
	        ConnectionManager.getInstance().checkIn(conn);
	        
	 }

	@Override
	public void Borrar(String EncuestaID) {
	}

	@Override
	public List<Encuesta> seleccionarTodasEncuestas() {
		String sql = "SELECT * FROM encuestas";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Encuesta> res = new LinkedList<Encuesta>();

		try {
			stmt = conn.prepareStatement(sql);

			result = stmt.executeQuery();

			while(result.next()){
			Encuesta e = new EncuestaImpl();
			e.setTituloEncuesta(result.getString("nombre"));
			res.add(e);
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
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
		}

		return res;
	}

	@Override
	public void insertarEncuesta(Encuesta e) {
		// TODO Auto-generated method stub

	}

	@Override
	public Encuesta recuperarEncuesta(Integer idEncuesta) {
		String sql = "SELECT * FROM encuestas WHERE (IDEncuesta = ? ) ";
		PreparedStatement stmt = null;
		ResultSet result = null;
		Encuesta res = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idEncuesta);

			result = stmt.executeQuery();

			result.next();
			res = new EncuestaImpl();
			res.setTituloEncuesta(result.getString("nombre"));
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
		}

		return res;
	}
}
