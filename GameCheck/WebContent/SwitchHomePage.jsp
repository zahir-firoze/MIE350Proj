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
		<%@ include file="Filter_Switch_Original.jsp"%>
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
<img src="img/Switch_ThreeHouses.jpg" alt="ThreeHouses" style="width:100%">
<span class="caption"> <a href="/GameCheck/VideoGameController?action=display&upc=4549642">Fire Emblem: Three Houses</a></span>
</div>

<div class="img-container">
<img src="img/Switch_SuperMarioOdyssey.jpg" alt="SuperMarioOdyssey" style="width:100%">
<span class="caption"> <a href="/GameCheck/VideoGameController?action=display&upc=2111224">Super Mario Odyssey</a></span>
</div>

<div class="img-container">
<img src="img/Switch_SuperSmashBrosUltimate.jpg" alt="SuperSmashBrosUltimate" style="width:100%">
<span class="caption"> <a href="/GameCheck/VideoGameController?action=display&upc=1463335">Super Smash Bros Ultimate</a></span>
</div>

<div class="img-container">
<img src="img/Switch_SuperMarioMaker2.jpg" alt="SuperMarioMaker2" style="width:100%">
<span class="caption"> <a href="/GameCheck/VideoGameController?action=display&upc=4549659">Super Mario Maker 2</a></span>
</div>

<div class="img-container">
<img src="img/Switch_BreathOfTheWild.jpg" alt="BreathOfTheWild" style="width:100%">
<span class="caption"><a href="/GameCheck/VideoGameController?action=display&upc=1463373">The Legend Of Zelda: Breath Of The Wild</a></span>
</div>

<div class="img-container">
<img src="img/Switch_LinksAwakening.jpg" alt="LinksAwakening" style="width:100%">
<span class="caption"><a href="/GameCheck/VideoGameController?action=display&upc=454965">The Legend of Zelda: Link's Awakening</a></span>
</div>

</article>
</body>


</html>