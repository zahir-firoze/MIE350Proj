<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.vgi.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Leonard Test 1 2 3 </title>
</head>
<body>
 <h1> Your results are printed below</h1>
 <div>
 	attribute1 = <c:out value="${attribute1}" /> 
 </div>
 <br>
 <div>
 	attribute2= <c:out value="${attribute2}" /> 
 </div>
</body>
</html>