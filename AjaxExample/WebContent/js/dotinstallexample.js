/**
 * dotinstall.js
 * ドットインストールの学習用に作成したスクリプト
 *
 * prototype.jsと同時に使用するため、衝突回避用の記述あり
 *
 */

var jq = jQuery.noConflict();	// prototype.jsとjQueryの衝突回避

jq(function($) {	// functionの引数に$を渡すと内部では$でjQueryの参照が可能になる
	// 以下関数のブロック終了まで$はjQueryのものになる
	$('button').click(function() { // ボタンクリック

		$('#result').load('more.html', function() { // HTMLファイルの読み込み
			var elements = "color";
			var color = "red";
			$('#message').css(elements, color); // jQuery.load()の終了後に呼び出すコールバック関数
		});

	});
});

// ここより下では$はprototype.jsのものとして動作