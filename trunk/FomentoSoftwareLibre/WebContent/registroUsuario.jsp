<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Usuario</title>
<!--  necesario en todas las html jsp para usar los estilos -->
<script language="JavaScript" >
			var css="css/estilos.css";
		document.write("<link href='" + css + "' rel='stylesheet' type='text/css'>"); 
		
		var nickname = document.getElementById("nick").value ;
		var password = document.getElementById("password").value;
		var conf_password = document.getElementById("conf_password").value;
		var email = document.getElementById("email").value;
		
		function limpiarForm(){
			document.getElementById("nick").value = "";
			document.getElementById("password").value = "";
			document.getElementById("conf_password").value = "";
			document.getElementById("email").value = "";
		}
		
		function comprobarPassword(){
			
			var nickname = document.getElementById("nick").value;
			var password = document.getElementById("password").value;
			var conf_password = document.getElementById("conf_password").value;
			var email = document.getElementById("email").value;
			
			if ( nickname.equals("") || password.equals("") || email.equals("") ){
				alert("Debe introducir todos los datos");
			}
			
			if ( !password.equals(conf_password) ){
				alert("Los password no coinciden");
			}else{
				document.formulario.action = "FrontController?accion=registro1";
				document.formulario.submit();
			}
		}
</script>
</head>
<body>
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
<form id="formulario" name="formulario" action="" method="post">
<table align="center" class="borde">
	<tr>
		<td width="100%" class="tabla_principal" align="center" colspan="2">
			<strong> Nuevo Usuario </strong>
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			<strong>Nick: </strong>
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<input type="text" id="nick" name ="nick" value="">
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			<strong>Password: </strong>
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<input type="password" id="password" value="">
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			<strong>Confirmar Password: </strong>
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<input type="password" id="conf_password" value="">
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			<strong>Email: </strong>
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<input type="text" id="email" value="">
		</td>
	</tr>
	<tr>
		<td width="50%" align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="registrarse" name="registrarse" value=" Registrarse" onclick="javascript:comprobarPassword();">
		</td>
		<td width="50%" align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="limpiar" name="limpiar" value=" Limpiar Formulario" onclick="javascript:limpiarForm();">
		</td>
	</tr>
</table>
</form>
</body>
</html>