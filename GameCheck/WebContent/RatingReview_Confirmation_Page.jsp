<%@ page language="java" contentType="text/html"
    pageEncoding="EUC-KR" import="com.vgi.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="cfm-msg.css">
	<title>Confirmation Message</title>
</head>
<body>
	<header>
      <div class="page-title">
        <img  src="img/GameCheck-logo.png" alt="Game Check logo">
      </div>
    </header>
    <p class="message-text"><c:out value="${outputMessage}" /></p>
    <form method="POST" action=<c:out value="${servlet}"/>>
      <input type="hidden" name="filterForm" value="false">
       <input type="hidden" name="action" value="display">
      <input type="hidden" name="upc" value=<c:out value="${upc}" />>
      <button class="go-back-btn" name="go-back-btn">Go back</button>
    </form>
</body>
</html>