<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta charset="utf-8">
<title>Profile</title>
<meta name="description" content="smarthealth">

<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<style>

body
{
    font-family: 'Open Sans', sans-serif;
}

.fb-profile img.fb-image-lg{
    z-index: 0;
    width: 100%;  
    margin-bottom: 10px;
}

.fb-image-profile
{
    margin: -90px 10px 0px 50px;
    z-index: 9;
    width: 20%; 
}

@media (max-width:768px)
{
    
.fb-profile-text>h1{
    font-weight: 700;
    font-size:16px;
}

.fb-image-profile
{
    margin: -45px 10px 0px 25px;
    z-index: 9;
    width: 20%; 
}
}
*, *:before, *:after {
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}


form {
	max-width: 300px;
	margin: 10px auto;
	padding: 10px 20px;
	background: #f4f7f8;
	border-radius: 8px;
}

h1 {
	margin: 0 0 30px 0;
	text-align: center;
}

input[type="text"], input[type="password"], input[type="date"], input[type="datetime"],
	input[type="email"], input[type="number"], input[type="search"], input[type="tel"],
	input[type="time"], input[type="url"], textarea, select {
	background: rgba(255, 255, 255, 0.1);
	border: none;
	font-size: 16px;
	height: auto;
	margin: 0;
	outline: 0;
	padding: 15px;
	width: 100%;
	background-color: #e8eeef;
	color: #8a97a0;
	box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
	margin-bottom: 30px;
}

input[type="radio"], input[type="checkbox"] {
	margin: 0 4px 8px 0;
}

select {
	padding: 6px;
	height: 32px;
	border-radius: 2px;
}

button {
	padding: 19px 39px 18px 39px;
	color: #FFF;
	background-color: #4bc970;
	font-size: 18px;
	text-align: center;
	font-style: normal;
	border-radius: 5px;
	width: 100%;
	border: 1px solid #3ac162;
	border-width: 1px 1px 3px;
	box-shadow: 0 -1px 0 rgba(255, 255, 255, 0.1) inset;
	margin-bottom: 10px;
}

fieldset {
	margin-bottom: 30px;
	border: none;
}

legend {
	font-size: 1.4em;
	margin-bottom: 10px;
}

label {
	display: block;
	margin-bottom: 8px;
}

label.light {
	font-weight: 300;
	display: inline;
}

.number {
	background-color: #5fcf80;
	color: #fff;
	height: 30px;
	width: 30px;
	display: inline-block;
	font-size: 0.8em;
	margin-right: 4px;
	line-height: 30px;
	text-align: center;
	text-shadow: 0 1px 0 rgba(255, 255, 255, 0.2);
	border-radius: 100%;
}

@media screen and (min-width: 480px) {
	form {
		max-width: 480px;
	}
}</style>
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
		<div class="col-md-1" style="padding-top: 13px;"><img class="img-responsive center" src="1.jpg"></div>
	
			<a href="main.html" class="btn btn-default navbar-btn navbar-right">
					Logout <span class="glyphicon glyphicon-log-out"></span>
				</a>
		</div>
		</div>
		
	</div>

	</nav>

<div class="container">
    <div class="fb-profile">
        <img align="left" class="fb-image-lg" src="http://lorempixel.com/850/280/nightlife/5/" alt="Cover image " style="width: 100%"/>
        <img align="left" class="fb-image-profile thumbnail" src="http://lorempixel.com/180/180/people/9/" alt="Profile image "/>
        <div class="fb-profile-text" style="text-transform: uppercase;">
            <h1>
            	<%
			String name=(String)session.getAttribute("Username");
			session.setAttribute("Username",name);
			out.print("WELCOME "+name);
			%>
            
            </h1>
           
        </div>
    </div>
</div> <!-- /container --> 
<div class="container">
	
	
      <form action="UpdateServlet" method="post" name="update">
      
        <h1>YOUR PROFILE</h1>
        
        <fieldset>
          <legend>
				<span class="number">1</span>Your basic info</legend>
          <label for="name">USERNAME:</label>
          <input type="text" id="username" name="username" readonly="readonly" value=<%=session.getAttribute("username") %>>
          
          <label for="mail"> EMAIL ID:</label>
          <input type="email" id="email1" name="email1" readonly="readonly" value=<%=session.getAttribute("email1") %>>
          
            <label for="mail">ALTERNAYIVE EMAIL ID:</label>
          <input type="email" id="email2" name="email2" value=<%=session.getAttribute("email2") %> required="required">
          
          <label for="password">PASSWORD:</label>
          <input type="password" id="password" name="password" required="required" value=<%=session.getAttribute("password") %>>
          </fieldset>
          
           <fieldset>
          <legend>
				<span class="number">2</span>Your profile</legend>
           <label for="name">FIRST NAME:</label>
          <input type="text" id="firstname" name="firstname"  required="required" value=<%=session.getAttribute("firstname") %>>
          
           <label for="name">LAST NAME:</label>
          <input type="text" id="lastname" name="lastname" required="required" value=<%=session.getAttribute("lastname") %>>
          
           <label for="name">STREET NUMBER:</label>
          <input type="text" id="streetnumber" name="streetnumber" required="required" value=<%=session.getAttribute("streetnumber") %>>
          
           <label for="name">STREET NAME:</label>
          <input type="text" id="streetname" name="streetname" required="required"  value=<%=session.getAttribute("streetname") %>>
          
           <label for="name">MUNICIPALITY AREA:</label>
          <input type="text" id="municipality" name="municipality" required="required"  value=<%=session.getAttribute("municipality") %>>
          
           <label for="name">DISTRICT:</label>
          <input type="text" id="district" name="district" required="required" value=<%=session.getAttribute("district") %>>
          
           <label for="name">POSTAL ADDRESS:</label>
          <input type="text" id="postaladdress" name="postaladdress" required="required" value=<%=session.getAttribute("postaladdress") %>>
          
         <label>PICTURE 1:</label><br>
          <input type="url" id="pic1" value=<%=session.getAttribute("pic1") %> required="required"
				name="pic1"><br>
         
          
           <label>PICTURE 2:</label><br>
          <input type="url" id="pic2" value=<%=session.getAttribute("pic2") %> required="required"
				name="pic2"><br>
        
          <br>
           <label>PICTURE 3:</label><br>
           <input type="url" id="pic3" value=<%=session.getAttribute("pic3") %> required="required"
				name="pic3"><br>
				
        
          <label for="about">ABOUT YOURSELF:</label>
          <input type="text"id="aboutme" name="aboutme" required="required" value=<%=session.getAttribute("aboutme") %>>
        </fieldset>
        <fieldset>
        <label for="usertype">USERTYPE:</label>
        <select id="usertype" name="usertype" disabled="disabled"  onchange="if (this.options[this.selectedIndex].value =='moderator'){document.register['phone'].style.visibility='visible'}else {document.register['phone'].style.visibility='hidden'};">
          
            <option value="enduser" id="enduser">End USER</option>
            <option value="moderator" id="moderator">MODERATOR</option>
            
            
        </select>
         <input type="hidden" name="usertype" value=<%=session.getAttribute("usertype") %>/>
          
        
        </fieldset>
         <input type="number" id="phone"	name="phonenumber" style="visibility: hidden;" placeholder="PHONE NUMBER" required="required"/>
        <button type="submit">UPDATE</button>
      </form>

</div>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>