$(document).on('click', '#searchBtn', buttonSearchOnClick);
function buttonSearchOnClick() {
	var value = $("#tableSearch").val().toLowerCase();
	console.log(value);
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
}

$(document).ready(function() {
	$('.table').on('click', '#shownBtn', function(){
//		console.log("Show modal");
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

$(document).ready(function() {
	$('#addUser').on('click', function() {
		console.log("Show modal");
		$('#exampleModal').modal('show');
	});
	});

$('#exampleModal').on('show.bs.modal', function (e) {
	console.log("Show modal");
	var $model = $('#exampleModal');
	$model.find("#inputId").val("");
	$model.find("#inputName").val("");
	$model.find("#inputAge").val("");
});

$(document).on('change', '#inputFileAvatar', inputFileAvatarOnChange);
function inputFileAvatarOnChange() {
	$inputFileAvatar = $("#inputFileAvatar");
	var file = $inputFileAvatar.prop("files")[0];
	var formData = new FormData();
	formData.append("file", file);
	$.ajax({
        url: '/upload-file',
        type: 'POST',
        data: formData,
        // prevent jQuery from automatically transforming the data into a query string
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
        var link = data.uri; 
        $("#imageAvatar").attr("src", link);
            }
    }).done(function (response) {
        console.log(response);
    }).fail(function () {

    });
}