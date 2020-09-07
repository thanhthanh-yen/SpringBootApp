$(document).on('click', '#searchBtn', buttonSearchOnClick);
$(document).ready(function() {
	$('.table').on('click', '#shownBtn', function(){
		console.log("Show modal");
		var $model = $('#exampleModal');
		
		var userName = $(this).parents("tr").find("#rowUserId").html();
		$model.find("#inputId").val(userName);

		var userName = $(this).parents("tr").find("#rowUserName").html();
		$model.find("#inputName").val(userName);
		
		var userName = $(this).parents("tr").find("#rowUserAge").html();
		$model.find("#inputAge").val(userName);
		
		$('#exampleModal').modal('show');
	});
	
//	 $("#tableSearch").on("keyup", function() {
//		    var value = $(this).val().toLowerCase();
//		    $("#myTable tr").filter(function() {
//		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
//		    });
//		  });
	 
	 $('#export').on('click', function() {
		  $('.table').tableExport({type:'csv'});
		});
	 
});

function buttonSearchOnClick() {
	var value = $("#tableSearch").val().toLowerCase();
	console.log(value);
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
}