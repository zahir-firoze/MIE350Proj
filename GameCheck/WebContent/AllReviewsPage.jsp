<%@ page language="java" contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8" import="com.vgi.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Review Page for <c:out value="${product}" /></title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" type="text/css" href="game-page-styleV3.css">
	
</head>
<body>
	<h3> Review Page for <c:out value="${product}" /></h3>
     <div class="reviews">
      <form method="POST" action='CustomerRatingReviewController'>
      		<input type="hidden" name="action" value="confirmAddReview"> 
      		<input type="hidden" name="upc" value=<c:out value="${upc}" />> 
      		<input type="submit" value="Write a review"> 
      </form>
      <table>
	 	  <c:forEach items="${reviewList}" var="CustomerRatingReview">
	 	  <tr>
	 	  			<td>
				      <div class="review-instance">
				        <div class="review-instance">
				          <!-- TODO: 1-5 star rating images -->
				          <div class="review-header">
				            <span class="reviewer-star-rating">star rating: <c:out value="${CustomerRatingReview.getRating()}" /> </span>
				            <span class="reviewer-email">Email: <c:out value="${CustomerRatingReview.getEmail()}" /></span>
				          </div>
						 <p class="review-text"><c:out value="${CustomerRatingReview.getReview()}" /> </p>
					 
					 </td>
					 <td>
			          <div class="review-buttons">
						<form method="POST" action='CustomerRatingReviewController'>
			                <input type="hidden" name="action" value="confirmUpdate"> 
			                <input type="hidden" name="servlet" value=<c:out value="${servlet}" /> >
			                <!--  <input type="hidden" name="product" value=<c:out value="${VideoGame.getTitle()}" />  > -->
			                <input type="hidden" name="upc" value=<c:out value="${upc}" />> 
			                <input type="hidden" name="email" value=<c:out value="${CustomerRatingReview.getEmail()}" />>
			                <input type="submit" value="Update"> 
			            </form>
			           </td>
			           <td>
			              <!-- confirm that the review can be deleted by the user -->
			            <form method="POST" action='CustomerRatingReviewController'>
			                <input type="hidden" name="action" value="confirmDelete"> 
			                <input type="hidden" name="servlet" value=<c:out value="${servlet}" /> >
			                <input type="hidden" name="upc" value=<c:out value="${upc}" />> 
			                <input type="hidden" name="email" value=<c:out value="${CustomerRatingReview.getEmail()}" />>
			                <input type="submit" value="Delete"> 
			            </form>
			            </td>
			          </div>
			
			
			          
			          <br>
			        </div>
			      </div>
			      
			      </tr>
	      </c:forEach>
	      
      </table>
    </div>
</body>
</html>