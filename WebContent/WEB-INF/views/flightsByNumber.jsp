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
 
  <c:if test="${not empty flight}">
         <form method="POST" action="${pageContext.request.contextPath}/flightByNumber">
            <input type="hidden" name="number" value="${flight.number}" />
            <table border="0">
               <tr>
                  <td>Number</td>
                  <td><input type ="text" name="number" style="color:red;"value="${flight.number}"/></td>
               </tr>
               <tr>
                  <td>Name</td>
                  <td><input type="text" name="name" value="${flight.name}" /></td>
               </tr>
               <tr>
                  <td>From</td>
                  <td><input type="text" name="from" value="${flight.from}" /></td>
                   <tr>
                  <td>To</td>
                  <td><input type="text" name="to" value="${flight.to}" /></td>
               </tr>
                <tr>
                  <td>Date</td>
                  <td><input type="text" name="flightDate" value="${flight.flightDate}" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                     <input type="submit" value="Submit" />
                   <%--    <a href="${pageContext.request.contextPath}/flights">Cancel</a>   --%>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
 </body>
</html>