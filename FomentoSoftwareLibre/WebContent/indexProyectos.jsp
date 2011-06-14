<%@page import="pos.domain.ProyectoStore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="pos.utils.FuncionesImpl"%>
<%@ page import="pos.domain.Usuario"%>
<%@ page import="pos.domain.UsuarioStore"%>
<%@ page import="pos.domain.ProyectoStore"%>
<%@ page import="pos.domain.Proyecto"%>
<%@ page import="pos.domain.Aplicacion"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" type="text/css" href="css/estilos_proyecto.css"> -->
<title>�rea de proyectos</title>
<script language="JavaScript" src="js/funcionesComunes.js"
	type="text/javascript"></script>
<script language="JavaScript">
	var css = "css/estilos.css";
	document
			.write("<link href='" + css + "' rel='stylesheet' type='text/css'>");
<%Usuario usuario = (Usuario) session.getAttribute("usuario");%>
	function redirigir() {
		window.location = "index2.jsp";
	}
</script>
</head>
<body background="Imagenes/fondo.jpg">
	<!--  INICIO TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
	<table align="center">
		<tr>
			<td width="15%" align="left"><img src="Imagenes/tux.jpg">
			</td>
			<td class="titular" align="center" width="70%"><strong>Web
					De Fomento Del Sofware Libre</strong>
			</td>
			<td width="15%" align="right"><img src="Imagenes/tux.jpg">
			</td>
		</tr>
	</table>
	<!--  FIN TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->

	<table border="0">
		<tr>
			<td width="30%" class="datos_tabla" align="left">Bienvenido <a
				href="ActualizarPerfil.jsp"><%=usuario.getNombreUsuario()%></a>, Hoy
				es <%=FuncionesImpl.formateoFecha(new Date())%></td>
			<td width="30%" class="datos_tabla" align="left">Karma
				acumulado, <%=usuario.getKarma()%></td>
			<td width="40%" class="datos_tabla" align="right"><a
				href="FrontController?accion=logout">Salir</a></td>
		</tr>
	</table>
	<!--  FIN TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->

	<div id="pestanas">
		<ul>
			<li><a href="javascript:redirigir()">Inicio</a></li>
			<li><a title="Proyectos creados o en los que colaboras"
				href="proyectosUsuario.jsp">Mis Proyectos</a></li>
			<li><a title="Muestra los proyectos existentes"
				href="proyectosExistentes.jsp">Todos los proyectos existentes</a></li>
			<li><a href="proyectosUnirse.jsp">Unirse a un proyecto</a></li>
			<li><a href="proyectosCrear.jsp">Crear un nuevo proyecto</a></li>
		</ul>
	</div>

	<h2 align="center">A ver como te explico...Empecemos:</h2>
	<br>
	<ul>
		<li><h3>En el men� de arriba a la izquierda podr�s
				seleccionar las distintas opciones de proyectos, aparecer� en todas
				las secciones de proyectos.</h3></li>
		<li><h3>Si quieres <a href="proyectosUnirse.jsp">unirte a un proyecto</a>, deber�s tener el
				m�nimo de karma requerido por el proyecto. y seguir las siguientes
				instrucciones:</h3></li>
		<ul>
			<li><h3>
					Para ver los proyectos con los que cuenta la web, haz click en <a
						href="proyectosExistentes.jsp">Proyectos existentes</a>.
				</h3></li>
			<li><h3>Una vez dentro, dando al bot�n "Ver descripci�n"
					podr�s ver una descripci�n detallada del proyecto.</h3></li>
			<li><h3>Si cumples los siguientes requerimientos, aparecer�
					el bot�n para poder unirte al proyecto:
					</h3></li>
					<ul>
					<li><h3>- Que obviamente no pertenezcas al proyecto o seas el creador, ya que estar�s vinculado autom�ticamente al crearlo.</h3></li>
					<li><h3>- Que el proyecto est� disponible.</h3></li>
					<li><h3>- Que cumplas el m�nimo de karma requerido por el proyecto.</h3></li>
					</ul>

		</ul>
		<li><h3>En <a href="proyectosUsuario.jsp">Mis proyectos</a> aparecer�n los proyectos que has creado y/o en los que colaboras.</h3></li>
		
		<li><h3>En <a href="proyectosCrear.jsp">Crear un nuevo proyecto</a> podr�s crear un nuevo proyecto.</h3></li>
		
	</ul>
	

</body>
</html>