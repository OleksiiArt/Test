<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Flights by number</title>
   </head>
   <body>
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Flights by number</h3>
      <p style="color: red;">${errorString}</p>
 
 
      <form method="GET">
         <table border="0">
            <tr>
               <td>Number</td>
               <td><input type="text" name="number" value= "${flight.number}" /> </td>
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
          <tr>
             <td>${flight.number}</td>
             <td>${flight.name}</td>
             <td>${flight.from}</td>
             <td>${flight.to}</td>
             <td>${flight.flightDate}</td>
       
          </tr>
    </table>
 
   </body>
</html>