<%@page isELIgnored="false" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Print</title>
<link rel="icon" href="static/images/fav.jpg">
<script type="text/javascript" src="validation.js"></script>
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


	<div class="container" align="center">
		<h5 class="text-center text-primary">Enter the Id to print the
			registration details....</h5>
		<form class="form-inline" action="searchRegisteredDevotee"
			method="post">
			<div class="form-group">
				<label for="fieldValue">Id:</label> <input type="text"
					class="form-control" id="fieldValue" placeholder="Enter id"
					name="fieldValue" required="required" autofocus="autofocus"
					autocomplete="off" onkeyup="onlyNumbers(this)">
			</div>
			<input type="submit" class="btn btn-info" name="search" value="Print" />
		</form>
	</div>