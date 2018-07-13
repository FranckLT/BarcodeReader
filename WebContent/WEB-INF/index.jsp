<%@page import="beans.Room"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="beans.Hardware"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
	<link href="./css/style.css" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
<title>home</title>
</head>
<body>

	<%@ include file="topMenu.jsp" %>

	<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
	
		<h1 class="display-4">Liste des hardwares recensés</h1>
		
		<p class="lead">Ici vous trouverez tout les matériels que vous avez scannés.</p>
		
	</div>
	
	<div class="container sortContainer">
	
	<%@ include file="sortForm.jsp" %>

		<!--  <div class="row border border-primary rounded p-3 col-8">
			<div class="col-5 align-middle">
				<label for="rooms" class="align-middle">Rooms : </label> <select id="selectRoom"
					class="btn btn-primary dropdown-toggle align-middle" name="rooms">
					<option value=""></option>
					<c:forEach items="${listRooms}" var="room" varStatus="status">
						<option value="${room.id }">${room.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-5 align-middle">
				<label for="categories">Categorie : </label> <select
					id="selectCategory" class="btn btn-primary dropdown-toggle"
					name="categories">
					<option value=""></option>
					<c:forEach items="${listCategories}" var="category"
						varStatus="status">
						<option value="${category.id }">${category.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-2 align-middle">
				<button class="btn btn-primary px-4" onClick="sort()">Sort</button>
			</div>
		</div>-->

		<br>

		<div class="container">

			<div class="row">

				<div class="col-lg-4 col-md-6">
					<label for="rooms" class="align-middle col-12">Rooms : </label> <select
						id="roomsSelect" class="js-example-basic-multiple col-5" name="rooms"
						multiple="multiple">
						<c:forEach items="${listRooms}" var="room" varStatus="status">
							<option value="${room.id }">${room.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-lg-4 col-md-6">
					<label for="rooms" class="align-middle col-12"> Category : </label> <select
						id="categoriesSelect" class="js-example-basic-multiple col-5"
						name="category" multiple="multiple">
						<c:forEach items="${listCategories}" var="category"
							varStatus="status">
							<option value="${category.id }">${category.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-3">
					<button class="btn btn-primary px-4" onClick="sort()">Sort</button>
				</div>
			</div>
		</div>

		<br>

	
	</div>

	<ul>
		<c:forEach items="${listRooms}" var="room" varStatus="status">
			<li class="card-header">
				<h4>Salle <span class="roomName">${room.name}</span></h4>

				<ul>
					<c:forEach items="${listCategories}" var="category"
						varStatus="status">
						<li class="card-header">
							<h4 class="categoryName">${category.name}</h4>
							<div class="table-responsive">
								<table class="table table-striped table-sm">
									<thead>
										<tr>
											<th>Code</th>
											<th class="col-md-4">Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listHardware}" var="hardware"
											varStatus="status">
											<c:if test="${hardware.room.id == room.id}">
												<c:if test="${hardware.category.id == category.id }">
													<tr>
														<td class="col-md-4">${hardware.code}</td>
														<td class="col-md-4"><input type="button"
															class="btn btn-danger btn-send " value="Del"
															onclick="on('${hardware.code}')"></td>
													</tr>
												</c:if>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</li>
					</c:forEach>
				</ul>
			</li>
		</c:forEach>
	</ul>

	<%@ include file="overlay.jsp" %>

</body>
</html>