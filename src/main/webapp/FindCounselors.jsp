<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Find counselor's information</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/find/counselors" method="post">
    <h1>Search for Counselor Info by ID</h1>
    <p>
        <label for="counselorId">Counselor's ID</label>
        <input id="counselorId" name="counselorId" value="${fn:escapeXml(param.counselorId)}">
    </p>
    <p>
        <input type="submit">
        <br/><br/><br/>
        <span>
            <b>${invalidInput != null ? invalidInput : counselorNotFound}</b>
        </span>
    </p>
</form>


</body>
</html>