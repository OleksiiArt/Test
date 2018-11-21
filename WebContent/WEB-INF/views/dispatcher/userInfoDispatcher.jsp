<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>User Info</title>
 </head>
 <body>
 
    <jsp:include page="_headerDisp.jsp"></jsp:include>
    <jsp:include page="_menuDisp.jsp"></jsp:include>
 
    <h3>Hello Dispatcher: ${user.login}</h3>
 
    User Name: <b>${user.login}</b>
    
    <a href="${pageContext.request.contextPath}/flightsDisp">Flights</a>
  <%--   <br />
    Role: ${user.userRole} <br /> --%>
 
 
 </body>
</html>