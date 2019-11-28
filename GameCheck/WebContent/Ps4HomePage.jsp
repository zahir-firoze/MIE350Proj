<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<body>
		<header>
			<img src="img/GameCheck-logo.png">
			<br>
		</header>
		<div class="navbar">
			<%@ include file="NavBar.jsp"%>
		</div>
		<%@ include file="Filter_Ps4_Original.jsp"%>
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
<img src="img/Ps4_Persona5.jpg" alt="Persona5" style="width:100%">
<span class="caption"><a href="/GameCheck/VideoGameController?action=display&upc=65020102">Persona 5</a></span>
</div>

<div class="img-container">
<img src="img/Ps4_TheSims4.jpg" alt="TheSims4" style="width:100%">
<span class="caption"><a href="/GameCheck/VideoGameController?action=display&upc=743888">The Sims 4</a></span>
</div>

<div class="img-container">
<img src="img/Ps4_KingdomHearts3.jpg" alt="KingdomHearts3" style="width:100%">
<span class="caption"><a href="/GameCheck/VideoGameController?action=display&upc=23033219">Kingdom Hearts 3 - Deluxe Edition</a></span>
</div>

<div class="img-container">
<img src="img/Ps4_TrailsOfColdSteel3.jpg" alt="TrailsofColdSteel3" style="width:100%">
<span class="caption"><a href="/GameCheck/VideoGameController?action=display&upc=71171922">The Legend of Heroes: Trails of Cold Steel III</a></span>
</div>

</article>
</body>

</html>