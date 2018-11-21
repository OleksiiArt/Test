<%@page import="javax.servlet.jsp.jstl.core.Config"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
	<a href="settings.jsp"><fmt:message key="home_jsp.link.settings"/></a>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Home Page</h3>
	
	Here we have my first project and let's try to understand what it is...
	<b>Below we can list something</b>
	<ul>
	<li>Login</li>
	<li>Flights</li>
	<li>Edit profile</li>
	<li>etc</li>
	</ul>

</body>
</html>