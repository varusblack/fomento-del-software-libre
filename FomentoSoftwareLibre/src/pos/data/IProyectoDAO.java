package pos.data;

import java.util.List;

import pos.domain.Aplicacion;
import pos.domain.Proyecto;
import pos.domain.Usuario;

public interface IProyectoDAO {
	
	public List<Proyecto> obtenerTodosProyectos();
	public List<Proyecto> obtenerProyectosAbiertos();
	public Proyecto crearProyecto(Proyecto proyecto, Usuario u);
	public Proyecto obtenerProyectoPorID(String idProyecto);
	public Aplicacion obtenerAplicacionDeProyecto(Proyecto p);
	public List<Proyecto> obtenerProyectosCreadosPorUsuario(Usuario u);
	
	public void borrarProyecto(Proyecto p);
	public void borrarAsociacionTodosUsuariosConProyecto(Proyecto p);	
	public boolean existeTuplaUsuarioProyecto(Proyecto p,Usuario u);
	public void asociarProyectoAUsuario(Usuario u,Proyecto p);
	public void borrarUnUsuarioDeProyecto(Proyecto p, Usuario u);
	public List<Usuario> obtenerUsuariosDeProyecto (Proyecto p);
	
}