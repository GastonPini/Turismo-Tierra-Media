<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="UTF-8">
<title>Compra Atracciones</title>
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

<div class="container">
	<div class="mx-auto col-sm-13 main-section" id="myTab" role="tablist">
		<ul class="nav nav-tabs justify-content-end">
			<li class="nav-item"><a class="nav-link active" id="list-tab"
				data-toggle="tab" href="#list" role="tab" aria-controls="list"
				aria-selected="false">Lista Atracciones</a></li>
		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="list" role="tabpanel"
				aria-labelledby="list-tab">
				<div class="card">
					<div class="card-header">
						<h4>Maravillas disponibles en la tierra media.</h4>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table id="atracciones"
								class="table table-bordered table-hover table-striped">
								<thead class="thead-light">
									<tr>
										<th>Nombre</th>
										<th>Costo</th>
										<th>Tiempo</th>
										<th>Cupo</th>
										<th>Tipo</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${atracciones}" var="at">
										<tr>
											<td><c:out value="${at.nombre}" /></td>
											<td><c:out value="${at.costo}" /></td>
											<td><c:out value="${at.tiempo}" /></td>
											<td><c:out value="${at.cupo}" /></td>
											<td><c:out value="${at.tipoAtraccion.nombre}" /></td>
											<td><c:choose>
													<c:when
														test="${at.calcularCostoFinal() <= usuario.getDineroDisponible() && at.cupoDisponible()
				&& usuario.getTiempoDisponible() >= at.getTiempo() && !usuario.tiene(at)}">
														<a
															href="/TurismoTierraMediaWeb/UsuarioComprarAtraccion?AtraccionId=${at.id}"
															class="btn btn-primary btn-lg" tabindex="-1"
															role="button" aria-disabled="true">Comprar </a>
													</c:when>
													<c:otherwise>
														<a
															href="/TurismoTierraMediaWeb/UsuarioComprarAtraccion?AtraccionId=${at.id}"
															class="btn btn-secondary btn-lg disabled" tabindex="-1"
															role="button" aria-disabled="true">Comprar </a>
													</c:otherwise>
												</c:choose></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<a id="button_id" href="./inicio">Salir</a>
	</div>
</div>
</html>