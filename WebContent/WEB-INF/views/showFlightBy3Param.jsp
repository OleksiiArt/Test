<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flights by 3 param</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Flights 3 param</h3>
	<p style="color: red;">${errorString}</p>

	<form method="GET">
         <table border="0">
            <tr>
               <td>From</td>
               <td><input type="text" name="from" value= "${flight.from}" /> </td>
            </tr>
            <tr>
               <td>To</td>
               <td><input type="text" name="to" value= "${flight.to}" /> </td>
            </tr>
            <tr>
               <td>Flight Date</td>
               <td><input type="text" name="flightDate" value= "${flight.flightDate}" /> </td>
            </tr>
            <tr>
               <td colspan ="2">
                  <input type="submit" value= "Search" />
                  <a href="${pageContext.request.contextPath}/">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
      
      <table border="1" cellpadding="7" cellspacing="1" >
       <tr>
          <th>Number</th>
          <th>Name</th>
          <th>From</th>
          <th>To</th>
          <th>Date</th>
   
       </tr>
      <%--  <c:forEach items="${flight}" var="flight" > --%>
          <tr>
             <td>${flight.number}</td>
             <td>${flight.name}</td>
             <td>${flight.from}</td>
             <td>${flight.to}</td>
             <td>${flight.flightDate}</td>
       
          </tr>
          <%-- </c:forEach> --%>
    </table>
</body>
</html>