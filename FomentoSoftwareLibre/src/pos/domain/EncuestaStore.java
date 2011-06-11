package pos.domain;

import java.util.List;

import pos.data.IEncuestaDAO;
import pos.data.IPreguntaDAO;
import pos.data.IRespuestaDAO;
import pos.data.JDBCEncuestaDAO;

public class EncuestaStore implements IEncuestaStore {
	
	private List<Encuesta> le;
	private List<Pregunta> lp;
	private List<Respuesta> lr;
	private IEncuestaDAO edao;
	private Integer encID;
	private Integer pregID;
	private Integer resID;
	
	public EncuestaStore(){
		edao = new JDBCEncuestaDAO();
	}

	@Override
	public boolean insertarEncuesta(Encuesta enc) {
		boolean res = false;
		if (enc.getUsuario().isEmpty()){
			res=false;
		}else{
		if (enc.getTituloEncuesta().isEmpty()){
			res = true;
		}else{
			List<Pregunta> l1= enc.getPreguntas();
			for (Pregunta p : l1){
				for (Respuesta r : p.getRespuestas()){
					if (r.getDescripcionRespuesta().isEmpty()){
						res = true;
						break;
					}
				}
				if (p.getEnunciado().isEmpty()){
					res= true;
					break;
				}
			}
		}
		}

		if (res == false){
			edao.insertarEncuesta(enc);
		}
		return res;
	}

	@Override
	public void borrarEncuesta(String idEncuesta) {
		edao.Borrar(idEncuesta);

	}

	@Override
	public void borrarPregunta(Integer idPregunta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarRespuesta(Integer idRespuesta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarPregunta(Integer idPregunta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarRespuesta(Integer idRespuesta) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Encuesta> obtenerEncuestas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pregunta> obtenerPreguntas(Integer idEncuesta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Respuesta> obtenerRespuestas(Integer idPregunta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer obtenerIDEncuesta(Encuesta enc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer obtenerIDPregunta(Pregunta preg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer obtenerIDRespuesta(Respuesta res) {
		// TODO Auto-generated method stub
		return null;
	}

}
