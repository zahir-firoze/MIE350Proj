<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.vgi.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>GameCheck: PS Vita Games</title>
<body>
		<header>
			<img src="img/GameCheck-logo.png">
			<br>
		</header>
		<div class="navbar">
			<%@ include file="NavBar.jsp"%>
		</div>
		<%@ include file="Filter_Psvita_Original.jsp"%>
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
<img src="img/Psvita_MostWanted.jpg" alt="MostWanted" style="width:100%">
<span class="caption"><a href="/GameCheck/VideoGameController?action=display&upc=742805">Need for Speed: Most Wanted</a></span>
</div>

<div class="img-container">
<img src="img/Psvita_MetalGearSolid.jpg" alt="MetalGearSolid" style="width:100%">
<span class="caption"><a href="/GameCheck/VideoGameController?action=display&upc=7202394">Metal Gear Solid HD Collection</a></span>
</div>

<div class="img-container">
<img src="img/Psvita_Persona4Golden.jpg" alt="Persona4Golden" style="width:100%">
<span class="caption"><a href="/GameCheck/VideoGameController?action=display&upc=65200009">Persona 4 Golden</a></span>
</div>

<div class="img-container">
<img src="img/Psvita_BlackOpsDeclassified.jpg" alt="BlackOpsDeclassified" style="width:100%">
<span class="caption"><a href="/GameCheck/VideoGameController?action=display&upc=48915050">Call of Duty: Black Ops: Declassified</a></span>
</div>
</article>
<br>
<article>
</div>
<div>
  <span> <h2>About <c:out value="${Console.getName()}" /> </h2></span>
  <span > <p style="color:white";>Console information can be found <a href=<c:out value="${Console.getInformationURL()}"/>>here</a> </p></span>
  <span> <p style="color:white";>Purchase Console at <a href=<c:out value="${Console.getPurchaseURL()}" />>this website </a> </p></span>
</div>
</article>
</body>

</html>