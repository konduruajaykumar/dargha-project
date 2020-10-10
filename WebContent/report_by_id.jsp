<%@ page language="java" isELIgnored="false"
	contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Results</title>
<link rel="icon" href="static/images/fav.jpg">
<!-- Bootstrap  -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="static/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="static/bootstrap/3.3.7/css/mystyles.css">	
<script src="static/bootstrap/3.3.7/jquery/jquery.min.js"></script>
<script src="static/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="links.jsp" />

	<div class="container-fluid">
		<c:if test="${reportData!=null }">
			<h4 class="text-center text-primary">The following are the
				search results...</h4>
			<table
				class="table table-condensed table-hover table-bordered table-striped table-responsive">
				<thead>
					<tr>
						<th>Id</th>
						<th>Wife Name</th>
						<th>Husband Name</th>
						<th>Mobile No</th>
						<th>Village</th>
						<th>Mandal</th>
						<th>District</th>
						<th>LMP Date</th>
						<th>First Date</th>
						<th>Visit Date</th>
						<th>Visited or Not</th>
						<th>Status</th>
						<!-- <th>Other Details</th> -->
						<th>Edit</th>
						<th>Move</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="dto" scope="request" value="${reportData}" />
					<c:if test="${dto != null}">
						<tr>
							<td>${dto.id}</td>
							<td>${dto.name}</td>
							<td>${dto.husbandName}</td>
							<td>${dto.mobileNo}</td>
							<td>${dto.village}</td>
							<td>${dto.mandal}</td>
							<td>${dto.district}</td>
							<td>${dto.pregnancyDate}</td>
							<td>${dto.firstDate}</td>
							<td>${dto.visitDate}</td>
							<td>${dto.visitStatus}</td>
							<td>${dto.status}</td>
							<%-- <td>${dto.otherDetails}</td> --%>
							<td><a href="editDevoteeDetails?id=${dto.id}"
								class="btn btn-info btn-xs" role="button"> Edit</a></td>
							<c:choose>
								<c:when
									test="${dto.status eq 'waiting' or dto.visitStatus eq 'Not visited'}">
									<td style="cursor: not-allowed;"><a
										href="moveDevoteeDetails?id=${dto.id}"
										class="btn btn-danger btn-xs disabled" role="button"> Move</a></td>
								</c:when>
								<c:otherwise>
									<td><a href="moveDevoteeDetails?id=${dto.id}"
										class="btn btn-success btn-xs active" role="button"> Move</a></td>
								</c:otherwise>
							</c:choose>
						</tr>

						<tbody>
					</c:if>
			</table>
		</c:if>
		<c:if test="${empty reportData }">
			<h3 class="text-danger text-center">No Data found</h3>
		</c:if>
	</div>
</body>
</html>
