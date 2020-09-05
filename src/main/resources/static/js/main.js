$(document).ready(function() {
	$('.table').on('click', '#shownBtn', function(){
		
		$('#exampleModal').modal('show');
	});
	
//	 $("#tableSearch").on('click', '#searchBtn', function()
	 $("#tableSearch").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#myTable tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
	 
	 $('#export').on('click', function(event) {
		  event.preventDefault(); // To prevent following the link (optional)
		  $('.table').tableExport({type:'csv'});
		});
	 
});