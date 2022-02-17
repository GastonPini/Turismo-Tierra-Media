<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="es" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<head>
<meta charset="UTF-8">
<title>Alta usuario</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!--BOOTSTRAP-->
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

</head>

<body>

	<div class="container">
		<div class="mx-auto col-sm-13 main-section" id="myTab" role="tablist">
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="list" role="tabpanel"
					aria-labelledby="list-tab">
					<div class="card">
						<div class="card-header">
							<h4>Héroe a crear</h4>
						</div>
						<div class="card-body">
							<div class="table-responsive-sm">
							
								<table id="usuarios"
									class="table table-bordered table-hover table-striped">
									<form action="./nuevoUsuario" method="post">
										<div class="form-row">
											<div class="col-md-6 mb-3">
												<label for="username">Nombre</label> <input name="username"
													type="text" class="form-control" id="username" required>
											</div>
											<div class="col-md-6 mb-3">
												<label for="password">Contraseña</label> <input
													name="password" type="password" class="form-control"
													id="password" required>
											</div>
										</div>
										<div class="form-row">
											<div class="col-md-4 mb-3">
												<label class="sr-only" for="tiempoDisponible">Tiempo
													Disponible</label>
												<div class="input-group mb-2">
													<div class="input-group-prepend">
														<div class="input-group-text">Hs</div>
													</div>

													<input name="tiempoDisponible" type="number"
														class="form-control" id="tiempoDisponible" required>
												</div>
											</div>
											<div class="col-md-4 mb-3">
												<label class="sr-only" for="dineroDisponible">Dinero
													Disponible</label>
												<div class="input-group mb-2">
													<div class="input-group-prepend">
														<div class="input-group-text">$</div>
													</div>

													<input name="dineroDisponible" type="number"
														class="form-control" id="dineroDisponible" required>
												</div>
											</div>
											<div class="col-md-4 mb-3">
												<label class="sr-only" for="preferencia">Atracción
													Preferida</label>
												<div class="input-group mb-2">
													<div class="input-group-prepend">
														<div class="input-group-text">Tipo</div>
													</div>
													<select name="preferencia" class="custom-select"
														id="preferencia" required>
														<option selected disabled value="">Eligir...</option>
														<c:forEach items="${tiposAtracciones}" var="tpAt">
															<option value="${tpAt.ID}">${tpAt.nombre}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
										<div class="form-check">
											<input name="activo" class="form-check-input" type="checkbox"
												value="1" id="activo"> <label
												class="form-check-label" for="activo"> Activo </label>
										</div>
										<div class="form-check">
											<input name="es_admin" class="form-check-input"
												type="checkbox" value="1" id="es_admin"> <label
												class="form-check-label" for="es_admin"> Es	Administrador? </label>
										</div>
										<button class="btn btn-primary" type="submit">Crear</button>
									</form>
								</table>
								
							</div>
						</div>
					</div>
				</div>
			</div>
			<a id="button_id" href="./inicio">Salir</a>
		</div>
	</div>
	
</body>
</html>