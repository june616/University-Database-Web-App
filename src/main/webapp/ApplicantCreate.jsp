<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create an Applicant</title>
</head>
<body>
	<h1>Create Applicant</h1>
	<form action="applicantcreate" method="post">
		<p>
			<label for="personid">PersonId(6 digit integer larger than 20000)</label>
			<input id="personid" name="personid" value="">
		</p>
		
		<p>
			<label for="username">UserName</label>
			<input id="username" name="username" value="">
		</p>
		<p>
			<label for="passcode">PassCode</label>
			<input id="passcode" name="passcode" value="">
		</p>
		<p>
			<label for="firstname">FirstName</label>
			<input id="firstname" name="firstname" value="">
		</p>
		<p>
			<label for="lastname">LastName</label>
			<input id="lastname" name="lastname" value="">
		</p>
		<p>
			<label for="email">Email</label>
			<input id="email" name="email" value="">
		</p>
		
		<p>Gender:
		<input type="radio" id="male" name="gender" value="Male">
		<label for="male">Male</label>
		<input type="radio" id="female" name="gender" value="Female">
		<label for="female">Female</label>
		<input type="radio" id="unidentified" name="gender" value="Unidentified">
		<label for="unidentified">Unidentified</label><br>
		</p>
		<p>
			<label for="dob">DateOfBirth (yyyy-mm-dd)</label>
			<input id="dob" name="dob" value="">
		</p>
		
		<p>SeekingCounselor:
		<input type="radio" id="true" name="seekingcounselor" value="true">
		<label for="true">Yes</label>
		<input type="radio" id="false" name="seekingcounselor" value="false">
		<label for="false">No</label><br>
		</p>
		<p>
			<label for="highschool">HighSchool</label>
			<input id="highschool" name="highschool" value="">
		</p>
		<p>
			<label for="city">City</label>
			<input id="city" name="city" value="">
		</p>
		<p>
			<label for="state">State</label>
			<input id="state" name="state" value="">
		</p>
		<p>
			<label for="zipcode">ZipCode</label>
			<input id="zipcode" name="zipcode" value="">
		</p>
		<p>
			<label for="raceethnicity">RaceEthnicity</label>
			<input id="raceethnicity" name="raceethnicity" value="">
		</p>
		<p>
			<label for="parentedulevel">ParentEducationLevel</label>
			<input id="parentedulevel" name="parentedulevel" value="">
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