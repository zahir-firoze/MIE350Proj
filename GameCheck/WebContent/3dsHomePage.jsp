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
		<%@ include file="Filter_3ds_Original.jsp"%>
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
<img src="img/3ds_FederationForce.jpg" alt="FederationForce" style="width:100%"/>
 <span class="caption"><a href="/GameCheck/VideoGameController?action=display&upc=6596484">Metroid Prime: Federation Force</a></span>
</div>

<div class="img-container">
<img src="img/3ds_MarioKart7.jpg" alt="MarioKart7" style="width:100%">
<span class="caption"><a href="/GameCheck/VideoGameController?action=display&upc=6590741">Mario Kart 7</a></span>
</div>

<div class="img-container">
<img src="img/3ds_MajorasMask3D.jpg" alt="MajorasMask3D" style="width:100%">
<span class="caption"> <a href="/GameCheck/VideoGameController?action=display&upc=6593858">The Legend of Zelda: Majora's Mask 3D</a></span>
</div>

<div class="img-container">
<img src="img/3ds_KirbysEpicYarn.jpg" alt="KirbysEpicYarn" style="width:100%">
<span class="caption"> <a href="/GameCheck/VideoGameController?action=display&upc=6741747">Kirby's Epic Yarn</a></span>
</div>

<div class="img-container">
<img src="img/3ds_Awakening.jpg" alt="Awakening" style="width:100%">
<span class="caption"> <a href="/GameCheck/VideoGameController?action=display&upc=901998">Fire Emblem: Awakening</a></span>
</div>

</article>
</body>

</html>