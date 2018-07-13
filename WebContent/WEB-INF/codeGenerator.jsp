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
<title>CodeGenerator</title>
</head>
<body>

<%@ include file="topMenu.jsp" %>

	<div class="container">

	
		
		<div class="row justify-content-center">
		
			<input type="text" id="code" class="form-control col-md-5">
			
			<button class="btn btn-info" onClick='generateRandom()'>Générer</button>
			
		</div>
		
		
		<br>
		
		<div class="row justify-content-center">
		
			<div class="col-12 justify-content-center">
			<div class="row justify-content-center">
				<img id="barcodeImg"/>
				</div>
			</div>
			
			<br>
			
				
			<div class="col-12">
			<div class="row justify-content-center">
				<svg id="barcode"></svg>
				</div>
			</div>
		</div>
		
		<div class="row justify-content-center">
		
			<button class="btn btn-info" onClick='RandomTour()'>Tour</button>
			
			<button class="btn btn-info" onClick='RandomEcran()'>Ecran</button>
			
			<button class="btn btn-info" onClick='RandomClavier()'>Clavier</button>
			
		</div>
		

	</div>
	
	

	<script src="https://cdn.jsdelivr.net/npm/jsbarcode@3.8.0/dist/barcodes/JsBarcode.code128.min.js"></script>

<script>

function generate(){
	
	const code = document.getElementById('code').value;
	
	JsBarcode("#barcode", code);
	
	JsBarcode("#barcodeImg", code);
	
}

function RandomEcran(){
	
	const number = getRandomInt(1000000)
	
	JsBarcode("#barcode", "ecran_"+number);
	
	JsBarcode("#barcodeImg", "ecran_"+number);
	
}

function RandomTour(){
	
	const number = getRandomInt(1000000)
	
	JsBarcode("#barcode", "tour_"+number);
	
	JsBarcode("#barcodeImg", "tour_"+number);
	
}

function RandomClavier(){
	
	const number = getRandomInt(1000000)
	
	JsBarcode("#barcode", "clavier_"+number);
	
	JsBarcode("#barcodeImg", "clavier_"+number);
	
}

function getRandomInt(max) {
	  return Math.floor(Math.random() * Math.floor(max));
	}
</script>

</body>
</html>