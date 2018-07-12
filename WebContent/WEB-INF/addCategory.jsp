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
<title>addCategory</title>
</head>
<body>

<%@ include file="topMenu.jsp" %>

	<div
		class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">

		<h1 class="display-4">Ajouter une categorie</h1>

		<p class="lead">Ici vous pouvez ajouter une categorie à la BDD.</p>

	</div>
	
	<div class="container">

	<form id="contact-form" method="post" action="/BarcodeReader/addCategory" role="form">

		<div class="controls">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="form_name">Nom de la categorie :</label> <input id="form_name"
							type="text" name="name" class="form-control"
							placeholder="Please enter the category name" required="required"
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
	
	</br>
	
	<h2>Liste des categories existantes</h2>
	
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
					<c:forEach items="${listCategories}" var="category" varStatus="status">
						<tr>
							<td>${category.id}</td>
							<td class="col-md-4">${category.name}</td>
							<td class="col-md-4"><input type="submit" class="btn btn-danger btn-send"
						value="Supprimer"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
	

</div>

</body>
</html>