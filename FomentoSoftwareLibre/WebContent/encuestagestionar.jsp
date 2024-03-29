<%@page import="pos.domain.EncuestaStore"%>
<%@page import="pos.domain.EncuestaImpl"%>
<%@page import="pos.domain.Encuesta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import     = "pos.domain.Usuario" %>
<%@ page import     = "pos.utils.FuncionesImpl" %>
<%@ page import     = "java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%Usuario usuario = (Usuario)session.getAttribute("usuario"); %>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>Fomento del Software Libre - Listado de encuestas</title>
 <script language="JavaScript" src="js/funcionesComunes.js" type="text/javascript"></script>
<script language="JavaScript" >

		function eliminarEncuesta(idEncuesta){
			var pregunta;
			pregunta = confirm('¿Estas seguro que deseas ELIMINAR la encuesta?'); 
			if (pregunta){
			document.formulario.action = "FrontController?accion=eliminarEncuesta&idEncuesta="+ idEncuesta ;
			document.formulario.submit();
			}
		}
		
		function verEncuesta(idEncuesta){
			document.formulario.action = "FrontController?accion=verEncuesta&idEncuesta="+ idEncuesta ;
			document.formulario.submit();
		}
		
		
		function redirigir(){
			window.location="encuestaindex.jsp";
		}
		
</script>
</head>
<body background="Imagenes/fondo.jpg">
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
<form id="formulario" name="formulario" action="" method="POST">
<%	EncuestaStore eStore = new EncuestaStore();
if (eStore.obtenerEncuestasDeUsuario(usuario.getIdUser()).size()>0){
	%>
<table align="center" class="borde">
	<tr>
		<td width="100%" class="tabla_principal" align="center" colspan="2">
			<strong> Encuestas del usuario <%=usuario.getNombreUsuario() %> </strong>
		</td>
	</tr>
	<tr>
		<td width="50%" class="tabla_principal2" align="left">
			<strong>Encuesta: </strong>
		</td>
		<td width="50%" class="tabla_principal2" align="left">
			<strong>Acción</strong>
		</td>
	</tr>
	<%

	for (Encuesta e : eStore.obtenerEncuestasDeUsuario(usuario.getIdUser())){
	%>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			<%=e.getTituloEncuesta() %>
		</td>
		<td width="50%" class="datos_tabla" align="left">
			 <input type="button" id="<%=e.getEncuestaId()%>" name="<%=e.getEncuestaId()%>" onClick="eliminarEncuesta(this.id)" value="Eliminar Encuesta">
			 <input type="button" id="<%=e.getEncuestaId()%>" name="<%=e.getEncuestaId()%>" onClick="verEncuesta(this.id)" value="Ver Resultados">
		</td>
		
	</tr>
	<%} %>

	<tr>
		<td width="40%" align="left" class="datos_tabla">
			<input type="button" id="atras" name="atras" value=" Atrás " onclick="javascript:redirigir()">
		</td>
</table>
	<% } else{%>
	<h1> No tienes encuestas activas</h1>
	<input type="button" id="atras" name="atras" value=" Atrás " onclick="javascript:redirigir()">
	<%} %>
</form>
</body>
</html>