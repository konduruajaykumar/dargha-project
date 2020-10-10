<%@page import="java.time.LocalDate"%>
<%@page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Search Devotees</title>
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
	<jsp:include page="header.jsp" />
	<jsp:include page="links.jsp" />
	<h4 class="text-center text-primary">Search by any one of the
		following......</h4>

	<div class="container-fluid">
		<div class="row" align="center">
			<div class="col-sm-3 col-md-6 col-lg-4">
				<form class="form-horizontal" action="searchRegisteredDevotee"
					method="post">
					<b>Select Id or Mobile No</b> <br> <br>
					<div class="form-group">
						<label class="control-label col-sm-4" for="fieldType">Search
							By:</label>
						<div class="col-sm-8">
							<select class="form-control" id="fieldType" name="fieldType"
								required>
								<option value="">--select--</option>
								<option value="devoteeId" selected="selected">Id</option>
								<option value="mobileNo">Mobile No</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4" for="fieldValue">Search
							Text:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="fieldValue"
								name="fieldValue" placeholder="Search Text" required="required"
								maxlength="20" onkeydown="onlyNumbers(this)">
						</div>
					</div>
					<div class="form-group">
						<div class=" col-sm-offset-3 col-sm-8">
							<button type="submit" class="btn btn-info" name="search"
								value="Search By Id or Mobile No">
								<span class="glyphicon glyphicon-search"></span> Search By Id or
								Mobile No
							</button>
						</div>
					</div>
				</form>
			</div>

			<div class="col-sm-3 col-md-6 col-lg-4">
				<form action="searchRegisteredDevotee" method="post">
					<b>Select Wife / Husband Name / village / Mandal / District</b> <br>
					<br>
					<div class="form-group">
						<label class="control-label col-sm-4" for="fieldType">Search
							By:</label>

						<div class="col-sm-8">
							<select class="form-control" id="fieldType" name="fieldType"
								required>
								<option value="">--select--</option>
								<option value="name">Wife Name</option>
								<option value="husbandName">Husband Name</option>
								<option value="village">village</option>
								<option value="mandal">Mandal</option>
								<option value="visitStatus">visit Status</option>
								<option value="Status">Status</option>
							</select>
						</div>
					</div>
					<br> <br>
					<div class="form-group">
						<label class="control-label col-sm-4" for="fieldValue">Search
							Text:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="fieldValue"
								name="fieldValue" placeholder="Search Text" required
								maxlength="20" onkeydown="onlyNumbers(this)">
						</div>
					</div>
					<br> <br>
					<div class="form-group">
						<div class=" col-sm-offset-3 col-sm-8">
							<button type="submit" class="btn btn-info" name="search"
								value="Search">
								<span class="glyphicon glyphicon-search"></span> Search
							</button>
						</div>
					</div>
				</form>
			</div>

			<div class="col-sm-3 col-md-6 col-lg-4">
				<form action="searchRegisteredDevotee" method="post">
					<b>Select LMP Date / First Date / Visiting Date</b> <br> <br>
					<div class="form-group">
						<label class="control-label col-sm-4" for="fieldType">Search
							By:</label>
						<div class="col-sm-8">
							<select class="form-control" id="fieldType" name="fieldType"
								required>
								<option value="">--select--</option>
								<option value="pregnancyDate">LMP Date</option>
								<option value="firstDate">First Date</option>
								<option value="visitDate" selected="selected">Visit Date</option>
							</select>
						</div>
					</div>
					<br> <br>
					<div class="form-group">
						<label class="control-label col-sm-4" for="fromDate">From:</label>
						<div class="col-sm-8">
							<input type="date" class="form-control" id="fromDate" value="<%=LocalDate.now()%>"
								name="fromDate" placeholder="From Date" required>
						</div>
					</div>
					<br> <br>
					<div class="form-group">
						<label class="control-label col-sm-4" for="toDate">To:</label>
						<div class="col-sm-8">
							<input type="date" class="form-control" id="toDate" name="toDate"  value="<%=LocalDate.now()%>"
								placeholder="To Date" required>
						</div>
					</div>
					<br> <br>
					<div class="form-group">
						<div class=" col-sm-offset-3 col-sm-8">
							<button type="submit" class="btn btn-info" name="search"
								value="Search By Date">
								<span class="glyphicon glyphicon-search"></span> Search By Date
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>