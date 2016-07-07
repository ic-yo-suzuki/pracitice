/**
 *
 */

var jq = jQuery.noConflict();

jq(function($) {
	$("#ajax_btn").click(function() {
		$("#output_data").text("");
		$.ajax({
			type : "GET",
			url : "getTestData",
			dataType : "json",
			success : function(data) {
				success(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				error(XMLHttpRequest, textStatus, errorThrown);
			}
		});
	});
});

function success(data) {
	alert("success:" + data);
	jq("#output_data").text("");
	for (var cnt = 0; cnt < data.length; cnt++) {
		jq("#output_data").append(
				"<br>data[" + cnt + "]:" + data[cnt] + ";<br>");
	}
}

function error(XMLHttpRequest, textStatus, errorThrown) {
	alert("error:" + XMLHttpRequest);
	alert("status:" + textStatus);
	alert("errorThrown:" + errorThrown);
}