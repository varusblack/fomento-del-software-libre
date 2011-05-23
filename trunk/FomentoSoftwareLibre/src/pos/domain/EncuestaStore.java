package pos.domain;

import java.sql.Date;
import java.util.List;

import pos.data.IEncuestaDAO;
import pos.data.IPreguntaDAO;
import pos.data.IRespuestaDAO;

public class EncuestaStore implements IEncuestaStore {
	
	private List<Encuesta> le;
	private List<Pregunta> lp;
	private List<Respuesta> lr;
	private IEncuestaDAO edao;
	private IPreguntaDAO pdao;
	private IRespuestaDAO rdao;
	private Integer encID;
	private Integer pregID;
	private Integer resID;
	
	public EncuestaStore(){
		le = edao.seleccionarTodasEncuestas();
	}

	@Override
	public void insertarEncuesta(Encuesta enc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarEncuesta(Integer idEncuesta) {
		// TODO Auto-generated method stub

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