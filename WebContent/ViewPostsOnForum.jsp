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

h1, h2 {
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
		List<String[]> posts = (List<String[]>) request.getAttribute("allposts");
		String foru_url = (String) request.getAttribute("forumurl");
		System.out.println(foru_url);
	%>


	<h1>VIEW POSTS ON</h1>
	<fieldset>
		<form>
			<input type="text" id="ffurl" name="fffurl" readonly="readonly"
				value=<%=foru_url%> />
		</form>
		<hr>
		<%
			for (int i = 0; i < posts.size(); i++) {
				String[] onepost = posts.get(i);

				String poststr = onepost[0] + "\n" + onepost[1] + "\n" + onepost[2] + "\n";
				String ptime = onepost[1];
				System.out.println(ptime);
		%>
		<h2><%=i + 1%>.
		</h2>
		
			
			
			<form action="ViewPostDetailsServlet" method="post">
			
			<textarea name="postdis" rows="3" cols="1"><%=poststr%></textarea>

			<button type="submit">View Post Details</button>
			
			<input type="text" id="postname" name="postname"
				style="visibility: hidden;" value=<%=onepost[0]%> />
			<textarea style="visibility: hidden;" name="posttime" rows="1"
				cols="1"><%=ptime%></textarea>
			
		</form>


	
		<h2>COMMENT ON POST !!!</h2>
		
		<form action="CommentOnPostServlet" method="post">

			

			<label for="name">Comment Text:</label> <input type="text" id="ctext"
				name="commenttext" required="required">
				 <label for="plink">Picture
				Link:</label>
				 <input type="text" id="pic_link" name="cpiclink"
				required="required">
				 <label for="summary"> Link:</label> <input
				type="text" id="t_link" name="ctlink" required="required">
				 <label
				for="url"> VideoLink:</label> <input type="text" id="vid_link"
				name="cvlink" required="required">

			<button type="submit">Comment</button>
			
			<input type="text" id="postname" name="postname"
				style="visibility: hidden;" value=<%=onepost[0]%> />
			<textarea style="visibility: hidden;" name="posttime" rows="1"
				cols="1"><%=ptime%></textarea>


		</form>
		<h2>RATE THE POST !!!</h2>
		<form action="RateOnPostServlet" method="post">



			<label for="name">Rating:</label> <input type="text" id="rating"
				name="rating" required="required">

			<button type="submit">Rate Post</button>
			<input type="text" id="postname" name="postname"
				style="visibility: hidden;" value=<%=onepost[0]%> />
			<textarea style="visibility: hidden;" name="posttime" rows="1"
				cols="1"><%=ptime%></textarea>

		</form>
		<hr>



		<%
			}
		%>
	</fieldset>




</body>
</html>