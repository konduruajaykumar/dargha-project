<%@ page language="java" isELIgnored="false"
	contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Contact</title>
<link rel="icon" href="static/images/fav.jpg"
	href="/HBProj8_DevoteesDetails_Layered_Application/WebContent/static/images/fav.jpg"
	sizes="32x32" type="image/png">
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


	<!-- Container (Contact Section) -->
	<div id="contact" class="container bg-grey">
		<h2 class="text-center text-info">Contact Us</h2>
		<br>
		<div class="row">
			<div class="col-sm-offset-3 col-sm-5">
				<!-- <p>Contact us and we'll get back to you within 24 hours.</p> -->
				<p>
					<span class="glyphicon glyphicon-user"></span> Dr. C.Venkat Raja
				</p>
				<p>
					<span class="glyphicon glyphicon-map-marker"></span> Tudukurti(V),
					Nagar Kurnool, Telangana-509209
				</p>
				<p>
					<span class="glyphicon glyphicon-phone"></span> 9440282246
				</p>
				<p>
					<span class="glyphicon glyphicon-phone-alt"></span> 7013134327
				</p>
				<p>
					<span class="glyphicon glyphicon-envelope"></span>
					chigullapallyvenkatraja178@gmail.com
				</p>
			</div>
			<!-- Contact Form -->
			<!-- <div class="col-sm-7 slideanim">
				<div class="row">
					<div class="col-sm-6 form-group">
						<input class="form-control" id="name" name="name"
							placeholder="Name" type="text" required>
					</div>
					<div class="col-sm-6 form-group">
						<input class="form-control" id="email" name="email"
							placeholder="Email" type="email" required>
					</div>
				</div>
				<textarea class="form-control" id="comments" name="comments"
					placeholder="Comment" rows="5" ></textarea>
				<br>
				<div class="row">
					<div class="col-sm-12 form-group">
						<button class="btn btn-default pull-right" type="submit">Send</button>
					</div>
				</div>
			</div> -->
		</div>
	</div>
</body>
</html>
<!-- Add Google Maps -->
<div id="googleMap" style="height: 400px; width: 100%;"></div>
<script>
	function myMap() {
		var myCenter = new google.maps.LatLng(41.878114, -87.629798);
		var mapProp = {
			center : myCenter,
			zoom : 12,
			scrollwheel : false,
			draggable : false,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("googleMap"),
				mapProp);
		var marker = new google.maps.Marker({
			position : myCenter
		});
		marker.setMap(map);
	}
</script>
<!-- <script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU&callback=myMap"></script>
 -->
<!--
To use this code on your website, get a free API key from Google.
Read more at: https://www.w3schools.com/graphics/google_maps_basic.asp
-->

