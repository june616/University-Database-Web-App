<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Activities</title>
</head>
<body>
<h1>Result</h1>
    <h2>Counselor's Basic Information</h2>
        <table border="1">
            <tr>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Gender</th>
                <th>YearsOfExperience</th>
                <th>AcceptingNewStudent</th>
                <th>City</th>
                <th>State</th>
                <th>ZipCode</th>
                <th>Race</th>
          </tr>
          <tr>
                <th>${person.getFirstName()}</th>
                <th>${person.getLastName()}</th>
                <th>${person.getEmail()}</th>
                <th>${counselor.getGender()}</th>
                <th>${counselor.getYearsOfExperience()}</th>
                <th>${counselor.getAcceptingNewStudent() ? "Yes" : "No"}</th>
                <th>${counselor.getCity()}</th>
                <th>${counselor.getState()}</th>
                <th>${counselor.getZipCode()}</th>
                <th>${counselor.getRaceEthnicity()}</th>
          </tr>
        </table>

  <h2>Meetings Participated</h2>
        <table border="1">
            <tr>
                <th>EventTitle</th>
                <th>Start</th>
                <th>End</th>
                <th>Host</th>
            </tr>
            <c:forEach items="${reservationsAsParticipant}" var = "rp">
                <tr>
                    <th align="left">${rp.getEventTitle()}</th>
                    <th align="left">${rp.getEventBegin()}</th>
                    <th align="left">${rp.getEventEnd()}</th>
                    <th align="left">${rp.getHost().getUserName()}</th>
                </tr>
            </c:forEach>
        </table>

    <h2>Meetings Hosted</h2>
        <table border="1">
            <tr>
                <th>EventTitle</th>
                <th>Start</th>
                <th>End</th>
                <th>Participant</th>
                <th>CreatedAt</th>
            </tr>
            <c:forEach items="${reservationsAsHost}" var = "rh">
                <tr>
                    <th align="left">${rh.getEventTitle()}</th>
                    <th align="left">${rh.getEventBegin()}</th>
                    <th align="left">${rh.getEventEnd()}</th>
                    <th align="left">${rh.getParticipant().getUserName()}</th>
                    <th align="left">${rh.getCreateAt()}</th>
                </tr>
            </c:forEach>
        </table>
<p>
<a href="${pageContext.request.contextPath}/Home.jsp"><b>Back to Home Page</b></a>
</p>
</body>
</html>