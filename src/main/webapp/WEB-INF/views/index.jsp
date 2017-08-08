<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TV Series</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/tvseries.css" />
</head>
<body>
<div class="container">
	<h1>List of TV Cast</h1>
	<br />
	<a href="addCast"> Add Cast</a> <hr/>
	
	<table class="table table-striped .table-hover">
		<c:forEach var="cast" items="${tvcast}">
			<tr>
				<td>${cast.name}</td>
				<td>${cast.birthPlace}</td>
				<td>${cast.charcaterName}</td>
				<td>${cast.biography}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>