<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit a navigator</title>
   </head>
   <body>
 
      <jsp:include page="_headerAdmin.jsp"></jsp:include>
      <jsp:include page="_menuAdmin.jsp"></jsp:include>
 
      <h3>Edit a navigator</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty worker}">
         <form method="POST" action="${pageContext.request.contextPath}/editCrewMember">
            <input type="hidden" name="id" value="${worker.id}" />
            <table border="0">
             <tr>
                  <td>Id</td>
                  <td><input type="text" name="id" value="${worker.id}" /></td>
               </tr>
               <tr>
                  <td>First name</td>
                  <td><input type="text" name="firstName" value="${worker.firstName}" /></td>
               </tr>
               <tr>
                  <td>Last name</td>
                  <td><input type="text" name="lastName" value="${worker.lastName}" /></td>
               <tr>
               <tr>
                  <td>Position</td>
                  <%-- <td><input type="text" name="positionId" value="${worker.positionId}" /></td> --%>
                  <td><select name="positionId">
					<option value="1">Pilot</option>
					<option value="2">Navigator</option>
					<option value="3">Radio operator</option>
					<option value="4">Stewardess</option>
				</select>
				</td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/crewMembers">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
 
   </body>
</html>