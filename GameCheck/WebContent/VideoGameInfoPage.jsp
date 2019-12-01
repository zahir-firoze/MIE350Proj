<%@ page language="java" contentType="text/html" import="com.vgi.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en" dir="ltr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Game Page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" type="text/css" href="game-page-styleV3.css">
	<!-- <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>  -->

</head>
<body>

	<header>
		<img src="img/GameCheck-logo.png">
			<br>
	</header>
	<%@ include file="NavBar.jsp"%>
	
	   <div class="pathway">
    <span><a href="/GameCheck/ConsoleController?action=display&name="<c:out value="${VideoGame.getConsole()}" />><c:out value="${VideoGame.getConsole()}" /></a></span>
    <span>></span>
    <span><c:out value="${VideoGame.getTitle()}" /></span>
  </div>

  <div class="grid-container-1">
    <div class="game-name-div">
      <a class="game-name"><c:out value="${VideoGame.getTitle()}" /></a>
    </div>
    <div class="game-company-price-div">
      <span><a class="game-company-name"><c:out value="${VideoGame.getDeveloper()}" /></a></span>

      <br>
      <span class="game-price">$</span>
      <span><a class="game-price"><c:out value="${Product.getPrice()}" /></a></span>
    </div>

    <div class="rating-div">
      <span class="rate-this-title">Rate this title!</span>
      <a class="rating-value"><c:out value="${VideoGame.getConsumerRating()}" /></a>
      <br>


      <fieldset class="rating">
        <input type="hidden" name="ratingOnly" value="videogame"> </input>
        <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="5 stars"></label>

        <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="4 stars"></label>

        <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="3 stars"></label>

        <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="2 stars"></label>

        <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="1 star"></label>
      </fieldset>
    </div>

    <div class="esrb-rating-div">
      <img class="esrb-rating" src=<c:out value="${VideoGame.getEsrbRating()}" />".png" alt=<c:out value="${VideoGame.getEsrbRating()}" />>
    </div>

    <div class="right-div">
      <div class="genre">
        <span>Genre:  </span>
        <a class="genre"><c:out value="${VideoGame.getGenre()}" /></a>
      </div>

      <div class="developer">
        <span>Developer: </span>
        <a class="developer"><c:out value="${VideoGame.getDeveloper()}" /></a>
      </div>


      <div class="release-date">
        <span>Release Date: </span>
        <a class="release date"><c:out value="${VideoGame.getReleaseDate()}" /></a>
      </div>

      <div class="number-of-players">
        <span># of Players: </span>
        <a class="number-of-players"><c:out value="${VideoGame.getMaxPlayers()}" /></a>
      </div>
    </div>
  </div>

  <hr>

  <div class="grid-container-2">
    <div class="game-cover-div">
      <img class="game-cover"src=<c:out value="${VideoGame.getImageFileName()}"/> alt=<c:out value="${VideoGame.getImageFileName()}"/>>
    </div>

    <div class="desc-store-rev-div">
      <div class="game-description">
        <h3>Description: </h3>
        <p><c:out value="${VideoGame.getDescription()}" /></p>
      </div>

      <div class="store-availability">
        <h3>Store Availability: </h3>
        <!-- for each store, retrieve store name, address and display in <span> tag -->
        <span>#jsx retrieve store i name, #jsx retrieve store i address</span>

      </div>

      <div class="reviews">
      <h3>Reviews (<c:out value="${CRRList.size()}" />): </h3>
      <button class="show-all-reviews"name="review-show-all">
        <span>[show all]</span>
      </button>
      <button class="write-a-review" name="write-a-review">
        <span>Write a review</span>
      </button>
 	  <c:forEach items="${CRRList}" var="CustomerRatingReview">
		      <div class="review-instance">
		        <div class="review-instance">
		          <!-- TODO: 1-5 star rating images -->
		          <div class="review-header">
		            <span class="reviewer-star-rating">star rating: <c:out value="${CustomerRatingReview.getRating()}" /> </span>
		            <span class="reviewer-email">Email: <c:out value="${CustomerRatingReview.getEmail()}" /></span>
		          </div>
				 <p class="review-text"><c:out value="${CustomerRatingReview.getReview()}" /> </p>
		          <div class="review-buttons">
					<form method="POST" action='CustomerRatingReviewController'>
		                <input type="hidden" name="action" value="confirmUpdate"> 
		                <input type="hidden" name="servlet" value="VideoGameController">
		                <!--  <input type="hidden" name="product" value=<c:out value="${VideoGame.getTitle()}" />  > -->
		                <input type="hidden" name="upc" value=<c:out value="${VideoGame.getUPCNumber()}" />> 
		                <input type="hidden" name="email" value=<c:out value="${CustomerRatingReview.getEmail()}" />>
		                <input type="submit" value="Update"> 
		            </form>
		              <!-- confirm that the review can be deleted by the user -->
		            <form method="POST" action='CustomerRatingReviewController'>
		                <input type="hidden" name="action" value="confirmDelete"> 
		                <input type="hidden" name="servlet" value="VideoGameController">
		                <input type="hidden" name="upc" value=<c:out value="${VideoGame.getUPCNumber()}" />> 
		                <input type="hidden" name="email" value=<c:out value="${CustomerRatingReview.getEmail()}" />>
		                <input type="submit" value="Delete"> 
		            </form>
		          </div>
		
		
		          
		          <br>
		        </div>
		      </div>
      </c:forEach>
    </div>


    </div>

  </div>

</body>
</html>