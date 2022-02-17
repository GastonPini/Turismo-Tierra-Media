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
<title>Alta promoción</title>
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
							<h4>Paquete de maravillas a crear</h4>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table id="promociones"
									class="table table-bordered table-hover table-striped">
									<form action="./nuevaPromocion" method="post">
										<div class="form-row">
											<div class="col-md-8 mb-3">
												<label for="nombre">Nombre</label> <input name="nombre"
													type="text" class="form-control" id="nombre" required>
											</div>
											<div class="col-md-4 mb-3">
												<!-- <label for="tipo">Tipo</label>
													 <input name="tipo" type="text" class="form-control" id="tipo" required> -->
												<select name="tipo" id="tipo" class="selectpicker"
													class="col-md-12 mb-3">
													<optgroup label="Aventura">
														<option>Absoluta</option>
														<option>Porcentual</option>
														<option>AxB</option>
													</optgroup>
												</select>
											</div>
										</div>
										<div class="form-row">
											<div class="col-md-4 mb-3">
												<select class="selectpicker" class="col-md-12 mb-3">
													<optgroup label="Aventura">
														<option>Moria</option>
														<option>Mordor</option>
														<option>Bosque Negro</option>
														<option>Gondor</option>
													</optgroup>
													<optgroup label="Paisaje">
														<option>La comarca</option>
														<option>Lothlorien</option>
														<option>Disney</option>
													</optgroup>
													<optgroup label="Degustacion">
														<option>Minas tirith</option>
														<option>Abismo de helm</option>
														<option>Rohan</option>
													</optgroup>
												</select>
											</div>
											<div class="col-md-4 mb-3">
												<select class="selectpicker" name="datoExtra" id="datoExtra"
													class="col-md-12 mb-3">
													<optgroup label="Aventura">
														<option value="Moria">Moria</option>
														<option value="Moria">Mordor</option>
														<option value="Moria">Bosque Negro</option>
														<option value="Moria">Gondor</option>
													</optgroup>
													<optgroup label="Paisaje">
														<option value="Moria">La comarca</option>
														<option value="Moria">Lothlorien</option>
														<option value="Moria">Disney</option>
													</optgroup>
													<optgroup label="Degustacion">
														<option value="Moria">Minas tirith</option>
														<option value="Moria">Abismo de helm</option>
														<option value="Moria">Rohan</option>
													</optgroup>
												</select>
											</div>
											<div class="col-md-4 mb-3">
												<select class="selectpicker" class="col-md-12 mb-3">
													<optgroup label="Aventura">
														<option>Moria</option>
														<option>Mordor</option>
														<option>Bosque Negro</option>
														<option>Gondor</option>
													</optgroup>
													<optgroup label="Paisaje">
														<option>La comarca</option>
														<option>Lothlorien</option>
														<option>Disney</option>
													</optgroup>
													<optgroup label="Degustacion">
														<option>Minas tirith</option>
														<option>Abismo de helm</option>
														<option>Rohan</option>
													</optgroup>
												</select>
											</div>
										</div>
										<div class="form-group">
											<div class="form-check">
												<input name="activo" class="form-check-input"
													type="checkbox" value="" id="invalidCheck2" required>
												<label class="form-check-label" for="invalidCheck2">
													Activo </label>
											</div>
										</div>
										<button class="btn btn-primary" type="submit">Crear</button>
									</form>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</body>
</html>