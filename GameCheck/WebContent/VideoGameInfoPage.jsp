<%@ page language="java" contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8" import="com.vgi.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
<head>
	

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

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
<!-- <p>DOM's CONTENT: 詠春</p>  -->
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
      <span><a class="game-price"><c:out value="${VideoGame.getPrice()}" /></a></span>
    </div>
	 <form method="POST" action='CustomerRatingReviewController'>
	 	  <input type="hidden" name="action" value="confirmAddRating" >
          <input type="hidden" name="upc" value=<c:out value="${VideoGame.getUPCNumber()}" /> >
    <div class="rating-div">
      <!--  <span class="rate-this-title">Rate this title!</span> -->
      <a class="rating-value"><c:out value="${averageRating}" /></a>
      <br>


      <fieldset class="rating">
        <input type="hidden" name="ratingOnly" value="videogame"> </input>
        <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="5 stars"></label>

        <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="4 stars"></label>

        <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="3 stars"></label>

        <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="2 stars"></label>

        <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="1 star"></label>
        
      </fieldset>
      <input type="submit" value="Rate this title!"> 
    </div>
    
	</form>
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
	<c:forEach items="${inventoryList}" var="inv">
        <!-- for each store, retrieve store name, address and display in <span> tag -->
        	<span> <c:out value="${inv.getStore().getName()}" />, Address : <c:out value="${inv.getStore().getAddress()}" />, Quantity: <c:out value="${inv.getQuantity()}" /></span>
	        <br>
	 </c:forEach>
      </div>
      
		<br>
      <div class="reviews">
      
      <!-- <h3>Reviews (<c:out value="${totalReviews}" />): </h3> -->
       <form method="POST" action='CustomerRatingReviewController'>
      		<input type="hidden" name="action" value="viewAllReviews"> 
      		<input type="hidden" name="upc" value=<c:out value="${VideoGame.getUPCNumber()}" />> 
      		
      		<table>
      		<tr> <td> <b> Reviews (<c:out value="${totalReviews}" />): </b> </td><td><input type="submit" value="Show All Reviews"> </td></tr>
      		</table>
      		
      </form>
      <br>
      <form method="POST" action='CustomerRatingReviewController'>
      		<input type="hidden" name="action" value="confirmAddReview"> 
      		<input type="hidden" name="upc" value=<c:out value="${VideoGame.getUPCNumber()}" />> 
      		<input type="submit" value="Write a review"> 
      </form>
      <br>
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