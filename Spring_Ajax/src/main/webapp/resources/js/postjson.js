/**
 * 
 */

var jq = jQuery.noConflict();

jq("button#update").click(function($) {
	var button = $(this);
	button.attr("disabled", true);

	var data = {
		name : $("#name").val(),
		age : parseInt($("#age").val())
	};

	$.ajax({
		type : "post",
		url : "/path/to/post",
		data : JSON.stringify(data),
		contentType : 'application/json',
		dataType : "json",
		success : function(json_data) {
			if (!json_data[0]) {
				alert("Transaction error. " + json_data[1]);
				return;
			}
			location.reload();
		},
		error : function() {
			alert("Server Error. Please try again later.");
		},
		complete : function() {
			button.attr("disabled", false);
		}
	});
});
