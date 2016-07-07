<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head>
<body>
	<p th:text="${message}">Thymeleafのサンプルです</p>

	<form action="/ThymeleafSpringExample/top/" method="post" th:object="${person}">
		名前：<input type="text" name="name" th:field="*{name}" required="required" /><br>
		年齢：<input type="text" name="age"  th:field="*{age}"  required="required" /><br>
		 <input type="submit" value="送信" />
	</form>

</body>
</html>
