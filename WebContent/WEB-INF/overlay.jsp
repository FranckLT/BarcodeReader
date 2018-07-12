
<script type="text/javascript">

	function on(code) {
	$("<div id="+code+" class='overlay' onclick='off()'><div id='text'>Voulez vous vraiment supprimer l'élément "+code+" ?</div><form id='contact-form' method='post' action='/BarcodeReader/home' role='form'><input type='hidden' name='code' value="+code+"><input id='submitButton' type='submit' class='btn btn-danger btn-send col-md-2' value='OUI' onclick='off()'></form></div>").appendTo("body");
	$("<h1 id="+code+">hello</h1>").appendTo("body");
	document.getElementById(code).style.display = "block";
	}

	function off() {
		$('.overlay').css("display","none");
	}
</script>
