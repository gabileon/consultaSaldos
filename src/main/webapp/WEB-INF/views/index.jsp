<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body onload='document.loginForm.username.focus();'>
 
	<h1>Login</h1>
 
	<div id="login-box">
 
		<h3>Login con rut (Ficha Chica)</h3>
 
		<form:form name='loginForm' 
		  action="/consultasaldos/home" method='GET'>
 
		  <table>
			<tr>
				<td>Numero Tarjeta:</td>
				<td><input type='text' name='numeroTarjeta' value='4152822090000204'></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Ingresar" /></td>
			</tr>
		  </table>
 
 
		</form:form>
	</div>
	</body>
	</html>