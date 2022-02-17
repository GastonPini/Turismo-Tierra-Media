<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">

<title>Login TM</title>

<!--JQUERY-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- FRAMEWORK BOOTSTRAP para el estilo de la pagina-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<!-- Los iconos tipo Solid de Fontawesome-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
<script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>

<!-- Nuestro css-->
<link rel="stylesheet" type="text/css" href="static/css/index.css"
	th:href="@{/css/index.css}">

</head>
<body>
	<%
		if (request.getAttribute("failed") == "true") {
	%>
	<strong>No te conozco</strong>
	<%
		}
	%>
	<div class="modal-dialog text-center">
		<div class="col-sm-8 main-section">
			<div class="modal-content">
				<div class="col-12 user-img">
					<img src="static/img/user.png" th:src="@{/img/user.png}" />
				</div>
				<form class="col-12" action="login" method="post">
					<div class="form-group" id="user-group">
						<input type="text" class="form-control"
							placeholder="Nombre de usuario" name="username" />
					</div>
					<div class="form-group" id="contrasena-group">
						<input type="password" class="form-control"
							placeholder="Contrasena" name="password" />
					</div>
					<button type="submit" class="btn btn-success">
						<i class="sign-in-alt"></i> Ingresar
					</button>
					<div class="col-12 create">
						<a href="../TurismoTierraMediaWeb/usuarios/altaUsuarios.jsp">
							Crear Usuario</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>