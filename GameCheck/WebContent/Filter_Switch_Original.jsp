<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<header>
	<span> <h2>Switch Games Filter</h2></span>
</header>
<div>
    <form method="POST" action='VideoGameController'>
	
	<table>
      <tr>
        <td><input type="hidden" name="filterForm" value="videogame"> </input> </td>
        <!-- this hidden field indicates that the filter request is coming from switch games page-->
         <td><input type="hidden" name="presetConsole" value="true"> </input> </td>
        <td> <h9 style="color:white";> Genre: </h9></td>
        <td>
          <select name="genreFilter" style="height:35px;">
            <option value="genre0">All Games</option>
            <option value="Adventure">Adventure</option>
            <option value="Racing">Racing</option>
            <option value="Platformer">Platformer</option>
            <option value="RPG">RPG</option>
            <option value="Racing">Racing</option>
            <option value="FPS">FPS</option>
            <option value="Simulation">Simulation</option>
            <option value="Sports">Sports</option>
            <option value="Stealth">Stealth</option>
            <option value="Horror">Horror</option>
            <option value="Action">Action</option>
          </select>
        </td>
        <td><h9 style="color:white";>Release Year: </h9></td>
        <td>
          <select name="yearFilter" style="height:35px;">
            <option value="year0">All Years</option>
          	<option value="2015"><2015</option>
            <option value="2016">2016</option>
            <option value="2017">2017</option>
            <option value="2018">2018</option>
          	<option value="2019">2019</option>
          </select>
        </td>
	 <td></td>
          <td> <h9 style="color:white";> Price: </h9> </td>
          <td>
            <select name="priceFilter" style="height:35px;">
            	<option value="price0">All Price Ranges</option>
            	<option value="price1"><$20.00</option>
              <option value="price2">$20.00-$39.99</option>
              <option value="price3">$40.00-$59.99</option>
              <option value="price4">$60.00+</option>
            </select>
          </td>
          <td></td>
            <td> <h9 style="color:white";> Console: </h9></td>
              <td>
                <select name="consoleFilter" style="height:35px;">
                	<option value="Switch">Switch</option>
                </select>
              </td>
              <td></td>
                <td><h9 style="color:white";>Max Number of Players: </h9> </td>
                  <td>
                    <select name="playerFilter" style="height:35px;">
                    	<option value="player0">Any</option>
                    	<option value="1">1</option>
                      <option value="2">2</option>
                      <option value="4">4</option>
                      <option value="moreThan4">>4</option>
                    </select>
                  </td>
                    <td></td>
                      <td>
                        
                        <input type="submit" value="Apply Filter">
                      </td>
      </tr>
    </table>
    </form>
</div>


</body>
</html>