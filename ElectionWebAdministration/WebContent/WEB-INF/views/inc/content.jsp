<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<a href = ""><img id = "img1" src ='<c:url value="/static/images/bike_image.JPG" />' /></a>


<div id="b_Search">


<div id="b_header">
<h3>Shop by Ride</h3>
</div>

<br><br><br>
<form action="#">
<select name="year">
<option value="">Year</option>
<option value="2014">2014</option>
<option value="2013">2013</option>
<option value="2012">2012</option>
<option value="2011">2011</option>
<option value="2010">2010</option>
</select>
<br><br>

<select name="make">
<option value="">Make</option>
<option value="Yamaha">Yamaha</option>
<option value="EBR">EBR</option>
<option value="BMW">BMW</option>
<option value="Ducati">Ducati</option>
<option value="Suzuki">Suzuki</option>
<option value="Honda">Honda</option>
<option value="Kawasaki">Kawasaki</option>
</select>
<br><br>

<select name="model">
<option value="">Model</option>
<option value="CBR1000RR">CBR1000RR</option>
<option value="S1000RR">S1000RR</option>
<option value="ZX10R">ZX10R</option>
</select>
<br><br>

<input type="submit" value="Go">

</form>
</div>


<div class="lineContainer">
<hr class = line1>
</div>



<div id="productLayer">
<h3>Featured Items</h3>
<br>

<ul>

<li>
<div class="productImg"><a href="#"><img src="images/j2.png"></img></a></div>
<div class="ProductInfo">
<a href="#">Product 1</a>
<p>product description here</p>
</div>
<div class="price"><span>Our Price: </span><strong>$100</strong></div>
<div class="actions">

<a id="p_cart" href="#">Add to Cart</a>
<a id="p_view" href="#">View</a>

</div>
</li>

<li>
<div class="productImg"><a href="#"><img src="images/h2.png"></img></a></div>
<div class="ProductInfo">
<a href="#">Product 1</a>
<p>product description here</p>
</div>
<div class="price"><span>Our Price: </span><strong>$100</strong></div>
<div class="actions">
<a id="p_cart" href="#">Add to Cart</a>
<a id="p_view" href="#">View</a>
</div>
</li>

<li>
<div class="productImg"><a href="#"><img src="images/b2.png"></img></a></div>
<div class="ProductInfo">
<a href="#">Product 1</a>
<p>product description here</p>
</div>
<div class="price"><span>Our Price: </span><strong>$100</strong></div>
<div class="actions">
<a id="p_cart" href="#">Add to Cart</a>
<a id="p_view" href="#">View</a>
</div>
</li>

<li>
<div class="productImg"><a href="#"><img src="images/p2.png"></img></a></div>
<div class="ProductInfo">
<a href="#">Product 1</a>
<p>product description here</p>
</div>
<div class="price"><span>Our Price: </span><strong>$100</strong></div>
<div class="actions">
<a id="p_cart" href="#">Add to Cart</a>
<a id="p_view" href="#">View</a>
</div>
</li>



</ul>
</div>


<div class="lineContainer">
<hr class = line1>
</div>

<div id=videoLayer>
<h3>Product Reviews</h3>
<ul>

<li><iframe width="295" height="155" src="//www.youtube.com/embed/1t24XAntNCY"></iframe></li>
<li><iframe width="295" height="155" src="//www.youtube.com/embed/uBSrP7ub6VA"></iframe></li>
<li><iframe width="295" height="155" src="//www.youtube.com/embed/Dd7FixvoKBw"></iframe></li>
<!--  <li><video controls> <source src="#"><source src="#"><source src="#"> </video></li> -->
<!--  <li><video controls> <source src="#"><source src="#"><source src="#"> </video></li> -->
<!--  <li><video controls> <source src="#"><source src="#"><source src="#"> </video></li> -->

</ul>
</div>

<div class="lineContainer">
<hr class = line1>
</div>


<div id=brandLayer align="center">
<h3 align="left"><a href="">Brands</a></h3>
<br>
<a href=""><img src="">Icon</a>
<a href=""><img src="">Alpinestars</a>
<a href=""><img src="">Moto-D</a>
<a href=""><img src="">TechSpec</a>
<a href=""><img src="">Shoei</a>
<a href=""><img src="">Dunlop</a>
<a href=""><img src="">Michelin</a>
<a href=""><img src="">K&N</a>

</div>