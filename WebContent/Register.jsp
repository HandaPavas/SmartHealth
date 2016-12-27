<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Registeration Page</title>
<meta name="description" content="smarthealth">
<style>
*, *:before, *:after {
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

body {
	font-family: 'Nunito', sans-serif;
	color: #384047;
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
}
</style>
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




<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign Up Form</title>
<script>
        function change() {
            var selectBox = document.getElementById("usertype");
            var selected = selectBox.options[selectBox.selectedIndex].value;
            var label = document.getElementById("phonenumber");
            var textarea = document.getElementById("phone");
            if(selected === 'moderator'){
            	label.show;
                textarea.show();
            }
            else{
            	label.hide();
                textarea.hide();
            }
        }
        </script>
<link rel="stylesheet" href="css/normalize.css">
<link href='http://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/main.css">
</head>
<body>

	<form action="RegisterServlet" method="post" name="register">

		<h1>NEW USER REGISTER HERE!!</h1>

		<fieldset>
			<legend>
				<span class="number">1</span>Your basic info
			</legend>
			<label for="name">USERNAME:</label> <input type="text" id="name"
				name="username" required="required"> <label for="mail">
				EMAIL ID:</label> <input type="email" id="email1" name="email1"
				required="required"> <label for="mail">ALTERNATIVE
				EMAIL ID:</label> <input type="email" id="email2" name="email2"
				required="required"> <label for="password">PASSWORD:</label>
			<input type="password" id="password" name="password"
				required="required">
		</fieldset>

		<fieldset>
			<legend>
				<span class="number">2</span>Your profile
			</legend>
			<label for="name">FIRST NAME:</label> <input type="text"
				id="firstname" name="firstname" required="required"> <label
				for="name">LAST NAME:</label> <input type="text" id="lastname"
				name="lastname" required="required"> <label for="name">STREET
				NUMBER:</label> <input type="text" id="streetnumber" name="streetnumber"
				required="required"> <label for="name">STREET NAME:</label>
			<input type="text" id="streetname" name="streetname"
				required="required"> <label for="name">MUNICIPALITY
				AREA:</label> <input type="text" id="municipality" name="municipality"
				required="required"> <label for="name">DISTRICT:</label> <input
				type="text" id="district" name="district" required="required">

			<label for="name">POSTAL ADDRESS:</label> <input type="text"
				id="postaladdress" name="postaladdress" required="required">

			<label>PICTURE 1:</label><br> <input type="url" id="pic1"
				value="pic1" name="pic1" required="required"><br> <label>PICTURE
				2:</label><br> <input type="url" id="pic2" value="pic2" name="pic2"
				required="required"><br> <br> <label>PICTURE
				3:</label><br> <input type="url" id="pic3" value="pic3" name="pic3"
				required="required"><br> <label for="about">ABOUT
				YOURSELF:</label>
			<textarea id="about" name="about" required="required"></textarea>
		</fieldset>
		<fieldset>
			<label for="usertype">USERTYPE:</label> <select id="usertype"
				name="usertype"
				onchange="if (this.options[this.selectedIndex].value =='moderator'){document.register['phonenumber'].style.visibility='visible'}else {document.register['phonenumber'].style.visibility='hidden'};">

				<option value="enduser" id="enduser">End USER</option>
				<option value="moderator" id="moderator">MODERATOR</option>


			</select>

		<input type="hidden" name="usertype" value=<%=session.getAttribute("usertype") %>/>
		</fieldset>
		
		<input type="text" name="phonenumber"
			style="visibility: hidden;" placeholder="PHONE NUMBER" />
		<button type="submit">REGISTER</button>
	</form>

</body>
</html>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</body>

</html>