<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create a crew</title>
   </head>
   <body>
    
      <jsp:include page="_headerDisp.jsp"></jsp:include>
      <jsp:include page="_menuDisp.jsp"></jsp:include>
       
      <h3>Create a crew</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/addACrew">
         <table border="0">
          <tr>
               <td>Flight</td>
               <td><input type="text" name="flight" value="${crew.flight}" /></td>
            </tr>
            <tr>
               <td>Pilot 1</td>
               <td><input type="text" name="pilot1" value="${crew.pilot1}" /></td>
            </tr>
            <tr>
               <td>Pilot 2</td>
               <td><input type="text" name="pilot2" value="${crew.pilot2}" /></td>
            </tr>
            <tr>
               <td>Navigator</td>
               <td><input type="text" name="navigator" value="${crew.navigator}" /></td>
            </tr>
            <tr>
               <td>Radio operator</td>
               <td><input type="text" name="radio_operator" value="${crew.radio_operator}" /></td>
            </tr>
            <tr>
               <td>Stewardess 1</td>
               <td><input type="text" name="stewardess1" value="${crew.stewardess1}" /></td>
            </tr>
            <tr>
               <td>Stewardess 2</td>
               <td><input type="text" name="stewardess2" value="${crew.stewardess2}" /></td>
            </tr>
            <tr>
               <td>Stewardess 3</td>
               <td><input type="text" name="stewardess3" value="${crew.stewardess3}" /></td>
            </tr>
            <tr>
               <td>Stewardess 4</td>
               <td><input type="text" name="stewardess4" value="${crew.stewardess4}" /></td>
            </tr>
            <tr>
               <td>Stewardess 5</td>
               <td><input type="text" name="stewardess5" value="${crew.stewardess5}" /></td>
            </tr>
            <tr>
               <td>Status</td>
               <td><input type="text" name="status" value="${crew.status}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="flightsDisp">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
       
   </body>
</html>