package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Aplicacion;
import pos.domain.AplicacionImpl;
import pos.domain.Voto;
import pos.domain.VotoImpl;

public class JDBCVotarDAO implements IVotarDAO {
	
	 private Connection conn;
	 
	 public JDBCVotarDAO (){
		 conn = ConnectionManager.getInstance().checkOut();
	 }

	@Override
	public List<Voto> selectAll() {
		String sql = "SELECT * FROM votos ";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Voto> res = null;
		
		try {
			stmt = conn.prepareStatement(sql);

			result = stmt.executeQuery();
			res = new LinkedList<Voto>();
			
			while(result.next()){
			Voto voto = new VotoImpl();
			voto.setUsuario(result.getInt("IDUsuario"));
			voto.setAplicacion(result.getInt("IDAplicacion"));
			voto.setValor(result.getBoolean("valor"));
			res.add(voto);
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
	public List<Voto> selectVotosByUser(Integer idUser) {
		String sql = "SELECT * FROM votos WHERE (IDUsuario = ?)" ;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Voto> res = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idUser);

			result = stmt.executeQuery();
			res = new LinkedList<Voto>();
			
			while(result.next()){
			Voto voto = new VotoImpl();
			voto.setUsuario(result.getInt("IDUsuario"));
			voto.setAplicacion(result.getInt("IDAplicacion"));
			voto.setValor(result.getBoolean("valor"));
			res.add(voto);
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
	public List<Voto> selectVotoByAplicacion(Integer Aplicacion) {
		String sql = "SELECT * FROM votos WHERE (IDAplicacion = ?)" ;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Voto> res = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Aplicacion);

			result = stmt.executeQuery();
			res = new LinkedList<Voto>();
			
			while(result.next()){
			Voto voto = new VotoImpl();
			voto.setUsuario(result.getInt("IDUsuario"));
			voto.setAplicacion(result.getInt("IDAplicacion"));
			voto.setValor(result.getBoolean("valor"));
			res.add(voto);
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
	public void insertVoto(Voto voto) {
		String sql = "INSERT INTO votos(IDUsuario, IDAplicacion, valor) " +
				"VALUES ( ?, ?, ?)" ;
		
		PreparedStatement stmt1 = null;
		ResultSet result1 = null;
		
		try {
			stmt1 = conn.prepareStatement(sql);
			stmt1.setInt(1, voto.getUsuario());
			stmt1.setInt(2, voto.getAplicacion());
			stmt1.setBoolean(3, voto.getValor());
						
			stmt1.executeUpdate();
			
			Aplicacion apli = getAplicacion(voto);
			updateAplicacion(voto, apli);
			
			
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result1 != null) {
					result1.close();
				}
				if (stmt1 != null ) {
					stmt1.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public void deleteVoto(Integer voto) {
		String sql = "DELETE FROM votos WHERE IDVoto = ?";
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, voto);
						
			stmt.executeUpdate();
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
	}
	
	private Aplicacion getAplicacion(Voto voto){
		String sq3 = "Select * FROM aplicaciones WHERE IDAplicacion = ?";
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		Aplicacion apli = new AplicacionImpl();
		
		try {
			stmt = conn.prepareStatement(sq3);
			stmt.setInt(1, voto.getAplicacion());
			result = stmt.executeQuery();
			
			result.next();
			
			apli.setNombre(result.getString("nombre"));
			apli.setDescripcion(result.getString("descripcion"));
			apli.setFechaPublicacion(result.getDate("fechaPublicacion"));
			apli.setURLWeb(result.getString("URLWeb"));
			apli.setVotosAFavor(result.getInt("numeroVotosAFavor"));
			apli.setVotosEnContra(result.getInt("numeroVotosEnContra"));
						
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
		
		return apli;		
	}
	
	private void updateAplicacion(Voto voto, Aplicacion apli){
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		String sq;
		if(voto.getValor()){
			sq = "UPDATE aplicaciones SET numeroVotosAFavor = ? " +
			"WHERE aplicaciones.IDAplicacion = ?";
		}else{
			sq = "UPDATE aplicaciones SET numeroVotosEnContra = ? " +
			"WHERE aplicaciones.IDAplicacion = ?";			
		}
		try {
			
		stmt = conn.prepareStatement(sq);
		if(voto.getValor()){
			stmt.setInt(1, apli.getVotosAFavor()+1);
			
		}else{
			stmt.setInt(1, apli.getVotosEnContra()+1);
		}
		stmt.setInt(2, voto.getAplicacion());
		
		stmt.executeUpdate();				
		
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
		
		
	}

}