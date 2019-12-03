<%@ page language="java" contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8" import="com.vgi.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Game Page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" type="text/css" href="game-page-styleV3.css">

</head>
<body>

	<header>
		<img src="img/GameCheck-logo.png">
			<br>
	</header>
	<%@ include file="NavBar.jsp"%>
	
	  <div class="pathway">
    <span><a href="#console-compatibility"><c:out value="${Accessory.getConsoleCompatability()}" /></a></span>
    <span>></span>
    <span><a href="#Accessory-name"><c:out value="${Accessory.getName()}" /></a></span>
  </div>

  <div class="grid-container-1">
    <div class="game-company-price-div">
      <span class="game-price">$</span>
      <span><a class="game-price"><c:out value="${Accessory.getPrice()}" /></a></span>
    </div>

    <div class="rating-div">
 <form method="POST" action='CustomerRatingReviewController'>
	 	  <input type="hidden" name="action" value="confirmAddRating" >
          <input type="hidden" name="upc" value=<c:out value="${Accessory.getUPCNumber()}" /> >
    <div class="rating-div">
      <!--  <span class="rate-this-title">Rate this title!</span> -->
       <a class="rating-value"><c:out value="${averageRating}" /></a>
      <br>


      <fieldset class="rating">
        <input type="hidden" name="ratingOnly" value="accessory"> </input>
        <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="5 stars"></label>

        <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="4 stars"></label>

        <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="3 stars"></label>

        <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="2 stars"></label>

        <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="1 star"></label>
        
      </fieldset>
      <input type="submit" value="Rate this title!"> 
    </div>
    
	</form>
	</div>
	</div>
	<br>

  <div class="grid-container-2">
    <div class="game-cover-div">
      <img class="game-cover"src=<c:out value="${Accessory.getImageFileName()}"/> alt=<c:out value="${Accessory.getImageFileName()}"/>>
    </div>

    <div class="desc-store-rev-div">
      <div class="game-description">
        <h3>Description: </h3>
        <p><c:out value="${Accessory.getDescription()}" /></p>
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
      		<input type="hidden" name="upc" value=<c:out value="${Accessory.getUPCNumber()}" />> 
      		
      		<table>
      		<tr> <td> <b> Reviews (<c:out value="${totalReviews}" />): </b> </td><td><input type="submit" value="Show All Reviews"> </td></tr>
      		</table>
      		
      </form>
      <br>
      <form method="POST" action='CustomerRatingReviewController'>
      		<input type="hidden" name="action" value="confirmAddReview"> 
      		<input type="hidden" name="upc" value=<c:out value="${Accessory.getUPCNumber()}" />> 
      		<input type="submit" value="Write a review"> 
      </form>
      <br>
      
      

        
      <table>
 	  <c:forEach items="${CRRList}" var="CustomerRatingReview">
 
       		     
		      
		      <tr>
		      <td colspan="2">
		         <hr> 
		      </td>
		      </tr>
		      
		      <!-- experimental row begin -->
		      
		      <tr>
		      
		      
		      
		      <!-- td containing table of review stuff - begin -->
		      <td valign="top">
		      
		      <table>

		    
		      
		      <tr>
		      <td>
		       <span class="reviewer-star-rating">star rating: <c:out value="${CustomerRatingReview.getRating()}" /> </span>
		      </td>
		      </tr>
		      
		      <tr>
		      <td>
		      <span class="reviewer-email">Email: <c:out value="${CustomerRatingReview.getEmail()}" /></span>
		      </td>
		      </tr>
		 
		      <tr>
		      <td>
		       <p class="review-text"><c:out value="${CustomerRatingReview.getReview()}" /> </p>
		      </td>
		      </tr>
		      
		      </table>
		      
		      </td>
		      <!-- td containing table of review stuff - end -->
		      
		      <!-- td containing table of update/delete stuff - begin -->
		      <td valign="top">
		      
		      <table>
		      
		      <tr>
		      
		      <td>
		            <form method="POST" action='CustomerRatingReviewController'>
		                <input type="hidden" name="action" value="confirmUpdate"> 
		                <input type="hidden" name="servlet" value="AccessoryController">
		                <input type="hidden" name="upc" value=<c:out value="${Accessory.getUPCNumber()}" />> 
		                <input type="hidden" name="email" value=<c:out value="${CustomerRatingReview.getEmail()}" />>
		                <input type="submit" value="Update"> 
		            </form>
		      </td>
		      </tr>
		      
		      <tr>
		      <td>
		             <form method="POST" action='CustomerRatingReviewController'>
		                <input type="hidden" name="action" value="confirmDelete"> 
		                <input type="hidden" name="servlet" value="AccessoryController">
		                <input type="hidden" name="upc" value=<c:out value="${Accessory.getUPCNumber()}" />> 
		                <input type="hidden" name="email" value=<c:out value="${CustomerRatingReview.getEmail()}" />>
		                <input type="submit" value="Delete"> 
		            </form>    
		      </td>
		      
		      </tr>
		      </table>
		      
		      </td>
		      <!-- td containing table of update/delete stuff - end -->
		      
		      </tr>
		      
		      <!-- experimental row end -->      

      	  
      </c:forEach>
      </table>
    </div>
    </div>
	</div>
</body>
</html>