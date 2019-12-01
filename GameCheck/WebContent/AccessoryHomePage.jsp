<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>GameCheck: Accessories</title>
</head>
<body>
		<header>
			<img src="img/GameCheck-logo.png">
			<br>
		</header>
		<div class="navbar">
			<%@ include file="NavBar.jsp"%>
		</div>
		<%@ include file="Filter_Accessory_Original.jsp"%>
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
<img src="img/Accessory_Xbox.jpg" alt="axbox" style="width:100%">
<span class="caption" > <a href="/GameCheck/AccessoryController?action=display&upc=69655419">Xbox One Controller - Sport White </a></span>
</div>

<div class="img-container">
<img src="img/Accessory_Psvita.jpg" alt="apsvita" style="width:100%">
<span class="caption"> <a href="/GameCheck/AccessoryController?action=display&upc=711719220">Sony Memory Card for PlayStation Vita - 4GB </a></span>
</div>

<div class="img-container">
<img src="img/Accessory_3ds.jpg" alt="a3ds" style="width:100%">
<span class="caption">  <a href="/GameCheck/AccessoryController?action=display&upc=4549689">Super Smash Bros Shulk amiibo </a></span>
</div>

<div class="img-container">
<img src="img/Accessory_Ps4.jpg" alt="aps4" style="width:100%">
<span class="caption"> <a href="/GameCheck/AccessoryController?action=display&upc=271171950">PS4 Controller: Dualshock Wireless Controller - Magma Red </a></span>
</div>

<div class="img-container">
<img src="img/Accessory_Switch.jpg" alt="aswitch" style="width:100%">
<span class="caption"> <a href="/GameCheck/AccessoryController?action=display&upc=11310281">Nintendo Switch Joy-Con Controllers - Left and Right - Neon Orange and Purple </a></span>
</div>

</article>
</body>
</html>