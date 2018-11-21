<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>All flights</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>All flights</h3>
 
    <p style="color: red;">${errorString}</p>
    
 
  <a href="${pageContext.request.contextPath}/showFlightsName">Sorted by name</a>
  |
  <a href="${pageContext.request.contextPath}/showFlightsNumber">Sorted by number</a>
	

 
    <table border="1" cellpadding="7" cellspacing="1" >
       <tr>
          <th>Number</th>
          <th>Name</th>
          <th>From</th>
          <th>To</th>
          <th>Date</th>
       </tr>
       
       
       <c:forEach items="${flight2}" var="flight" >
          <tr>
             <td>${flight.number}</td>
             <td>${flight.name}</td>
             <td>${flight.from}</td>
             <td>${flight.to}</td>
             <td>${flight.flightDate}</td>
       
          </tr>
       </c:forEach>
    </table>
  
   
    
 </body>
</html>