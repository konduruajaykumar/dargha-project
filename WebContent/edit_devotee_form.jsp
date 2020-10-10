<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Edit Details</title>
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
	<jsp:include page="header2.jsp" />
<%-- 	<jsp:include page="header.jsp" />
 --%>	<jsp:include page="links.jsp" />

	<c:set var="dto" value="${devoteeById}" />
	<c:choose>
		<c:when test="${devoteeById ne null}">

			<h4 class="text-center text-primary">Edit the Details...</h4>
			<br>
			<div class="container">
				<form class="form-horizontal" action="updateDevoteeDetails"
					method="post">
					<div class="form-group">
						<label class="control-label col-sm-5" for="id">Id:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="id" name="id"
								placeholder="Id" required="required" value="${dto.id}" readonly
								onkeyup="onlyNumbers(this)">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-5" for="name">Wife
							Name:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="Wife Name" required="required" maxlength="30"
								value="${dto.name}" readonly onkeydown="onlyAlphabets(this)">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-5" for="husbandName">Husband
							Name:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="husbandName"
								name="husbandName" placeholder="Husband Name"
								required="required" maxlength="30" value="${dto.husbandName}"
								readonly onkeydown="onlyAlphabets(this)">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-5" for="village">Village:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="village"
								name="village" placeholder="Village" required="required"
								value="${dto.village}" readonly maxlength="30"
								onkeydown="onlyAlphabets(this)">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-5" for="mandal">Mandal:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="mandal" name="mandal"
								placeholder="Mandal" required="required" maxlength="30"
								value="${dto.mandal}" readonly onkeydown="onlyAlphabets(this)">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-5" for="district">District:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="district"
								name="district" placeholder="District" required="required"
								value="${dto.district}" readonly maxlength="30"
								onkeydown="onlyAlphabets(this)">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-5" for="mobileNo">Mobile
							No:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="mobileNo"
								name="mobileNo" placeholder="Mobile No" required="required"
								maxlength="10" value="${dto.mobileNo}" readonly
								onkeyup="onlyNumbers(this)">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-5" for="childNo">Child
							No:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="childNo"
								name="childNo" placeholder="Child No" required="required"
								maxlength="2" value="${dto.childNo}" readonly
								onkeyup="onlyNumbers(this)">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-5" for="pDate">LMP
							Date:</label>
						<div class="col-sm-3">
							<input type="date" class="form-control" id="pDate" name="pDate"
								placeholder="LMP Date" required="required"
								value="${dto.pregnancyDate}" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-5" for="firstDate">First
							Date:</label>
						<div class="col-sm-3">
							<input type="date" class="form-control" id="firstDate"
								name="firstDate" placeholder="First Date" required="required"
								value="${dto.firstDate}" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-5" for="visitDate"
							 >Next Visit Date:</label>
						<div class="col-sm-3">
							<input type="date" class="form-control" id="visitDate"
								name="visitDate" placeholder="Next Visit Date"
								value="${dto.visitDate}" readonly>
						</div>
					</div>
					<div class="form-group">
						<label   class="control-label col-sm-5"
							for="visitStatus">Next Visit Status:</label>
						<c:choose>
							<c:when test="${dto.visitStatus eq 'Not visited' }">
								<div class="col-sm-3">
									<select class="form-control" id="visitStatus"
										name="visitStatus"  >
										<option value="Not visited" selected>Not Visited</option>
										<option value="Visited">Visited</option>
									</select>
								</div>
							</c:when>
							<c:when test="${dto.visitStatus eq 'Visited' }">
								<div class="col-sm-3">
									<select class="form-control" id="visitStatus"
										name="visitStatus"  >
										<option value="Not visited">Not Visited</option>
										<option value="Visited" selected>Visited</option>
									</select>
								</div>
							</c:when>
						</c:choose>
					</div>

					<div class="form-group">
						<label  class="control-label col-sm-5"
							for="status">Status:</label>
						<c:choose>
							<c:when test="${dto.status eq 'waiting'}">
								<div class="col-sm-3">
									<select class="form-control" id="status" name="status"
										 >
										<option value="waiting" selected>Waiting</option>
										<option value="success">Success</option>
										<option value="failed">Failed</option>
									</select>
								</div>
							</c:when>
							<c:when test="${dto.status eq 'success'}">
								<div class="col-sm-3">
									<select class="form-control" id="status" name="status"
										 >
										<option value="waiting">Waiting</option>
										<option value="success" selected>Success</option>
										<option value="failed">Failed</option>
									</select>
								</div>
							</c:when>
							<c:when test="${dto.status eq 'failed'}">
								<div class="col-sm-3">
									<select class="form-control" id="status" name="status"
										 >
										<option value="waiting">Waiting</option>
										<option value="success">Success</option>
										<option value="failed" selected>Failed</option>
									</select>
								</div>
							</c:when>
						</c:choose>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-5" for="otherDetails">Other
							Details:</label>
						<div class="col-sm-3">
							<textarea class="form-control" rows="4" id="otherDetails"
								name="otherDetails" placeholder="Other Details" maxlength="100"
								style="resize: none;" readonly>${dto.otherDetails}</textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-5 col-sm-2">
							<button type="submit" class="btn btn-primary">Update</button>
						</div>
						<div class="col-sm-2">
							<a href="controller1?pageNo=1" class="btn btn-primary"
								role="button">Cancel</a>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-5" for="clientToken"></label>
						<div class="col-sm-3">
							<input type="hidden" class="form-control" id="clientToken"
								name="clientToken" placeholder="clientToken" required="required"
								maxlength="30" value="${sToken}">
						</div>
					</div>
				</form>
			</div>
		</c:when>
		<c:otherwise>
			<h3 class="text-danger text-center">Details not Found.......</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>
