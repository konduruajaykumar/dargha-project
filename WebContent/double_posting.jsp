<%@ page  contentType="text/html; charset=utf-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Double Posting Page</title>
<link rel="icon" href="static/images/fav.jpg">
<!-- Bootstrap  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="static/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="static/bootstrap/3.3.7/jquery/jquery.min.js"></script>
<script src="static/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%-- 	<jsp:include page="header.jsp" />
 --%>	<jsp:include page="header2.jsp" />
	<jsp:include page="links.jsp" />
	
	<h3 class="text-center" >
		Hello! <span class="text-danger"> ${param.name}</span>, Your Details are
		already submitted...
	</h3>
</body>
</html>