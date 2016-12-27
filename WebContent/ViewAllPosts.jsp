<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<meta charset="utf-8">
<title>View Friends Request Page</title>
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

input[type="submit"] {
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
<link rel="stylesheet" href="css/normalize.css">
<link href='http://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/main.css">


</head>
<body>
<%
//List<Forum> aforums = (List<Forum>)request.getAttribute("allforums");

%>


	
	
	<form action="PostonForumServlet" method="post">

		<fieldset>


			<%//for(int i = 0;i<aforums.size();i++) 
			{
				//Forum fob = aforums.get(i);
				//String allposts=Controller.view_posts_on_forum(fob.getfurl());
				//String forumstr=fob.getftopic()+"\n"+fob.getfurl()+"\n"+fob.getfsummary()+"\n"+fob.getfcreatedby()+"\n"+allposts+"\n";
			%>
				<td>
				<input type="text" id="f_topic" name="ftopic"
					readonly="readonly" value=<%//=forumstr %>></td>
					
					
				<fieldset>
			<label for="usertype">Post:</label> <select id="usertype"
				name="usertype"
				onchange="if (this.options[this.selectedIndex].value =='post'){document.register['post'].style.visibility='visible'}else {document.register['phone'].style.visibility='hidden'};"">

				<option value="post" id="enduser">POST</option>
			
			</select>

		</fieldset>
		
		<fieldset id="post">
			
			<label for="name">Post Text:</label>
			 <input type="text" id="ptext"
				name="posttext" required="required">
				 <label for="plink">
				Picture Link:</label> <input type="text" id="pic_link" 
				name="piclink" required="required"> 
				 <label for="summary">
				Link:</label> <input type="text" id="t_link" 
				name="tlink" required="required"> 
				<label for="url">
				VideoLink:</label> <input type="text" id="vid_link" 
				name="vlink" required="required"> 
				
		</fieldset>
		
		<button type="submit">Post</button>
		
				<%} %>
			
			

		</fieldset>
	</form>



</body>
</html>