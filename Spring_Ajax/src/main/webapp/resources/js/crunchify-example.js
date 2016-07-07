/**
 *
 */

function crunchifyAjax() {
	$.ajax({
		url : 'ajaxtest.html',
		success : function(data) {
			$('#result').html(data);
		}
	});

}