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
<title>addRoom</title>
</head>
<body>

	<%@ include file="topMenu.jsp" %>

	<div
		class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">

		<h1 class="display-4">Ajouter une salle</h1>

		<p class="lead">Ici vous pouvez ajouter une salle à la BDD.</p>

	</div>

	<div class="container">

	<form id="contact-form" method="post" action="/BarcodeReader/addRoom" role="form">

		<div class="controls">

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="form_name">Nom de la salle :</label> <input id="form_name"
							type="text" name="name" class="form-control"
							placeholder="Please enter the room name" required="required"
							data-error="Name is required.">
						<div class="help-block with-errors"></div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<input type="submit" class="btn btn-success btn-send"
						value="Submit">
				</div>
			</div>
		</div>

	</form>

</div>

	</br>
	
	

	<div class="container">
	
	<h2>Liste des salles existantes</h2>
	
	</br>

		<div class="table-responsive">
			<table class="table table-striped table-sm">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listRooms}" var="room" varStatus="status">
						<tr>
							<td>${room.id}</td>
							<td class="col-md-4">${room.name}</td>
							<td class="col-md-4"><input type="button" class="btn btn-danger btn-send"
						value="Supprimer" onClick="onRoom('${room.name }')"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<%@ include file="overlay.jsp" %>

</body>
</html>