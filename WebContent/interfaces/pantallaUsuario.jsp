<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="UTF-8">
<title>Interfaz Usuario</title>

<!--JQUERY-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- FRAMEWORK BOOTSTRAP para el estilo de la pagina-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>

<!-- Los iconos tipo Solid de Fontawesome-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
<script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>

<!-- Nuestro css-->
<link rel="stylesheet" type="text/css" href="static/css/user-form.css"
	th:href="@{/css/user-form.css}">
<!-- DATA TABLE -->
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
<style type="text/css">
.main-section {
	margin: 0 auto;
	margin-top: 20%;
}

.card-box {
	padding: 20px;
	border-radius: 3px;
	margin-bottom: 30px;
	/*background-color: #fff0;*/
	background: rgba(255, 255, 255, 0.5)
}

.social-links li a {
	border-radius: 50%;
	color: rgba(121, 121, 121, .8);
	display: inline-block;
	height: 30px;
	line-height: 27px;
	border: 2px solid rgba(121, 121, 121, .5);
	text-align: center;
	width: 30px
}

.social-links li a:hover {
	color: #797979;
	border: 2px solid #797979
}

.thumb-lg {
	height: 88px;
	width: 88px;
}

.img-thumbnail {
	padding: .25rem;
	background-color: #fff;
	border: 1px solid #dee2e6;
	border-radius: .25rem;
	max-width: 100%;
	height: auto;
}

.text-pink {
	color: #ff679b !important;
}

.btn-rounded {
	border-radius: 2em;
}

.text-muted {
    color: #000000 !important;
}

h4 {
	line-height: 22px;
	font-size: 18px;
}
</style>
</head>

<body>
	<div id="header">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container">
				<a class="navbar-brand" href="#"> <img
					src=" static/img/user.png" th:src="@{/img/user.png}" width="35"
					height="35" class="d-inline-block align-top" alt="" loading="lazy">
					${objUsuario.username}
				</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Comprar </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item"
									href="../TurismoTierraMediaWeb/atraccionesUsuario">Atracciones</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item"
									href="../TurismoTierraMediaWeb/promocionesUsuario">Promocion</a>
							</div></li>
						<li class="nav-item"><a class="nav-link"
							href="../TurismoTierraMediaWeb/itinerarios">Itinerario</a></li>
					</ul>
				</div>
				<a id="button_id" href="logout">Salir</a>
			</div>
		</nav>

	</div>
	<div class="modal-dialog text-center">
		<div class="col-sm-16 main-section">
			<div class="modal-content">

				<div class="col-lg-12">
					<div class="text-center card-box">
						<div class="member-card pt-2 pb-2">
							<div class="thumb-lg member-thumb mx-auto">
								<img src="https://bootdey.com/img/Content/avatar/avatar2.png"
									class="rounded-circle img-thumbnail" alt="profile-image">
							</div>
							<div class="">
								<h4>${objUsuario.username}</h4>
								
							</div>
							
							
							<div class="mt-4">
								<div class="row">
									<div class="col-4">
										<div class="mt-3">
											<h4>Dinero</h4>
											<p class="mb-0 text-muted">${objUsuario.getDineroDisponible()}</p>
										</div>
									</div>
									<div class="col-4">
										<div class="mt-3">
											<h4>Tiempo</h4>
											<p class="mb-0 text-muted">${objUsuario.getTiempoDisponible()}</p>
										</div>
									</div>
									<div class="col-4">
										<div class="mt-3">
											<h4>Atracción Preferida</h4>
											<p class="mb-0 text-muted">${objUsuario.getAtraccionPreferida().nombre}</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>