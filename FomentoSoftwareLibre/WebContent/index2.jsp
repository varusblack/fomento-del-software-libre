<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import     = "java.util.ArrayList" %>
<%@ page import     = "java.util.List" %>
<%@ page import     = "java.util.Date" %>
<%@ page import     = "pos.utils.FuncionesImpl" %>
<%@ page import     = "pos.domain.PaisStore" %>
<%@ page import     = "pos.domain.Pais" %>
<%@ page import     = "pos.domain.ProvinciaStore" %>
<%@ page import     = "pos.domain.Provincia" %>
<%@ page import     = "pos.domain.Usuario" %>
<%@ page import     = "pos.domain.SoStore" %>
<%@ page import     = "pos.domain.SO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenidos a la web que siempre so�abas</title>
 <script language="JavaScript" src="js/funcionesComunes.js" type="text/javascript"></script>
<script language="JavaScript" >
			var css="css/estilos.css";
		document.write("<link href='" + css + "' rel='stylesheet' type='text/css'>"); 
		<%
			//HttpSession session = request.getSession();
			Boolean recomendado = (Boolean) session.getAttribute("haSidoRecomendado");
			Usuario usuario = (Usuario)session.getAttribute("usuario");
		%>

</script>
</head>
<body background="Imagenes/fondo.jpg">
<!--  INICIO TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
<table align="center">
	<tr>
		<td width="15%" align="left">
			<img src="Imagenes/tux.jpg">
		</td>
		<td class="titular" align="center" width="70%">
			<strong>Web Del Fomento Del Sofware Libre</strong>
		</td>
		<td width="15%" align="right">
			<img src="Imagenes/tux.jpg">
		</td>
	</tr>
</table>
<!--  FIN TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
<table border="0">
	<tr>
		<td width="30%" class="datos_tabla" align="left">
			Bienvenido <a href="ActualizarPerfil.jsp"><%=usuario.getNombreUsuario()%></a>, Hoy es <%=FuncionesImpl.formateoFecha(new Date())%>
		</td>
		<td width="30%" class="datos_tabla" align="left">
			Karma acumulado, <%=usuario.getKarma() %>
		</td>
		<td width="40%" class="datos_tabla" align="right">
			<a href="FrontController?accion=logout">Salir</a>
		</td>
	</tr>
</table>
<div id="pestanas">
   <ul>
      <li><a href="encuesta.jsp">Encuestas</a></li>
      <li class="activa"><a href="#">Enfrentamientos</a></li>
      <li><a href="aplicaciones.jsp">Aplicaciones</a></li>
      <li><a href="#">Proyectos</a></li>
   </ul>
</div>
</body>
</html>