<script>

	function lol(){
		
		const roomSelected = $("#selectRoom option:selected").text();
		
		const categorySelected = $("#selectCategory option:selected").text();
		
		const selectedCategory = $("#CategoriesSelect").val();
		
		console.log(selectedCategory)
		
		const listRooms = $("#selectCategory").text();
		
		const listCategory = $("#selectRoom").text();
		
		const listElementsRooms = $(".roomName").parent().parent();
		
		const listRoomsNames = $(".roomName");
		
		const listCategoryNames = $(".categoryName");
		
	
	listRoomsNames
				.each(function(element) {

					listRoomsNames[element].parentNode.parentNode.style.display = "block";

					var name = listRoomsNames[element].innerHTML

					if (!name.includes(roomSelected)) {

						listRoomsNames[element].parentNode.parentNode.style.display = "none";

					}

				});

		listCategoryNames
				.each(function(element) {
					
					listCategoryNames[element].parentNode.style.display = "block";

					var name = listCategoryNames[element].innerHTML

					if (!name.includes(categorySelected)) {

						listCategoryNames[element].parentNode.style.display = "none";

					}

				})

	}
	
	
	
</script>

<script>

$(document).ready(function() {
    $('.js-example-basic-multiple').select2();
});
</script>