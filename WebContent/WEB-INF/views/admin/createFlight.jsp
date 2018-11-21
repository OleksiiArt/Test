<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create Flight</title>
   </head>
   <body>
    
      <jsp:include page="_headerAdmin.jsp"></jsp:include>
      <jsp:include page="_menuAdmin.jsp"></jsp:include>
       
      <h3>Create Flight</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/createFlight">
         <table border="0">
            <tr>
               <td>Number</td>
               <td><input type="text" name="number" value="${flight.number}" /></td>
            </tr>
            <tr>
               <td>Name</td>
               <td><input type="text" name="name" value="${flight.name}" /></td>
            </tr>
            <tr>
               <td>From</td>
               <td><input type="text" name="from" value="${flight.from}" /></td>
            </tr>
            <tr>
               <td>To</td>
               <td><input type="text" name="to" value="${flight.to}" /></td>
            </tr>
            <tr>
               <td>Date</td>
               <td><input type="text" name="flightDate" value="${flight.flightDate}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="flights">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
       
   </body>
</html>