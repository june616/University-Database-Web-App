<%--
  Created by IntelliJ IDEA.
  User: zhuoyahuang
  Date: 11/15/22
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <script>
      $("#second-click")[0].click()
    </script>
    <title>Title</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href=${pageContext.request.contextPath}>Higher Education Search and Match</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a id="second-click" class="nav-link" href=${pageContext.request.contextPath}/rankings>Ranking</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Applicant Panel
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href=${pageContext.request.contextPath}/ApplicantCreate.jsp>Create an applicant</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href=${pageContext.request.contextPath}/ApplicantUpdate.jsp>Update an applicant</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href=${pageContext.request.contextPath}/ApplicantDelete.jsp>Delete an applicant</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li style="padding: 5px">
                                <form class="d-flex" style="flex-direction: column!important" action="${pageContext.request.contextPath}/find/applications" method="post">
                                    <input class="form-control me-2" type="search" placeholder="Applicant ID" aria-label="Applicant ID" name="applicantId" value="${fn:escapeXml(param.applicantId)}">
                                    <button class="btn btn-outline-success" type="submit">Search Applicant</button>
                                </form>
                            </li>
                            <li><hr class="dropdown-divider"></li>
                            <li style="padding: 5px">
                                <form class="d-flex" style="flex-direction: column!important" action="${pageContext.request.contextPath}/find/counselors" method="post">
                                    <input class="form-control me-2" type="search" placeholder="Conselor ID" aria-label="Conselor ID" name="counselorId" value="${fn:escapeXml(param.counselorId)}">
                                    <button class="btn btn-outline-success" type="submit">Search Conselor</button>
                                </form>
                            </li>
                        </ul>
                    </li>
                </ul>
                <form class="d-flex"  action="${pageContext.request.contextPath}/find/university" method="post">
                    <input class="form-control me-2" type="search" placeholder="Name"
                           aria-label="University Name" name="instnm" value="${fn:escapeXml(param.instnm)}">
                    <button class="btn btn-outline-success" type="submit">Search University</button>
                </form>
            </div>
        </div>
    </nav>
    <div  class="container">
        <ul class="nav nav-tabs mb-3" id="ex1" >
            <li class="nav-item" >
                <a
                        href=${pageContext.request.contextPath}/ranking
                        class="nav-link"
                        data-bs-toggle="tab"
                        data-bs-target="#ex1-tabs-2"

                >CWRU Ranking
                </a
                >
            </li>
            <li class="nav-item" >
                <a
                        class="nav-link"
                        data-bs-toggle="tab"
                        data-bs-target="#ex1-tabs-3"
                <%--                        href="#ex1-tabs-3"--%>
                >US News Ranking</a
                >
            </li>
            <li class="nav-item" >
                <a
                        class="nav-link"
                        data-bs-toggle="tab"
                        data-bs-target="#ex1-tabs-4"
                >Shanghai Ranking</a
                >
            </li>
            <li class="nav-item" >
                <a
                        class="nav-link"
                        data-bs-toggle="tab"
                        data-bs-target="#ex1-tabs-5"
                >Times Ranking</a
                >
            </li>
        </ul>
        <div class="tab-content" id="ex1-content">
            <div class="tab-pane fade" id="ex1-tabs-2" >
                <table class="table table-hover table-striped overflow-auto">
                    <tr>
                        <th>University Name</th>
                        <th>CWRU Rank in 2022</th>
                    </tr>
                    <c:forEach items="${top50CwruRank}" var="rank">
                        <tr>
                            <td align="left">
                                <a href="${pageContext.request.contextPath}/university?UNITID=${rank.getUniversity().getUnitId()}">
                                        ${rank.getUniversityName()}
                                </a>
                            </td>
                            <td align="right">${rank.getWorldRank()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="tab-pane fade" id="ex1-tabs-3" >
                <table class="table table-hover table-striped overflow-auto">
                    <tr>
                        <th>University Name</th>
                        <th>US News Rank in 2022</th>
                    </tr>
                    <c:forEach items="${top50USNewsRank}" var="rank">
                        <tr>
                            <td align="left">
                                <a href="${pageContext.request.contextPath}/university?UNITID=${rank.getUniversity().getUnitId()}">
                                        ${rank.getUniversityName()}
                                </a>
                            </td>
                            <td align="right">${rank.getRank2022()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="tab-pane fade" id="ex1-tabs-4">
                <table class="table table-hover table-striped overflow-auto">
                    <tr>
                        <th>University Name</th>
                        <th>Shanghai Rank in 2022</th>
                    </tr>
                    <c:forEach items="${top50ShanghaiRank}" var="rank">
                        <tr>
                            <td align="left">
                                <a href="${pageContext.request.contextPath}/university?UNITID=${rank.getUniversity().getUnitId()}">
                                        ${rank.getUniversityName()}
                                </a>
                            </td>
                            <td align="right">${rank.getWorldRank()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="tab-pane fade" id="ex1-tabs-5">
                <table class="table table-hover table-striped overflow-auto">
                    <tr>
                        <th>University Name</th>
                        <th>Times Rank in 2022</th>
                    </tr>
                    <c:forEach items="${top50TimesRank}" var="rank">
                        <tr>
                            <td align="left">
                                <a href="${pageContext.request.contextPath}/university?UNITID=${rank.getUniversity().getUnitId()}">
                                        ${rank.getUniversityName()}
                                </a>
                            </td>
                            <td align="right">${rank.getWorldRank()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>


</body>
</html>
