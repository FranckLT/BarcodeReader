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

		<form action="#">
		
		<div class="row justify-content-center">
		
			<input type="text" id="code" class="form-control col-md-5">
			
			<input type="submit" onClick="generate()" class="btn btn-info">
			
		</div>
		
			
		</form>
		
		<div class="row justify-content-center">
		
			<img id="barcodeImg"/>

			<svg id="barcode"></svg>
		
		</div>

	</div>

	<script src="https://cdn.jsdelivr.net/npm/jsbarcode@3.8.0/dist/barcodes/JsBarcode.code128.min.js"></script>

<script>

function generate(){
	
	const code = document.getElementById('code').value;
	
	//JsBarcode("#barcode", code);
	
	JsBarcode("#barcodeImg", code);
	
}
</script>

</body>
</html>