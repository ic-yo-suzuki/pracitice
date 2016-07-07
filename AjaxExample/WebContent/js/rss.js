/**
 *
 */

var jq = jQuery.noConflict();

jq(function($) {
	$.ajax({
		url : "Sample.xml",
		dataType : "xml",
		success : function(data) {
			$("item", data).each(
					function() {
						$("dl").append(
								"<dt><a href = '" + $("link", this).text()
										+ "'>" + $("title", this).text()
										+ "</a></dt><dd>"
										+ $("description", this).text()
										+ "               </dd>");
					})
		}
	})
})
