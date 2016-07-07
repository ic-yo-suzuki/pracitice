<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>

<body>
	<h2>${message}</h2>
	<div id="ajax_data">
		<input type="button" id="ajax_btn" value="Ajax通信テスト" /> <br />
		outputData:<span id="output_data"></span>

	</div>

<script type="text/javascript" src="<c:url value = "/resources/js/lib/prototype.js"/>"></script>
<script type="text/javascript" src="<c:url value = "/resources/js/lib/jquery-1.12.4.min.js"/>"></script>
<script type="text/javascript" src="<c:url value = "/resources/js/getjson.js" />"></script>
</body>
</html>
