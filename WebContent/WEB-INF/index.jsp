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
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<title>home</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
		<h5 class="my-0 mr-md-auto font-weight-normal">BarCode Reader</h5>
		<nav class="my-2 my-md-0 mr-md-3"> 
		
			<a class="p-2 text-dark" href="/BarcodeReader/acceuil">Acceuil</a> 
			
			<a class="p-2 text-dark" href="/BarcodeReader/addRoom">Ajouter Salle</a> 
			
			<a class="p-2 text-dark" href="#">Ajouter Categorie</a>
			
			<a class="p-2 text-dark" href="#">Contact</a>
			
		</nav>
		
		<a class="btn btn-outline-primary" href="#">LOL</a>
		
	</div>

	<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
	
		<h1 class="display-4">List des hardwares recensés</h1>
		
		<p class="lead">Ici vous trouverez tout les matériels que vous avez scannés.</p>
		
	</div>

	<ul>
		<c:forEach items="${listRooms}" var="room" varStatus="status">
			<li class="card-header">
				<h4>Salle ${room.name}</h4>
				<ul>
					<div class="card-body">
						<c:forEach items="${listHardware}" var="hardware"
							varStatus="status">
							<c:if test="${hardware.room.id == room.id }">
								<li class="card-text">
									<p>
										${hardware.code} | ${hardware.category.name}
									</p>
								</li>
							</c:if>
						</c:forEach>
					</div>
				</ul>
			</li>
		</c:forEach>
	</ul>

	</div>

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

</body>
</html>