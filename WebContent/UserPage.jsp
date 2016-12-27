<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta charset="utf-8">
<title>User Page</title>
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

<style type="text/css">
.bs-example {
	margin: 20px;
}
</style>
</head>

<body>

	<nav class="navbar navbar-inverse" id="my-navbar">

	<div class="container">


		<div class="row">
			<div class="col-md-1" style="padding-top: 13px;">
				<img class="img-responsive center" src="1.jpg">
			</div>

			<div class="col-md-4">
				<form action="SearchServlet" method="POST" class="form-inline">
					<div class="form-group">
						<input type="text" class="form-control" name="searchper"
							placeholder="Search...">
					</div>

					<button type="submit" class="btn btn-default navbar-btn">
						<span class="glyphicon glyphicon-search"></span> Search
					</button>
				</form>

			</div>


			<div class="col-md-1"></div>
			<div class="col-md-3"
				style="color: gray; padding-top: 8px; text-transform: uppercase;">
				<strong> <%
 	String name = (String) session.getAttribute("Username");
 	//gets the username logged in
 	session.setAttribute("Username", name);
 	out.print("WELCOME " + name);
 %> <span style="color: gray; font-size: 25px;"> |</span>
				</strong>
			</div>
			<div class="col-md-1">
				<span class="glyphicon glyphicon-user"
					style="color: white; font-size: 30px; padding-top: 10px;"></span></a>

			</div>
			<div class="col-md-2">

				<a href="LogoutServlet"
					class="btn btn-default navbar-btn navbar-right"> Logout <span
					class="glyphicon glyphicon-log-out"></span>
				</a>

			</div>
		</div>
	</div>

	</nav>

	<div class="jumbotron" style="background-image:"smarthealth.jpg"; ">
		<div class="container text-center">
			<h1>SMART HEALTH</h1>
		</div>
	</div>



	<div class="bs-example">
		<ul class="nav nav-tabs">

			<li><a href="ViewForumsServlet"><span
					class="glyphicon glyphicon-eye-open"></span><strong> View
						Forum</strong></a></li>


			<li class="active"><a data-toggle="tab" href="#health"><span
					class="glyphicon glyphicon-grain"></span><strong> Health</strong></a></li>
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="#"><strong>Health Data </strong><b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="FriendforHealthServlet"><span
							class="glyphicon glyphicon-eye-open"></span><strong>
								VIEW</strong></a></li>
					<li><a href="HealthData.jsp"><span
							class="glyphicon glyphicon-plus"></span><strong> ADD</strong></a></li>

				</ul></li>

			<!-- li><a href="HealthData.jsp"><span
					class="glyphicon glyphicon-user"></span><strong> Health Data</strong></a></li-->

			<li><a href="ProfileServlet"><span
					class="glyphicon glyphicon-user"></span><strong> Profile</strong></a></li>

			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="#"><strong>Friends </strong><b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="ViewFriendServlet"><span
							class="glyphicon glyphicon-eye-open"></span><strong> ALL
								FRIENDS</strong></a></li>
					<li><a href="FriendRequestsServlet"><span
							class="glyphicon glyphicon-plus"></span><strong> FRIEND
								REQUESTS</strong></a></li>
				</ul></li>

			<li><a data-toggle="modal" href="#deleteaccount"><span
					class="glyphicon glyphicon-trash"></span><strong> DELETE</strong></a></li>


		</ul>
		<div class="tab-content">
			<div id="health" class="tab-pane fade in active">
				<h3>HEALTH</h3>
				<p>Aliquip placeat salvia cillum iphone. Seitan aliquip quis
					cardigan american apparel, butcher voluptate nisi qui. Raw denim
					you probably haven't heard of them jean shorts Austin. Nesciunt
					tofu stumptown aliqua, retro synth master cleanse. Mustache cliche
					tempor, williamsburg carles vegan helvetica. Reprehenderit butcher
					retro keffiyeh dreamcatcher synth.</p>
			</div>

			<!-- Modal HTML -->
			<div id="deleteaccount" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">Confirmation</h4>
						</div>
						<div class="modal-body">
							<p>ARE YOU SURE! YOU WANT TO DELETE YOUR ACCOUNT ?</p>
							<p class="text-warning">
								<small>If you click 'yes' your account will be deleted.</small>
							</p>
						</div>
						<div class="modal-footer">
							<a href="DeleteServlet">YES</a>
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">NO</button>
						</div>
					</div>
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