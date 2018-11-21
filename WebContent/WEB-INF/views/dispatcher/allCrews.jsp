<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Crews</title>
 </head>
 <body>
 
    <jsp:include page="_headerDisp.jsp"></jsp:include>
    <jsp:include page="_menuDisp.jsp"></jsp:include>
 
    <h3>Crews</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="7" cellspacing="1" >
       <tr>
          <th>Id</th>
          <th>Flight</th>
          <th>Pilot1</th>
          <th>Pilot2</th>
          <th>Navigator</th>
          <th>Radio operator</th>
          <th>Stewardess1</th>
          <th>Stewardess2</th>
          <th>Stewardess3</th>
          <th>Stewardess4</th>
          <th>Stewardess5</th>
          <th>Status</th>
       </tr>
       
       <c:forEach items="${crew}" var="crew" >
          <tr>
             <td>${crew.id}</td>
             <td>${crew.flight}</td>
             <td>${crew.pilot1}</td>
             <td>${crew.pilot2}</td>
             <td>${crew.navigator}</td>
             <td>${crew.radio_operator}</td>
             <td>${crew.stewardess1}</td>
             <td>${crew.stewardess2}</td>
             <td>${crew.stewardess3}</td>
             <td>${crew.stewardess4}</td>
             <td>${crew.stewardess5}</td>
             <td>
              <select>
    	<option value="1">Ready</option>
   		 <option value="2">Took off</option>
   		 <option value="3">Flying</option>
   		 <option value="3">Landed</option>
 	 </select>
          </tr>
    
 
       </c:forEach>
    </table>
   
 
    
 
 
 </body>
</html>