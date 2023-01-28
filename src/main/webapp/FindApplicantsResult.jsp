<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Activities</title>
</head>
<body>
<h1>Result</h1>
    <h2>Applicant Basic Information</h2>
        <table border="1">
            <tr>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Gender</th>
                <th>DateOfBirth</th>
                <th>SeekingCounselors</th>
                <th>HighSchool</th>
                <th>City</th>
                <th>State</th>
                <th>ZipCode</th>
                <th>Race</th>
                <th>ParentEducationLevel</th>
          </tr>
          <tr>
                <th>${person.getFirstName()}</th>
                <th>${person.getLastName()}</th>
                <th>${person.getEmail()}</th>
                <th>${applicant.getGender()}</th>
                <th>${applicant.getDateOfBirth()}</th>
                <th>${applicant.getSeekingCounselors() ? "Yes" : "No"}</th>
                <th>${applicant.getHighschool()}</th>
                <th>${applicant.getCity()}</th>
                <th>${applicant.getState()}</th>
                <th>${applicant.getZipCode()}</th>
                <th>${applicant.getRaceEthnicity()}</th>
                <th>${applicant.getParentEduLevel()}</th>
          </tr>
        </table>

    <h2>Collections</h2>
        <table border="1">
            <tr>
                <th>University</th>
                <th>Notes</th>
            </tr>
            <c:forEach items="${collections}" var = "collection">
                <tr>
                    <th align="left">${collection.getUniversities().getInstitutionName()}</th>
                    <th align="left">${collection.getNotes()}</th>
                </tr>
            </c:forEach>
        </table>

    <h2>Comments made by ${person.getFirstName()}, ${person.getLastName()}</h2>
        <table border="1">
            <tr>
                <th>University</th>
                <th>Content</th>
                <th>CreatedAt</th>
            </tr>
            <c:forEach items="${comments}" var = "comment">
                <tr>
                    <th align="left">${comment.getUniversity().getInstitutionName()}</th>
                    <th align="left">${comment.getContent()}</th>
                    <th align="left">${comment.getCreateAt()}</th>
                </tr>
            </c:forEach>
        </table>

    <h2>Comments Like by ${person.getFirstName()}, ${person.getLastName()}</h2>
        <table border="1">
            <tr>
                <th>University</th>
                <th>Content</th>
                <th>ContentAuthor</th>
                <th>LikedAt</th>
            </tr>
            <c:forEach items="${commentsLikes}" var = "commentsLike">
                <tr>
                    <th align="left">${commentsLike.getComment().getUniversity().getInstitutionName()}</th>
                    <th align="left">${commentsLike.getComment().getContent()}</th>
                    <th align="left">${commentsLike.getComment().getPerson().getUserName()}</th>
                    <th align="left">${commentsLike.getCreateAt()}</th>
                </tr>
            </c:forEach>
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
