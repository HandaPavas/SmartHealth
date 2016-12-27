<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta charset="utf-8">
<title>Moderator Page</title>
<meta name="description" content="smarthealth">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
</head>

<body>

	<nav class="navbar navbar-inverse" id="my-navbar">

	<div class="container">


		<div class="row">
			<div class="col-md-1"></div>

			<div class="col-md-4">
				

			</div>


			<div class="col-md-5"></div>
			<div class="col-md-2">
			<a href="LogoutServlet"
					class="btn btn-default navbar-btn navbar-right"> Logout <span
					class="glyphicon glyphicon-log-out"></span>
				</a>
			</div>
		</div>
	</div>

	</nav>

	<div class="jumbotron">
		<div class="container text-center">
			<h1>SMART HEALTH</h1>


		</div>
	</div>




	<div class="container">
		<div class="row">
			<div class="well">
				
				<div class="col-md-3">
					<a href="CreateForum.jsp">Create Forum</a>
				</div>
				
				<div class="col-md-3">
					<a href="ViewForumModServlet">View All Forums</a>
				</div>
				<div class="col-md-3">
					<li><a href="ProfilemoderatorServlet"><span
					class="glyphicon glyphicon-user"></span><strong> Profile</strong></a></li>
				</div>
				<div class="col-md-3">
					<a href="DeleteServlet">Delete Account</a>
				</div>
			</div>
		</div>
	</div>



	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>