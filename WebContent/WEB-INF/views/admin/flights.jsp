<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Flights</title>
 </head>
 <body>
 
    <jsp:include page="_headerAdmin.jsp"></jsp:include>
    <jsp:include page="_menuAdmin.jsp"></jsp:include>
 
    <h3>Flights</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="7" cellspacing="1" >
       <tr>
          <th>Id</th>
          <th>Number</th>
          <th>Name</th>
          <th>From</th>
          <th>To</th>
          <th>Date</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${flights}" var="flight" >
          <tr>
             <td>${flight.idF}</td>
             <td>${flight.number}</td>
             <td>${flight.name}</td>
             <td>${flight.from}</td>
             <td>${flight.to}</td>
             <td>${flight.flightDate}</td>
             <td>
                <a href="editFlight?idF=${flight.idF}">Edit</a>
             </td>
             <td>
                <a href="deleteFlight?number=${flight.number}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createFlight" >Create Flight</a>
 
 
 </body>
</html>