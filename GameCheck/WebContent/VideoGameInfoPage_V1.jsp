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
	
	  <div class="pathway">
    <span><a href="#console-type"><c:out value="${VideoGame.getConsole()}" /></a></span>
    <span>></span>
    <span><a href="#game-name"><c:out value="${VideoGame.getTitle()}" /></a></span>
  </div>

  <div class="grid-container-1">
    <div class="game-name-div">
      <a class="game-name" href="#game-name"><c:out value="${VideoGame.getTitle()}" /></a>
    </div>
    <div class="game-company-price-div">
      <span><a class="game-company-name" href="#game-company-name"><c:out value="${VideoGame.getDeveloper()}" /></a></span>

      <br>
      <span class="game-price">$</span>
      <span><a class="game-price" href="game-price"><c:out value="${Product.getPrice()}" /></a></span>
    </div>

    <div class="rating-div">
      <span class="rate-this-title">Rate this title!</span>
      <a class="rating-value" href="#rating-value"><c:out value="${VideoGame.getConsumerRating()}" /></a>
      <br>

      <!-- QUES: how to dynamically update rating? -->
      <fieldset class="rating">
        <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>

        <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>

        <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>

        <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>

        <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>
      </fieldset>
    </div>

    <div class="esrb-rating-div">
      <img class="esrb-rating" src="#esrb-rating.png" alt= "${VideoGame.getEsrbRating()}">
    </div>

    <div class="right-div">
      <div class="genre">
        <span>Genre:  </span>
        <a class="genre" href="#genre"><c:out value="${VideoGame.getGenre()}" /></a>
      </div>

      <div class="developer">
        <span>Developer: </span>
        <a class="developer" href="#developer"><c:out value="${VideoGame.getDeveloper()}" /></a>
      </div>


      <div class="release-date">
        <span>Release Date: </span>
        <a class="release date" href="#release-date"><c:out value="${VideoGame.getReleaseDate()}" /></a>
      </div>

      <div class="number-of-players">
        <span># of Players: </span>
        <a class="number-of-players" href="#number-of-players"><c:out value="${VideoGame.getMaxPlayers()}" /></a>
      </div>
    </div>
  </div>
  
    <hr>

  <div class="grid-container-2">
    <div class="game-cover-div">
      <img src= <c:out value="${VideoGame.getImageFileName()}"/>>
    </div>

    <div class="desc-store-rev-div">
      <div class="game-description">
        <h3>Description: </h3>
        <p style="color:white"><c:out value="${VideoGame.getDescription()}" /></p>
      </div>

      <div class="store-availability">
        <h3>Store Availability: </h3>
        <!-- for each store, retrieve store name, address and display in <span> tag -->
        <c:forEach items="${storeList}" var="store">
        <span><c:out value="${store.getName()}" />, <c:out value="${store.getAddress()}" /></span>
        </c:forEach>

      </div>

      <div class="review">
        <h3>Reviews <c:out value="${CRRList.size()}" />: </h3>
        <button class="show-all-reviews"name="review-show-all">
          <span>[show all]</span>
        </button>
        <button class="write-a-review" name="write-a-review">
          <span>Write a review</span>
        </button>
        <!-- for each review, retrieve reviewer name and comment (and if there are other info that needs to be displayed), and display in <span> tag -->
        <span><c:out value="${CustomerRatingReview.getEmail()}" />, <c:out value="${CustomerRatingReview.getReview()}" /> </span>

      </div>


    </div>

  </div>
	
</body>
</html>