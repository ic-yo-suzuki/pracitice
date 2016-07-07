onload = init;
var state;
var result;
function init() {
	$("btnData").onclick = prefDisp;
	$("btnClear").onclick = clearDisp;
	state = $('state');
	result = $('result');
}

function prefDisp() {
	state.innerHTML = "処理中です・・・<br />\n";
	var url = "pref.xml.old";
	var paramList = "";

	new Ajax.Request(url, {
		method : 'get',
		onSuccess : getData,
		onFailure : showErrMsg,
		parameters : paramList
	});

	function getData(data) {
		var response = data.responseXML.getElementsByTagName('Response');

		var item = response[0].getElementsByTagName('Item');
		var tmpHtml = "";

		for (i = 0; i < item.length; i++) {
			var prefCd = item[i].getElementsByTagName('PREF_CD');
			var prefCdValue = prefCd[0].firstChild.nodeValue;

			var prefName = item[i].getElementsByTagName('PREF_NAME');
			var prefNameValue = prefName[0].firstChild.nodeValue;

			tmpHtml += prefCdValue + "　" + prefNameValue + "<br />\n";
		}

		result.innerHTML = tmpHtml;
		state.innerHTML = "データを取得しました。<br />\n";

	}

	function showErrMsg() {
		clearDisp();
		state.innerHTML = "データを取得できませんでした。<br />\n";
	}

}

function clearDisp() {
	state.innerHTML = "";
	result.innerHTML = "";
}