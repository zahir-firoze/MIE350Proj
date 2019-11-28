<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GameCheck: Switch Games</title>
<body>
		<header>
			<img src="img/GameCheck-logo.png">
			<br>
		</header>
		<div class="navbar">
			<%@ include file="NavBar.jsp"%>
		</div>
		<%@ include file="Filter_Xbox_Original.jsp"%>
<style>* {
	box-sizing: border-box;
}

.clearfix::after {
	content: "";
	clear: both;
	display: table;
}

</style>
<article>
<br>
<head>
  <link rel="stylesheet" href="style.css">
</head>

<div class="img-container">
<img src="img/Xbox_Nba2k20.jpg" alt="Nba2k20" style="width:100%">
<span class="caption"><a href="/GameCheck/VideoGameController?action=display&upc=7104255">NBA 2K20</a></span>
</div>

</article>
</body>

</html>