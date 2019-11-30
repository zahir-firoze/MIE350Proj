<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.vgi.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GameCheck: Xbox Games</title>
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