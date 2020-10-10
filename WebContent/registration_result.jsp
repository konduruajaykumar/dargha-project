<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Result Page</title>
<link rel="icon" href="static/images/fav.jpg">
<!-- Bootstrap  -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="static/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="static/bootstrap/3.3.7/jquery/jquery.min.js"></script>
<script src="static/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
th, td {
	text-align: left;
}

.print-area {
	align: left;
	text-align: left;
	width: 40%;
	border: 1px solid black;
	padding: 5px;
}
</style>

<script>
	function printDiv(elementId) {
		var a = document.getElementById('printing-css').value;
		var b = document.getElementById(elementId).innerHTML;
		window.frames["print_frame"].document.title = document.title;
		window.frames["print_frame"].document.body.innerHTML = '<style>' + a
				+ '</style>' + b;
		window.frames["print_frame"].window.focus();
		window.frames["print_frame"].window.print();
	}
</script>

</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="links.jsp" />
	<div class="container">
		<c:set var="dto" value="${dto}" />
		<c:choose>
			<c:when test="${!empty dto}">
				<div class="container print-area" id="print-area-1" align="center">
					<table align="center">
						<tr>
							<td colspan="2" style="font: bolder;"><b><jsp:include
										page="header1.jsp" /></b></td>
						</tr>
						<tr>
							<th>Id</th>
							<td>${dto.id}</td>
						</tr>
						<tr>
							<th>Name</th>
							<td>${dto.name}</td>
						</tr>
						<tr>
							<th>Husband Name</th>
							<td>${dto.husbandName}</td>
						</tr>
						<tr>
							<th>Village</th>
							<td>${dto.village}</td>
						</tr>
						<tr>
							<th>Mandal</th>
							<td>${dto.mandal}</td>
						</tr>
						<tr>
							<th>District</th>
							<td>${dto.district}</td>
						</tr>
						<tr>
							<th>Mobile No</th>
							<td>${dto.mobileNo}</td>
						</tr>
						<tr>
							<th>LMP Date</th>
							<td>${dto.pregnancyDate}</td>
						</tr>
						<c:if test="${dto.registeredDate ne null }">
							<tr bgcolor="grey">
								<th>Registered Date</th>
								<th>${dto.registeredDate}&nbsp;&nbsp;&nbsp;Days:
									${dto.daysBetweenPdateAndRdate}</th>
							</tr>
						</c:if>
						<tr>
							<th>First Date</th>
							<td>${dto.firstDate}&nbsp;&nbsp;&nbsp;Days:
								${dto.daysBetweenPdateAndFdate}</td>
						</tr>
						<tr>
							<th>Next Visit Date</th>
							<th style="color: red;">${dto.visitDate}&nbsp;&nbsp;&nbsp;Days:
								${dto.daysBetweenPdateAndVdate}</th>
						</tr>
						<%-- 
			<tr>
				<th>Other Details</th>
				<td>${dto.otherDetails}</td>
			</tr>
--%>
					</table>
				</div>
				<br>
				<div class="container" align="center">
					<a href="javascript:printDiv('print-area-1')" role="button"
						class="btn btn-info btn-md active no-print"><span
						class="glyphicon glyphicon-print"></span> Print</a> <a
						href="register.jsp" target="_self"
						class="btn btn-info btn-md active" role="button"> Close</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="container">
					<h3 class="text-danger text-center">No Data found</h3>
				</div>
			</c:otherwise>
		</c:choose>
	</div>


	<textarea id="printing-css" style="display: none; text-align: center;">
	th {
		text-align: left;
		border: 1px solid black;    
		border-collapse: collapse;
		}
		
	td {
		text-align: left;
		border: 1px solid black;    
		border-collapse: collapse;
		}
		
	table {
			align:left;
			text-align: left;
			width:60%;
			height:80%;    
			border: 1px solid black;
			padding:5px;
			margin:0 0 0 -5px;
			border-collapse: collapse;
		}
	</textarea>
	<iframe id="printing-frame" name="print_frame" src="about:blank"
		style="display: none;"></iframe>
</body>
</html>