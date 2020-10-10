<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Devotee Result</title>
<link rel="icon" href="static/images/fav.jpg">
<!-- Bootstrap  -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="static/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="static/bootstrap/3.3.7/jquery/jquery.min.js"></script>
<script src="static/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="links.jsp" />

	<h3 class="text-success text-center"> Id '${param.id}' Details ${updateResult}. <%-- whose 
		Name is ${param.name} --%></h3>
	
	
	
</body>
</html>