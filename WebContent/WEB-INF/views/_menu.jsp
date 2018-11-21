<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div style="padding: 5px;">
 
   <a href="${pageContext.request.contextPath}/">Home</a>
   |
   <a href="${pageContext.request.contextPath}/showAllFlights">Show flights</a>
   |
   <a href="${pageContext.request.contextPath}/flightByNumber">Flights by number</a>
   |
   <a href="${pageContext.request.contextPath}/flightBy3Param">Flights by 3 param</a>
   |
   <a href="${pageContext.request.contextPath}/login">Login</a>
   |
   <a href="${pageContext.request.contextPath}/logout">Logout</a>
   
   
    
</div>  