package pos.domain;

import java.sql.Date;
import java.util.List;

import pos.data.JDBCAplicacionDAO;

public class AplicacionStore {
	
	private static AplicacionStore repositorio;
	private List<Aplicacion> aplicaciones;
	
	public static synchronized AplicacionStore getInstance(){
		if(repositorio == null){
			repositorio = new AplicacionStore();
		}
		return repositorio;
	}
	
	private AplicacionStore(){
		aplicaciones = (new JDBCAplicacionDAO()).selectAll();
	}
	
	public List<Aplicacion> getAplicaciones(){
		return aplicaciones;
	}
	
	public Aplicacion getAplicacion(String aplyId){
		return (new JDBCAplicacionDAO()).selectAplicacionByID(aplyId);
	}
	
	
	//Cambiado tagname:String por tag:Tag
	public List<Aplicacion> getAplicationByTag(Tag tag){
		//Putadon dar un nombre del tag en vez de dar un Objeto tag:Implica hacer m�todos nuevos.
		return (new JDBCAplicacionDAO()).selectAplicationByTag(tag.getIdTag());
	}
	
	public boolean crearAplicacion (String nombre,String descripcion,Date fechaPublicacion,String URLWeb,List<Tag> tags,Proyecto proyecto, Usuario usuario){
		boolean res = true;
		Aplicacion aplicacion = new AplicacionImpl();
		aplicacion.setNombre(nombre);
		aplicacion.setDescripcion(descripcion);
		aplicacion.setFechaPublicacion(fechaPublicacion);
		aplicacion.setURLWeb(URLWeb);
		aplicacion.setTags(tags);
		aplicacion.setProyecto(proyecto);
		aplicacion.setUsuarioCreador(usuario);
		if(!(aplicaciones.contains(aplicacion))){
			(new JDBCAplicacionDAO()).insertAplicacion(aplicacion, usuario);
		}else{
			res = false;
		}
		return res;
	}
	
//	public List<Aplicacion> getAplicacionByTagList(List<Tag> listaTags){
//		return (new JDBCAplicacionDAO()).selectAplicationsByTags(listaTags);
//	}
	
}

