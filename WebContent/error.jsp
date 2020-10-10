<%@ page isErrorPage="true" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Error Page</title>
<link rel="icon" href="static/images/fav.jpg">
<!-- Bootstrap  -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="static/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="static/bootstrap/3.3.7/jquery/jquery.min.js"></script>
<script src="static/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="links.jsp" />
	<div class="container">
	<c:choose>
		<c:when test="${!empty regDeniedMsg}">
			<!-- Error Message for the registered devotee having morethan 101 days  -->
			<h3 class="text-danger text-center">${regDeniedMsg}</h3>
		</c:when>
		<c:when test="${!empty moveResult}">
			<!-- Error Message for the registered devotee having record is not moving to success table  -->
			<h3 class="text-danger text-center">${moveResult}</h3>
		</c:when>
		<c:when test="${!empty regFailMsg}">
			<!-- Error Message for the registered devotee having record is not moving to success table  -->
			<h3 class="text-danger text-center">Internal Problem..</h3>
			<h3 class="text-danger text-center">${regFailMsg}</h3>
		</c:when>
		<c:otherwise>
			<div class="h1">
				<h3 class="text-danger text-center">Oops! Something went
					wrong...</h3>
				<h3 class="text-danger text-center">Please Try Again...</h3>
			</div>
		</c:otherwise>
	</c:choose>

	<a class="btn btn-info" href="register.jsp" role="button">Try Again</a>




	<!-- I can remove technical error message -->
	<c:if test="${!empty errMsg}">
		<hr />
		<div class="alert alert-danger">
		<h4>Error::</h4>
		<h5 >${errMsg}</h5>
		</div>
		<hr />
	</c:if>
</div>
</body>
</html>