<script>

	/*function lol(){
		
		const roomSelected = $("#selectRoom option:selected").text();
		
		const categorySelected = $("#selectCategory option:selected").text();
		
		console.log(selectedCategory);
		
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

				});
	

	}*/

	function sort(){
		
		var listCategories = $(".categoryName"); 
		
		var listRooms = $(".roomName");
		
		var selectedCategory = $("#categoriesSelect").select2("data");
		
		var selectedRooms =  $("#roomsSelect").select2("data");
		
		var listCategoriesSelected =[];
		
		var listRoomsSelected = [];
		
		listCategories
		.each(function(element) {
			listCategories[element].parentNode.style.display = "block"
		});
		
		listRooms
		.each(function(element) {
			listRooms[element].parentNode.parentNode.style.display = "block"
		});
		
		for(j=0;j<selectedCategory.length;j++){
			const name = selectedCategory[j].text;
			listCategoriesSelected.push(name)
		}
		for(j=0;j<selectedRooms.length;j++){
			const name = selectedRooms[j].text;
			listRoomsSelected.push(name)
		}
		
		if(listCategoriesSelected.length>0){
			
			for(let i = 0; i<listCategories.length; i++){
				
				if(listCategoriesSelected.includes(listCategories[i].innerHTML)){
					
					listCategories[i].parentNode.style.display = "block";
					
				} else {
					
					listCategories[i].parentNode.style.display = "none";
					
				}
				
			}
			
		}
		
		if(listRoomsSelected.length>0){
			
			for(let i = 0; i<listRooms.length; i++){
				
				if(listRoomsSelected.includes(listRooms[i].innerHTML)){
					
					listRooms[i].parentNode.parentNode.style.display = "block";
					
				} else {
					
					listRooms[i].parentNode.parentNode.style.display = "none";
					
				}
				
			}
			
		}
		
		
		
	}
	
</script>

<script>

$(document).ready(function() {
    $('.js-example-basic-multiple').select2();
});
</script>