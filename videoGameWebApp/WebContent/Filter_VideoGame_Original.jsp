
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<header>
	<span> <h2>Video Game Filter</h2></span>
</header>
<div>
    <form method="POST" action='VideoGameController'>
	<table >
      <tr>
        <td><input type="hidden" name="filterForm" value="videogame"> </input> </td>
        <td>Genre:</td>
        <td>
          <select name="genreFilter">
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
            <option value="Dance">Dance</option>
            <option value="Action">Action</option>
          </select>
        </td>
        <td>Release Year: </td>
        <td>
          <select name="yearFilter">
            <option value="year0">All Years</option>
          	<option value="2015"><2015</option>
            <option value="2016">2016</option>
            <option value="2017">2017</option>
            <option value="2018">2018</option>
          	<option value="2019">2019</option>
          </select>
        </td>
	 <td></td>
          <td>Price: </td>
          <td>
            <select name="priceFilter">
            	<option value="price0">All Price Ranges</option>
            	<option value="price1"><$20.00</option>
              <option value="price2">$20.00-$39.99</option>
              <option value="price3">$40.00-$59.99</option>
              <option value="price4">$60.00+</option>
            </select>
          </td>
          <td></td>
            <td>Console: </td>
              <td>
                <select name="consoleFilter">
                  <option value="console0">All Consoles</option>
                	<option value="Switch">Switch</option>
                  <option value="3DS">3DS</option>
                  <option value="Playstation 4">Playstation 4</option>
                  <option value="Xbox One">Xbox One</option>
                	<option value="PS Vita">PS Vita</option>
                </select>
              </td>
              <td></td>
                <td>Max Number of Players:  </td>
                  <td>
                    <select name="playerFilter">
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