<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update an Applicant</title>
</head>
<body>
	<h1>Update Applicant</h1>
	<form action="${pageContext.request.contextPath}/applicantupdate" method="post">
		<p>
			<label for="personid">PersonId</label>
			<input id="personid" name="personid" value="${fn:escapeXml(param.personid)}">
		</p>
		<p>Seeking Counselor:
		<input type="radio" id="true" name="seekingcounselor" value="true">
  		<label for="true">true</label>
		<input type="radio" id="false" name="seekingcounselor" value="false">
  		<label for="false">false</label><br>
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
	<p>
	<a href="${pageContext.request.contextPath}/Home.jsp"><b>Back to Home Page</b></a>
	</p>
</body>
</html>