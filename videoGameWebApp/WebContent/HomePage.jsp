<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<a href="#allProducts">All Games</a>
				<a href="#newreleases">New Releases</a>
  			<a href="#3ds">3DS</a>
  			<a href="#switch">Switch</a>
  			<a href="#ps4">PS4</a>
				<a href="#psvita">PS Vita</a>
  			<a href="#xbox">XBox</a>
				<a href="#accessory">Accessories</a>
		</div>

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
                    	<option value="Any">Any</option>
                    	<option value="num1">1</option>
                      <option value="num2">2</option>
                      <option value="num3">4</option>
                      <option value="num4">>4</option>
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
<img src="3ds_FederationForce.jpg" alt="FederationForce" style="width:100%">
 <span class="caption">Metroid Prime: Federation Force</span>
</div>

<div class="img-container">
<img src="3ds_MarioKart7.jpg" alt="MarioKart7" style="width:100%">
<span class="caption">Mario Kart 7</span>
</div>

<div class="img-container">
<img src="3ds_MajorasMask3D.jpg" alt="MajorasMask3D" style="width:100%">
<span class="caption">The Legend of Zelda: Majora's Mask 3D</span>
</div>

<div class="img-container">
<img src="3ds_KirbysEpicYarn.jpg" alt="KirbysEpicYarn" style="width:100%">
<span class="caption">Kirby's Epic Yarn</span>
</div>

<div class="img-container">
<img src="3ds_Awakening.jpg" alt="Awakening" style="width:100%">
<span class="caption">Fire Emblem: Awakening</span>
</div>
</article>

<article>
<header>
	<span> <h2 class="page-name">SWITCH GAMES</h2></span>
	<span> <h3 class="page-link"><a href="#switch">[See All] </a> </h3></span>
</header>

<div class="img-container">
<img src="Switch_ThreeHouses.jpg" alt="ThreeHouses" style="width:100%">
<span class="caption">Fire Emblem: Three Houses</span>
</div>

<div class="img-container">
<img src="Switch_SuperMarioOdyssey.jpg" alt="SuperMarioOdyssey" style="width:100%">
<span class="caption">Super Mario Odyssey</span>
</div>

<div class="img-container">
<img src="Switch_SuperSmashBrosUltimate.jpg" alt="SuperSmashBrosUltimate" style="width:100%">
<span class="caption">Super Smash Bros Ultimate</span>
</div>

<div class="img-container">
<img src="Switch_SuperMarioMaker2.jpg" alt="SuperMarioMaker2" style="width:100%">
<span class="caption">Super Mario Maker 2</span>
</div>

<div class="img-container">
<img src="Switch_BreathOfTheWild.jpg" alt="BreathOfTheWild" style="width:100%">
<span class="caption">The Legend Of Zelda: Breath Of The Wild</span>
</div>

<div class="img-container">
<img src="Switch_LinksAwakening.jpg" alt="LinksAwakening" style="width:100%">
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
<img src="Ps4_Persona5.jpg" alt="Persona5" style="width:100%">
<span class="caption">Persona 5</span>
</div>

<div class="img-container">
<img src="Ps4_Persona5.jpg" alt="Persona5" style="width:100%">
<span class="caption">Fire Emblem: Three Houses</span>
</div>

<div class="img-container">
<img src="Ps4_TheSims4.jpg" alt="TheSims4" style="width:100%">
<span class="caption">The Sims 4</span>
</div>

<div class="img-container">
<img src="Ps4_KingdomHearts3.jpg" alt="KingdomHearts3" style="width:100%">
<span class="caption">Kingdom Hearts 3 - Deluxe Edition</span>
</div>

<div class="img-container">
<img src="Ps4_TrailsOfColdSteel3.jpg" alt="TrailsofColdSteel3" style="width:100%">
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
<img src="Psvita_MostWanted.jpg" alt="MostWanted" style="width:100%">
<span class="caption">Need for Speed: Most Wanted</span>
</div>

<div class="img-container">
<img src="Psvita_MetalGearSolid.jpg" alt="MetalGearSolid" style="width:100%">
<span class="caption">Metal Gear Solid HD Collection</span>
</div>

<div class="img-container">
<img src="Psvita_Persona4Golden.jpg" alt="Persona4Golden" style="width:100%">
<span class="caption">Persona 4 Golden</span>
</div>

<div class="img-container">
<img src="Psvita_BlackOpsDeclassified.jpg" alt="BlackOpsDeclassified" style="width:100%">
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
<img src="Xbox_Nba2k20.jpg" alt="Nba2k20" style="width:100%">
<span class="caption">NBA 2K20</span>
</div>

</article>

<article>
<br>
<header>
	<span> <h2 class="page-name">ACCESSORIES</h2></span>
	<span> <h3 class="page-link"><a href="#accessory">[See All] </a> </h3></span>
</header>

<div class="img-container">
<img src="Accessory_Xbox.jpg" alt="axbox" style="width:100%">
<span class="caption">Xbox One Controller - Sport White</span>
</div>

<div class="img-container">
<img src="Accessory_Psvita.jpg" alt="apsvita" style="width:100%">
<span class="caption">Sony Memory Card for PlayStation Vita - 4GB</span>
</div>

<div class="img-container">
<img src="Accessory_3ds.jpg" alt="a3ds" style="width:100%">
<span class="caption">Super Smash Bros Shulk amiibo</span>
</div>

<div class="img-container">
<img src="Accessory_Ps4.jpg" alt="aps4" style="width:100%">
<span class="caption">PS4 Controller: Dualshock Wireless Controller - Magma Red</span>
</div>

<div class="img-container">
<img src="Accessory_Switch.jpg" alt="aswitch" style="width:100%">
<span class="caption">Nintendo Switch Joy-Con Controllers - Left and Right - Neon Orange and Purple</span>
</div>

</article>
</body>
</html>
