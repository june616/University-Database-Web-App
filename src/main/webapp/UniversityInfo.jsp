<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
            crossorigin="anonymous"
    />
    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"
    ></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
            integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
            crossorigin="anonymous"
    ></script>
    <title>University Info</title>
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
                        <a id="first-click" class="nav-link" href=${pageContext.request.contextPath}/rankings>Ranking</a>
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
                    <input class="form-control me-2" type="search" placeholder="University Name"
                           aria-label="University Name" name="instnm" value="${fn:escapeXml(param.instnm)}">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>

    <h1>University Information</h1>
    <hr class="rounded" />
    <h2>${university.getInstitutionName()}</h2>
    <div>
        <dl class="row">
            <dt class="col-sm-3">HomePage</dt>
            <dd class="col-sm-9">
                ${university.getSchoolUrl()}
            </dd>

            <dt class="col-sm-3">Location</dt>
            <dd class="col-sm-9">
                <dl class="row">
                    <dt class="col-sm-4">City</dt>
                    <dd class="col-sm-8">${university.getCity()}</dd>
                </dl>
                <dl class="row">
                    <dt class="col-sm-4">State</dt>
                    <dd class="col-sm-8">${university.getState().getStateName()}</dd>
                </dl>
                <dl class="row">
                    <dt class="col-sm-4">ZIP code</dt>
                    <dd class="col-sm-8">${university.getZip()}</dd>
                </dl>
            </dd>
            <dt class="col-sm-3">Tuition and Fees</dt>
            <dd class="col-sm-9">
                <dl class="row">
                    <dt class="col-sm-4">In-state</dt>
                    <dd class="col-sm-8">${university.getTuitionInState()}</dd>
                </dl>
                <dl class="row">
                    <dt class="col-sm-4">Out-of-state</dt>
                    <dd class="col-sm-8">${university.getTuitionOutOfState()}</dd>
                </dl>
                <dl class="row">
                    <dt class="col-sm-4">program-year intuitions</dt>
                    <dd class="col-sm-8">${university.getTuitionProgramYear()}</dd>
                </dl>
            </dd>
            <dt class="col-sm-3">Admission Rate</dt>
            <dd class="col-sm-9">
                <dl class="row">
                    <dt class="col-sm-4">Average SAT score</dt>
                    <dd class="col-sm-8">${university.getSatScoresAverageByOpeId()}</dd>
                </dl>
                <dl class="row">
                    <dt class="col-sm-4">Enrollment of undergraduate students</dt>
                    <dd class="col-sm-8">${university.getSizeOfUndergraduateAndDegreeSeeking()}</dd>
                </dl>
                <dl class="row">
                    <dt class="col-sm-4">Admission rate</dt>
                    <dd class="col-sm-8">${university.getAdmissionRateOverall()}</dd>
                </dl>
            </dd>
        </dl>
    </div>
    <hr class="rounded" />
    <h2>Campuses</h2>
    <div class="overflow-auto" style="display: flex">
        <c:forEach items="${campuses}" var = "campus">
            <div class="card" style="min-width: 350px!important;margin:10px!important">
                <div class="card-body">
                    <h5 class="card-title">${campus.getLocationName()}</h5>
                    <p class="card-text">
                        <dt class="col-sm-3">Type</dt>
                        <dd class="col-sm-9">
                                ${campus.getLocationType()}
                        </dd>
                        <dt class="col-sm-3">Address</dt>
                        <dd class="col-sm-9">
                                ${campus.getAddress()}
                        </dd>
                        <dt class="col-sm-3">Phone</dt>
                        <dd class="col-sm-9">
                                ${campus.getGeneralPhone()}
                        </dd>
                        <dt class="col-sm-3">Contacts</dt>
                        <dd class="col-sm-9">
                            <dl class="row">
                                <dt class="col-sm-5">Admin Name</dt>
                                <dd class="col-sm-5">${campus.getAdminName()}</dd>
                            </dl>
                            <dl class="row">
                                <dt class="col-sm-5">Phone</dt>
                                <dd class="col-sm-5">${campus.getAdminPhone()}</dd>
                            </dl>
                            <dl class="row">
                                <dt class="col-sm-5">Email</dt>
                                <dd class="col-sm-5">${campus.getAdminEmail()}</dd>
                            </dl>
                        </dd>
                    </p>
                </div>
            </div>
        </c:forEach>

    </div>

    <hr class="rounded" />
    <h2>Degrees Provided</h2>
    <div class="overflow-auto" style="max-height: 500px">
        <table class="table table-hover table-striped overflow-auto" style="max-height: 300px">
            <thead>
            <tr>
                <th scope="col">Degree Level</th>
                <th scope="col">Program Title</th>
                <th scope="col">Descriptions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${degrees}" var = "degree">
                <tr>
                    <th scope="row">${degree.getDegreeLevel().getCREDDESC()}</th>
                    <td>${degree.getCip().getCIPTitle()}</td>
                    <td>${degree.getCip().getCIPDefinition()}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>

    <hr class="rounded" />
    <h2>Recommended Universities</h2>
    <div class="overflow-auto">
        <div class="card" style="width: 18rem">
            <img class="card-img-top" src="..." alt="Card image cap" />
            <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">
                    Some quick example text to build on the card title and make up the
                    bulk of the card's content.
                </p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

