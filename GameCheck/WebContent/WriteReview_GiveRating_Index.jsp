<%@ page language="java" contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8" import="com.vgi.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="write-review.css">
	<title><c:out value="${operation}"/></title>
</head>
<body>
  <header>
      <div class="page-title">
        <img  src="img/GameCheck-logo.png" alt="Game Check logo">
      </div>
    </header>
    <p class="instructions-text ">Review for <c:out value="${product}" /></p>
      <form method="POST" action='CustomerRatingReviewController' id='reviewForm'>
      		<input type="hidden" name="action" value=<c:out value="${action}" /> >
          <input type="hidden" name="email" value=<c:out value="${email}" /> >
          <input type="hidden" name="upc" value=<c:out value="${upc}" />>
    <div class="rating-div">
      <fieldset class="rating">
        <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="5 stars"></label>

        <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="4 stars"></label>

        <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="3 stars"></label>

        <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="2 stars"></label>

        <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="1 star"></label>
      </fieldset>
    </div>
      <div class="email-grid-container">
        <div class="email-header">
          Email:
        </div>
        <span><c:out value="${email}" /></span>
      </div>

      <br>
      <div class="review-grid-container">
        <div class="review-header">
          Review:
        </div>

        <br>
        <textarea id="review-textbox" rows="20" cols="50" name="review-textbox" form="reviewForm"> <c:out value="${reviewContent}" />
        </textarea>
      </div>
      <br>
      <input type="submit" value=<c:out value="${submitLabel}" />>
    </form>
</body>
</html>