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
 
    <jsp:include page="_headerDisp.jsp"></jsp:include>
    <jsp:include page="_menuDisp.jsp"></jsp:include>
 
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
       </tr>
       <c:forEach items="${flight}" var="flight" >
          <tr>
             <td>${flight.idF}</td>
             <td>${flight.number}</td>
             <td>${flight.name}</td>
             <td>${flight.from}</td>
             <td>${flight.to}</td>
             <td>${flight.flightDate}</td>
          </tr>
       </c:forEach>
    </table>
 
     <table border="1" cellpadding="7" cellspacing="1" >
       <tr>
          <th>Id</th>
          <th>First name</th>
          <th>Last name</th>
       </tr>
       <c:forEach items="${worker}" var="worker" >
          <tr>
             <td>${worker.id}</td>
             <td>${worker.firstName}</td>
             <td>${flight.lastName}</td>
          </tr>
       </c:forEach>
    </table>
 
 
 </body>
</html>