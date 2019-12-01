
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<header>
	<span> <h2>Accessory Filter</h2></span>
</header>
<div>
    <form method="POST" action='AccessoryController'>
	<table >
      <tr>
        <td><input type="hidden" name="filterForm" value="accessory"> </input> </td>
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
            <td> <h9 style="color:white";> Console Compatability: </h9></td>
              <td>
                <select name="consoleFilter" style="height:35px;">
                  <option value="console0">All Consoles</option>
                	<option value="Switch">Switch</option>
                  <option value="3DS">3DS</option>
                  <option value="Playstation 4">Playstation 4</option>
                  <option value="Xbox One">Xbox One</option>
                	<option value="PS Vita">PS Vita</option>
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