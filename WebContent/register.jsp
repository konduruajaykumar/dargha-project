<%@page import="java.time.LocalDate"%>
<%@ page contentType="text/html; charset= UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Register</title>
<link rel="icon" href="static/images/fav.jpg">
<script type="text/javascript" src="validation.js"></script>
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

	<h4 class="text-center text-primary">Enter Following Details...</h4>
	<br>
	<div class="container">
		<form class="form-horizontal" data-toggle="validator" role="form"
			action="devoteeRegisterController" method="post">
			<div class="form-group">
				<label class="control-label col-sm-5" for="name">Wife Name:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control text-uppercase" id="name" name="name"
						placeholder="Wife Name" required maxlength="30"
						onkeydown="onlyAlphabets(this)">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="husbandName">Husband
					Name:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control text-uppercase" id="husbandName"
						name="husbandName" placeholder="Husband Name" required="required"
						maxlength="30" onkeydown="onlyAlphabets(this)">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="village">Village:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control text-uppercase" id="village" name="village"
						placeholder="Village" required maxlength="30"
						onkeydown="onlyAlphabets(this)">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="mandal">Mandal:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control text-uppercase" id="mandal" name="mandal"
						placeholder="Mandal" required maxlength="30"
						onkeydown="onlyAlphabets(this)">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="district">District:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control text-uppercase" id="district"
						name="district" placeholder="District" required="required"
						maxlength="30" onkeydown="onlyAlphabets(this)">  
						<!-- 
						<select id="district"
							name="district" placeholder="District" required="required">
							<option value="ADILABAD">ADILABAD</option>
							<option value="BHADRADRI KOTHAGUDEM">BHADRADRI KOTHAGUDEM</option>
							<option value="HYDERABAD">HYDERABAD</option>
							<option value="JAGTIAL">JAGTIAL</option>
							<option value="JANGAON">JANGAON</option>
							<option value="JAYASHANKAR BHUPALAPALLY">JAYASHANKAR BHUPALAPALLY</option>
							<option value="JOGULAMBA GADWAL">JOGULAMBA GADWAL</option>
							<option value="KAMAREDDY">KAMAREDDY</option>
							<option value="KARIMNAGAR">KARIMNAGAR</option>
							<option value="KHAMMAM">KHAMMAM</option>
							<option value="KUMARAMBHEEM ASIFABAD">KUMARAMBHEEM ASIFABAD</option>
							<option value="MAHABUBABAD">MAHABUBABAD</option>
							<option value="MAHABUBNAGAR">MAHABUBNAGAR</option>
							<option value="MANCHERIAL">MANCHERIAL</option>
							<option value="MEDAK">MEDAK</option>
							<option value="MEDCHAL–MALKAJGIRI">MEDCHAL–MALKAJGIRI</option>
							<option value="NAGARKURNOOL">NAGARKURNOOL</option>
							<option value="NALGONDA">NALGONDA</option>
							<option value="NIRMAL">NIRMAL</option>
							<option value="NIZAMABAD">NIZAMABAD</option>
							<option value="PEDDAPALLI">PEDDAPALLI</option>
							<option value="RAJANNA SIRCILLA">RAJANNA SIRCILLA</option>
							<option value="RANGA REDDY">RANGA REDDY</option>
							<option value="SANGAREDDY">SANGAREDDY</option>
							<option value="SIDDIPET">SIDDIPET</option>
							<option value="SURYAPET">SURYAPET</option>
							<option value="VIKARABAD">VIKARABAD</option>
							<option value="WANAPARTHY">WANAPARTHY</option>
							<option value="WARANGAL RURAL">WARANGAL RURAL</option>
							<option value="WARANGAL URBAN">WARANGAL URBAN</option>
							<option value="YADADRI BHUVANAGIRI">YADADRI BHUVANAGIRI</option>
						
						</select>
						-->
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="mobileNo">Mobile
					No:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control text-uppercase" id="mobileNo"
						name="mobileNo" placeholder="Mobile No" required="required"
						maxlength="10" onkeyup="onlyNumbers(this)">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="childNo">Child
					No:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control text-uppercase" id="childNo" name="childNo"
						placeholder="Child No" required maxlength="2"
						onkeyup="onlyNumbers(this)">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="pDate">LMP Date:</label>
				<div class="col-sm-3">
					<input type="date" class="form-control text-uppercase" id="pDate" name="pDate"
						placeholder="LMP Date" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="firstDate">First
					Date:</label>
				<div class="col-sm-3">
					<input type="date" class="form-control" id="firstDate"
						name="firstDate" placeholder="First Date" required
						value="<%=LocalDate.now()%>">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-5" for="otherDetails">Other
					Details:</label>
				<div class="col-sm-3">
					<textarea class="form-control text-uppercase" rows="4" id="otherDetails"
						name="otherDetails" placeholder="Other Details" maxlength="100"
						style="resize: none;"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-5 col-sm-2">
					<button type="reset" class="btn btn-info">Clear</button>
				</div>
				<div class=" col-sm-2">
					<button type="submit" class="btn btn-info">Register</button>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="visitDate"
					style="display: none;">Next Visit Date:</label>
				<div class="col-sm-3">
					<input type="date" class="form-control" id="visitDate"
						name="visitDate" placeholder="Next Visit Date"
						style="display: none;">
				</div>
			</div>
			<div class="form-group">
				<label style="display: none;" class="control-label col-sm-5"
					for="visitStatus">Next Visit Status:</label>
				<div class="col-sm-3">
					<select class="form-control" id="visitStatus" name="visitStatus"
						style="display: none;">
						<option value="Not visited" selected="selected">Not
							Visited</option>
						<option value="Visited">Visited</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label style="display: none;" class="control-label col-sm-5"
					for="status">Status:</label>
				<div class="col-sm-3">
					<select class="form-control" id="status" name="status"
						style="display: none;">
						<option value="waiting" selected="selected">Waiting</option>
						<option value="success">Success</option>
						<option value="failed">Failed</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="clientToken"></label>
				<div class="col-sm-3">
					<input type="hidden" class="form-control" id="clientToken"
						name="clientToken" placeholder="clientToken" required
						maxlength="30" value="${sToken}">
				</div>
			</div>
		</form>
	</div>

</body>
</html>