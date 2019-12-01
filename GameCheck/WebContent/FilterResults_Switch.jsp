<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.vgi.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Video Games</title>

<link rel="stylesheet" type="text/css" href="style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<header>
				<img src="img/GameCheck-logo.png">
				<br>
	</header>
	<%@ include file="NavBar.jsp"%>
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
		<head>
  			<link rel="stylesheet" href="style.css">
		</head>
		
		<h2 style="color:white";> <c:out value="${videogames.size()}" /> Results for <c:out value="${userQuery}" /></h2>
		<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-8 text-left">
				
				<article>
					<head>
					  <link rel="stylesheet" href="style.css">
					</head>
					
				
						<c:forEach items="${videogames}" var="vg">
						<div class="img-container">
							<img src=<c:out value="${vg.getImageFileName()}" /> alt=<c:out value="${vg.getImageFileName()}" /> style="width:100%">
							<span class="caption"> <a href="/GameCheck/VideoGameController?action=display&upc=<c:out value="${vg.getUPCNumber()}" />"><c:out value="${vg.getTitle()}" /> </a></span>
						</div>
						</c:forEach>

				</article>

				<br /> <br />
			</div>
			</div>
			
		</div>

</body>
</html>

	

