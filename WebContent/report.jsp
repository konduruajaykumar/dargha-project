<%@ page language="java" isELIgnored="false"
	contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Report</title>
<link rel="icon" href="static/images/fav.jpg">
<script type="text/javascript" src="validation.js"></script>
<!-- Bootstrap  -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" 	href="static/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="static/bootstrap/3.3.7/jquery/jquery.min.js"></script>
<script src="static/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="static/bootstrap/3.3.7/css/mystyles.css">
</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="links.jsp" />

	<div class="container-fluid" >
		<c:choose>
			<c:when test="${!empty reportData }">
				<h4 class="text-center text-primary">Registered Devotee Details</h4>
				<table
					class="table table-condensed table-hover table-bordered table-striped table-responsive">
					<thead>
						<tr>
							<th>S.No</th>
							<th>Id</th>
							<th>Wife Name</th>
							<th>Husband Name</th>
							<th>Mobile No</th>
							<th>Village</th>
							<th>Mandal</th>
							<th>District</th>
							<th>LMP Date</th>
							<th>Reg Date</th>
							<th>First Date</th>
							<th>Visit Date</th>
							<th>Visited/Not</th>
							<th>Status</th>
							<!-- <th>Other Details</th> -->
							<th>Edit</th>
							<th>Move</th>
							
							<!-- <th>Child No</th>
							<th>Days(L->R)</th>
							<th>Days(L->F)</th>
							<th>Days(L->V)</th> -->
						</tr>
					</thead>
					<tbody>
						<c:set var="count" value="0" scope="page" />


						
						<c:forEach var="dto" items="${reportData}">
							<c:set var="count" value="${count + 1}" scope="page"/>
							<tr>
								<td>${count}</td>
								<td>${dto.id}</td>
								<td>${dto.name}</td>
								<td>${dto.husbandName}</td>
								<td>${dto.mobileNo}</td>
								<td>${dto.village}</td>
								<td>${dto.mandal}</td>
								<td>${dto.district}</td>
								<td>${dto.pregnancyDate}</td>
								<td>${dto.registeredDate}</td>
								<td>${dto.firstDate}</td>
								<td>${dto.visitDate}</td>
								<td>${dto.visitStatus}</td>
								<td id="status">${dto.status}</td>
								<%-- <td>${dto.otherDetails}</td> --%>
								<td><a href="editDevoteeDetails?id=${dto.id}" target="_blank"
									class="btn btn-info btn-xs" role="button" ><span class="glyphicon glyphicon-pencil"></span> Edit</a></td>
								<c:choose>
									<c:when
										test="${dto.status eq 'waiting' or dto.visitStatus eq 'Not visited'}">
										<td style="cursor: not-allowed;"><a
											href="moveDevoteeDetails?id=${dto.id}"
											class="btn btn-danger btn-xs disabled" role="button">
												Move</a></td>
									</c:when>
									<c:otherwise>
										<td><a href="moveDevoteeDetails?id=${dto.id}"
											class="btn btn-success btn-xs active" role="button"> Move</a></td>
									</c:otherwise>
								</c:choose>
								
								<%-- <td>${dto.childNo}</td>
								<td>${dto.daysBetweenPdateAndRdate}</td>
								<td>${dto.daysBetweenPdateAndFdate}</td>
								<td>${dto.daysBetweenPdateAndVdate}</td> --%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h3 class="text-danger text-center">No Data found</h3>
			</c:otherwise>
		</c:choose>
	</div>

	<c:if test="${!empty pageCount}">
		<div class="container-fluid ">
			<ul class="pagination pagination">
				<c:forEach var="i" begin="1" end="${pageCount}" step="1">
					<li><a href="controller1?pageNo=${i}">${i}</a></li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
</body>
</html>
