<%@page import="com.sun.xml.internal.stream.writers.WriterUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import     = "pos.domain.AplicacionStore" %>
<%@ page import     = "pos.domain.Tag" %>
<%@ page import     = "pos.domain.Aplicacion" %>
<%@ page import     = "java.util.*" %>
<%@ page import		= "java.sql.Date"%>
<%@ page import 	= "java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crea un enfrentamiento</title>
<script type="text/javascript">
var css="css/estilos.css";
document.write("<link href='" + css + "' rel='stylesheet' type='text/css'>"); 

function redirigir(){
	window.location="crearEnfrentamientoSelectAplicaciones.jsp";
}
</script>

</head>
<body background="Imagenes/fondo.jpg" onload="javascript:ini();">
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

<table align="center">
	<tr>
		<td class="titularEnfrentamiento" align="center" width="100%">
			Creaci�n de enfrentamiento
		</td>
	</tr>
</table>
<table align="center">
	<tr>
		<td align="center" width="100%">
			<img src="Imagenes/Vs.png" border="0" height="40" width="40"/>
		</td>
	</tr>
</table>

<form id="formularioTags" name="formularioAplicaciones" action="FrontController?accion=AplicacionesEnfrentamiento" method="post" onsubmit="return validar(this,2)">

<table align="center" class="borde">
<tr>
	<td width="100%" class="tabla_principal" align="center" colspan="2">
		<strong> Este enfrentamiento ya existe </strong>
	</td>
</tr>
<tr>
	<td width="50%" align="left">
	</td>
	<td class="titular "width="50%" align="center">
		<input type="button" id="atras" name="atras" value=" Atr�s " onclick="javascript:redirigir()">
	</td>
</tr>
</table>
</body>
</html>