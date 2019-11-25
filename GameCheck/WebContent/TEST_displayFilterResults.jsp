<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.vgi.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GameCheck - View the Filtered Accessory Results</title>
</head>
<body>
<!--<p>
	DaddInt ==  <c:out value="${daddyInt}" />
</p>  -->

 		<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-8 text-left">
				<h1>Accessories Filter Results</h1>
				<br> <br>
				The following Filters were applied <B><c:out
						value="${accFilters}" /> </B> <br>
				<br> <br>
				There are  <B><c:out
						value="${accessories.size()}" /> search results</B> from your database query <br>
				<br>
				<table border=1 >
					<thead>
						<tr>
							<th>UPC</th>
							<th>Name</th>
							<th>ConsoleCompatability</th>
							<th>Price</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${accessories}" var="accessory">
							<tr>
								<td align="center"><c:out value="${accessory.getUPCNumber()}" /></td>
								<td align="center"><c:out value="${accessory.getName()}" /></td>
								<td align="center"><c:out value="${accessory.getConsoleCompatability()}" /></td>
								<td align="center"><c:out value="${accessory.getPrice()}" /></td>
								<td align="center"><c:out value="${accessory.getDescription()}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>



				<br /> <br />
			</div>
			</div>
			
		</div>
		
		<h1> Video Game Filter</h1>
		<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-8 text-left">
				<br> <br>
				The following Filters were applied <B><c:out
						value="${vgFilters}" /> </B> <br>
				<br>
				<h1>VideoGames Filter Results</h1>

				<br> <br>
				There are  <B><c:out
						value="${videogames.size()}" /> search results</B> from your database query <br>
				<br>
				<table border=1 >
					<thead>
						<tr>
							<th>UPC</th>
							<th>Title</th>
							<th>Developer</th>
							<th>Console</th>
							<th>Genre</th>
							<th>Release_Date</th>
							<th>Consumer_Rating</th>
							<th>ESRB_Rating</th>
							<th>Price</th>
							<th>Description</th>
							<th>Max_Players</th>
							<th>ImageFileName</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${videogames}" var="vg">
							<tr>
								<td align="center"><c:out value="${vg.getUPCNumber()}" /></td>
								<td align="center"><c:out value="${vg.getTitle()}" /></td>
								<td align="center"><c:out value="${vg.getDeveloper()}" /></td>
								<td align="center"><c:out value="${vg.getConsole()}" /></td>
								<td align="center"><c:out value="${vg.getGenre()}" /></td>
								<td align="center"><c:out value="${vg.getReleaseDate()}" /></td>
								<td align="center"><c:out value="${vg.getConsumerRating()}" /></td>
								<td align="center"><c:out value="${vg.getEsrbRating()}" /></td>
								<td align="center"><c:out value="${vg.getPrice()}" /></td>
								<td align="center"><c:out value="${vg.getDescription()}" /></td>
								<td align="center"><c:out value="${vg.getMaxPlayers()}" /></td>
								<td align="center"><c:out value="${vg.getImageFileName()}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>



				<br /> <br />
			</div>
			</div>
			
		</div>
	
</body>
</html>