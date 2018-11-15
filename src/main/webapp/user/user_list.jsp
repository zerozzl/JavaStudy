<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>java study</title>
</head>
<body>
	<table border="1" cellspacing="0">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>age</td>
		</tr>
		<c:forEach items="${users}" var="item" varStatus="st">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.age}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>