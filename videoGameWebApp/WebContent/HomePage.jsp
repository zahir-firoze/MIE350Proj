<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header>
			<h1 class="page-title">GameCheck</h1>
</header>

		<div class="navbar">
			<%@ include file="NavBar.jsp"%>
			<!-- 	<a href="#allProducts">All Video Games</a>
				<a href="#newreleases">New Releases</a>
  			<a href="#3ds">3DS</a>
  			<a href="#switch">Switch</a>
  			<a href="#ps4">PS4</a>
				<a href="#psvita">PS Vita</a>
  			<a href="#xbox">XBox</a>
				<a href="AccessoryHomePage.jsp">Accessories</a>
				 -->
		</div>
<article>
<br>
<head>
  <link rel="stylesheet" href="test.css">
</head>
<div>
	<header>
	<span> <h2 class="VideoGameFilter">VIDEO GAME FILTER</h2></span>
	</header>
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
</article>
<style>* {
	box-sizing: border-box;
}

.clearfix::after {
	content: "";
	clear: both;
	display: table;
}

</style>

<article>
<br>
<head>
  <link rel="stylesheet" href="test.css">
</head>

<header>
	<span> <h2 class="page-name">3DS GAMES</h2></span>
	<span> <h3 class="page-link"><a href="#3Ds">[See All] </a> </h3></span>
</header>

<div class="img-container">
<img src="img/3ds_FederationForce.jpg" alt="FederationForce" style="width:100%">
 <span class="caption">Metroid Prime: Federation Force</span>
</div>

<div class="img-container">
<img src="img/3ds_MarioKart7.jpg" alt="MarioKart7" style="width:100%">
<span class="caption">Mario Kart 7</span>
</div>

<div class="img-container">
<img src="img/3ds_MajorasMask3D.jpg" alt="MajorasMask3D" style="width:100%">
<span class="caption">The Legend of Zelda: Majora's Mask 3D</span>
</div>

<div class="img-container">
<img src="img/3ds_KirbysEpicYarn.jpg" alt="KirbysEpicYarn" style="width:100%">
<span class="caption">Kirby's Epic Yarn</span>
</div>

<div class="img-container">
<img src="img/3ds_Awakening.jpg" alt="Awakening" style="width:100%">
<span class="caption">Fire Emblem: Awakening</span>
</div>
</article>

<article>
<header>
	<span> <h2 class="page-name">SWITCH GAMES</h2></span>
	<span> <h3 class="page-link"><a href="#switch">[See All] </a> </h3></span>
</header>

<div class="img-container">
<img src="img/Switch_ThreeHouses.jpg" alt="ThreeHouses" style="width:100%">
<span class="caption">Fire Emblem: Three Houses</span>
</div>

<div class="img-container">
<img src="img/Switch_SuperMarioOdyssey.jpg" alt="SuperMarioOdyssey" style="width:100%">
<span class="caption">Super Mario Odyssey</span>
</div>

<div class="img-container">
<img src="img/Switch_SuperSmashBrosUltimate.jpg" alt="SuperSmashBrosUltimate" style="width:100%">
<span class="caption">Super Smash Bros Ultimate</span>
</div>

<div class="img-container">
<img src="img/Switch_SuperMarioMaker2.jpg" alt="SuperMarioMaker2" style="width:100%">
<span class="caption">Super Mario Maker 2</span>
</div>

<div class="img-container">
<img src="img/Switch_BreathOfTheWild.jpg" alt="BreathOfTheWild" style="width:100%">
<span class="caption">The Legend Of Zelda: Breath Of The Wild</span>
</div>

<div class="img-container">
<img src="img/Switch_LinksAwakening.jpg" alt="LinksAwakening" style="width:100%">
<span class="caption">The Legend of Zelda: Link's Awakening</span>
</div>

</article>

<article>
<br>
<header>
	<span> <h2 class="page-name">PS4 GAMES</h2></span>
	<span> <h3 class="page-link"><a href="#ps4">[See All] </a> </h3></span>
</header>

<div class="img-container">
<img src="img/Ps4_Persona5.jpg" alt="Persona5" style="width:100%">
<span class="caption">Persona 5</span>
</div>

<div class="img-container">
<img src="img/Ps4_Persona5.jpg" alt="Persona5" style="width:100%">
<span class="caption">Fire Emblem: Three Houses</span>
</div>

<div class="img-container">
<img src="img/Ps4_TheSims4.jpg" alt="TheSims4" style="width:100%">
<span class="caption">The Sims 4</span>
</div>

<div class="img-container">
<img src="img/Ps4_KingdomHearts3.jpg" alt="KingdomHearts3" style="width:100%">
<span class="caption">Kingdom Hearts 3 - Deluxe Edition</span>
</div>

<div class="img-container">
<img src="img/Ps4_TrailsOfColdSteel3.jpg" alt="TrailsofColdSteel3" style="width:100%">
<span class="caption">The Legend of Heroes: Trails of Cold Steel III</span>
</div>

</article>

<article>
<br>
<header>
	<span> <h2 class="page-name">PS VITA GAMES</h2></span>
	<span> <h3 class="page-link"><a href="#psvita">[See All] </a> </h3></span>
</header>

<div class="img-container">
<img src="img/Psvita_MostWanted.jpg" alt="MostWanted" style="width:100%">
<span class="caption">Need for Speed: Most Wanted</span>
</div>

<div class="img-container">
<img src="img/Psvita_MetalGearSolid.jpg" alt="MetalGearSolid" style="width:100%">
<span class="caption">Metal Gear Solid HD Collection</span>
</div>

<div class="img-container">
<img src="img/Psvita_Persona4Golden.jpg" alt="Persona4Golden" style="width:100%">
<span class="caption">Persona 4 Golden</span>
</div>

<div class="img-container">
<img src="img/Psvita_BlackOpsDeclassified.jpg" alt="BlackOpsDeclassified" style="width:100%">
<span class="caption">Call of Duty: Black Ops: Declassified</span>
</div>

</article>

<article>
<br>
<header>
	<span> <h2 class="page-name">XBOX GAMES</h2></span>
	<span> <h3 class="page-link"><a href="#xbox">[See All] </a> </h3></span>
</header>

<div class="img-container">
<img src="img/Xbox_Nba2k20.jpg" alt="Nba2k20" style="width:100%">
<span class="caption">NBA 2K20</span>
</div>

</article>

</body>
</html>
