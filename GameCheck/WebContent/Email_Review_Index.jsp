<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.vgi.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" type="text/css" href="eml-review-style.css">
<title>Confirm Email to <c:out value="${operationForReview}" /> Review</title>
</head>
<body>
    <header>
      <div class="page-title">
        <img  src="img/GameCheck-logo.png" alt="Game Check logo">
      </div>
    </header>
    <p class="instructions-text">Enter your email address to <c:out value="${operationForReview}" />  your review: </p>
  <form method="POST" action='CustomerRatingReviewController'>
    <input type="hidden" name="action" value=<c:out value="${action}" />>
    <input type="hidden" name="product" value=<c:out value="${product}" />>
    <input type="hidden" name="servlet" value=<c:out value="${servlet}" />>
    <input type="hidden" name="upc" value=<c:out value="${upcNumber}" />>
    <input type="hidden" name="originalEmail" value=<c:out value="${originalEmail}" />>
    Email:
    <input type="text" name="Email" placeholder="e.g. gamer.checked@gmail.com">
    <br>
    <input type="submit" value=<c:out value="${operationForReview}" /> >
  </form>

    </div>
</body>
</html>