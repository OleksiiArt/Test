<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Stewardesses</title>
 </head>
 <body>
 
    <jsp:include page="_headerAdmin.jsp"></jsp:include>
    <jsp:include page="_menuAdmin.jsp"></jsp:include>
 
    <h3>Stewardesses</h3>
 
    <p style="color: red;">${errorString}</p>
    
     <a href="${pageContext.request.contextPath}/pilots">Pilots</a>
   |
   <a href="${pageContext.request.contextPath}/navigators">Navigators</a>
   |
   <a href="${pageContext.request.contextPath}/crewMembers">Crew members</a>
   |
   <a href="${pageContext.request.contextPath}/crewMembers">Crew members</a>
   
 
    <table border="1" cellpadding="7" cellspacing="1" >
       <tr>
      	  <th>Id</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${worker}" var="worker" >
          <tr>
             <td>${worker.id}</td>
             <td>${worker.firstName}</td>
             <td>${worker.lastName}</td>
             <td>
                <a href="editCrewMember?id=${worker.id}">Edit</a>
             </td>
             <td>
                <a href="deleteCrewMember?id=${worker.id}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
 
 
 </body>
</html>