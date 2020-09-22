// Search user
$(document).on('click', '#searchBtn', buttonSearchOnClick);
function buttonSearchOnClick() {
	var value = $("#tableSearch").val().toLowerCase();
	console.log(value);
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
}

var mode = "add";
$(document).ready(function() {
	// when edit button is click, get data in corresponding row and display in popup
	$('.table').on('click', '#shownBtn', function(){
		
		mode = "edit";
		console.log("Show modal");
		var $model = $('#exampleModal');
		
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
	 
	 // when add button is click and the modal is be shown, reset all data in popup
	 $('#exampleModal').on('show.bs.modal', function (e) {
			console.log("Show modal");
			if (mode == "add") {
				var $model = $('#exampleModal');
				$model.find("#inputId").val("");
				$model.find("#inputName").val("");
				$model.find("#inputAge").val("");
			    $("#imageAvatar").attr("src", "");
			}
		});
});

// Export to CSV
$(document).on('click', '#export', function() {
	  $('.table').tableExport({type:'csv'});
});

// Add user when click add button
$(document).on('click', '#addUser', addUser);
function addUser() {
	mode = "add";
	console.log("Show modal");
	$('#exampleModal').modal('show');
}

// When input image, it auto upload image to server using ajax, then get image after upload success (in success callback) and display in popup
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