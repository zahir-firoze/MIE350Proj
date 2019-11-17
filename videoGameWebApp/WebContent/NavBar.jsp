<header>
	<h1 class="page-title">GameCheck</h1>
</header>

<div class="navbar">
    <a href="#home">All Products</a>
    <a href="#home">All 3Ds</a>
    <a href="#home">Switch</a>
    <a href="#home">PS4</a>
    <a href="#home">Xbox</a>
    <a href="#home">PS Vita</a>
    <a href="#contact">Accessories</a>
  </div>

  <br> 
/*This part sets dynamic drop down, 
<select name="Accessories">
    <option value="price1">$0-$4.99</option>
    <option value="price2">$5-$9.99</option>
    <option value="price3">$10-$14.99</option>
    <option value="price4">$15-19.99</option>
    <option value="price5">$20-$24.99</option>
    <option value="price6">$25-$29.99</option>
    ...
</select>

<form action="list" method="post">
    Select a Category:&nbsp;
    <select name="Accessories">
        <c:forEach items="${accFilters}" var="price">
            <option value="${Accessories.name}">${Accessories.price}</option>
        </c:forEach>
    </select>
    <br/><br/>
    <input type="submit" value="Submit" />
</form>

	</body>
</html>