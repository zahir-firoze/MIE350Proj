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
	
</body>
</html>