/**
 *
 */

var timeoutId = 0;
timeoutId = function() {

	$.ajax({
		url : 'ajaxtest.html',
		success : function(data) {
			$('#result').html(data);
		}
	});
	setTimeout(timeoutId, 500);
}
timeoutId();