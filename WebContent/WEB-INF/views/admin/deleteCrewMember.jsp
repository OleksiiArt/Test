<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Delete a worker</title>
 </head>
 
 <body>
 
    <jsp:include page="_headerAdmin.jsp"></jsp:include>
    <jsp:include page="_menuAdmin.jsp"></jsp:include>
    
    <h3>Delete a worker</h3>
    
    <p style="color: red;">${errorString}</p>
    <a href="crewMembers">Crew members</a>
    
    
 </body>
</html>