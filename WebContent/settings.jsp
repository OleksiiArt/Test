<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/_header.jsp"%>

<html>
<body>
	<form action="changeLocale.jsp" method="post">
		<fmt:message key="settings_jsp.label.set_locale"/>:
		<select name="locale">
			<c:forEach items="${applicationScope.locales}" var="locale">
				<c:set var="selected" value="${locale.key == currentLocale ? 'selected' : '' }"/>
				<option value="${locale.key}" ${selected}>${locale.value}</option>
			</c:forEach>
		</select>
		<input type="submit" value="<fmt:message key='settings_jsp.form.submit_save_locale'/>">
		
	</form>
	<a href="${pageContext.request.contextPath}/"><fmt:message key="settings_jsp.link.back_to_home_page"></fmt:message></a>
</body>
</html>