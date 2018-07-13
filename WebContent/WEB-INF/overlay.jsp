
<script type="text/javascript">

	function on(code) {
	$("<div id="+code+" class='overlay' onclick='off()'><div id='text'>Voulez vous vraiment supprimer l'élément "+code+" ?</div><form id='contact-form' method='post' action='/BarcodeReader/home' role='form'><input type='hidden' name='code' value="+code+"><input id='submitButton' type='submit' class='btn btn-danger btn-send col-md-2' value='OUI' onclick='off()'></form></div>").appendTo("body");
	document.getElementById(code).style.display = "block";
	}
	
	function onRoom(code) {
		$("<div id="+code+" class='overlay' onclick='off()'><div id='text'>Voulez vous vraiment supprimer la salle "+code+" ?</div><form id='contact-form' method='post' action='/BarcodeReader/addRoom' role='form'><input type='hidden' name='code' value="+code+"><input id='submitButton' type='submit' class='btn btn-danger btn-send col-md-2' value='OUI' onclick='off()'></form></div>").appendTo("body");
		document.getElementById(code).style.display = "block";
		}
	
	function onCategory(code) {
		$("<div id="+code+" class='overlay' onclick='off()'><div id='text'>Voulez vous vraiment supprimer la catégorie "+code+" ?</div><form id='contact-form' method='post' action='/BarcodeReader/addCategory' role='form'><input type='hidden' name='code' value="+code+"><input id='submitButton' type='submit' class='btn btn-danger btn-send col-md-2' value='OUI' onclick='off()'></form></div>").appendTo("body");
		document.getElementById(code).style.display = "block";
		}

	function off() {
		$('.overlay').css("display","none");
	}
</script>
