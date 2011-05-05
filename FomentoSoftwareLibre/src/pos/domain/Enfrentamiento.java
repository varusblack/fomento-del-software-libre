package pos.domain;

import java.util.Date;

public interface Enfrentamiento {
	
	public Aplicacion getAplicacion1();
	public void setAplicacion1(Aplicacion aplicacion1);
	public Aplicacion getAplicacion2();
	public void setAplicacion2(Aplicacion aplicacion2);
	public String getDescripcion();
	public void setDescripcion(String descripcion);
	public Date getFechaCreacion();
	public void setFechaCreacion(Date fechaCreacion);
	public Date getFechaFin();
	public void setFechaFin(Date fechaFin);
	public Integer getVotosAplicacion1();
	public void anadirVotoAplicacion1();
	public Integer getVotosAplicacion2();
	public void anadirVotoAplicacion2();
	public boolean equals(Object o);
	public String toString();
	

}