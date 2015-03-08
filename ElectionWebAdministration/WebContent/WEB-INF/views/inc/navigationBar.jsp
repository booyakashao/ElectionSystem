<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="jumbotron">
	<div class="container">

		<div class="media">
			<div class="media-left">
				<a href='<c:url value="/" />'> <img
					class="media-object" src="" alt=""> Logo
				</a>
			</div>
		</div>

		<h3>(000) 000-0000</h3>

		<div class="topbuttons">
			<!-- Single button -->

			<div class="btn-group">
				
				<sec:authorize access="!isAuthenticated()">
					<a href='<c:url value="/login" />'>Login</a>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<a href='<c:url value="/j_spring_security_logout" />'>Logout</a>
				</sec:authorize>
				
				<button class="btn btn-default dropdown-toggle" type="button"
					data-toggle="dropdown">Drop Down Simulator</button>
				<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="#">HTML</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="#">CSS</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="#">JavaScript</a></li>
					<li role="presentation" class="divider"></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="#">About Us</a></li>
				</ul>

			</div>

			<div class="btn-group">
				<button class="btn btn-default dropdown-toggle" type="button"
					data-toggle="dropdown">Cart</button>
				<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="#">HTML</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="#">CSS</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="#">JavaScript</a></li>
					<li role="presentation" class="divider"></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="#">About Us</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<div class="container-fluid">

	<nav class="navbar navbar-default">

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="container">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Helmets</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<c:url value="" />/product/helmets">All Helmets</a></li>
						<li class="divider"></li>
						<li><a href="#">Full Face Helmets</a></li>
						<li><a href="#">Modular Helmets</a></li>
						<li><a href="#">Open Face Helmets</a></li>
						<li><a href='<c:url value="/product/cheek pads" />'>Cheek Pads</a></li>
						<li><a href='<c:url value="/product/face shields"/>'>Face Shields</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Riding
						Gear</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<c:url value="" />/product/base layers">Base Layers</a></li>
						<li><a href="<c:url value="" />/product/body armor">Body Armor</a></li>
						<li><a href="<c:url value="" />/product/boots">Boots</a></li>
						<li><a href="<c:url value="" />/product/eyewear">Eyewear</a></li>
						<li><a href="<c:url value="" />/product/gloves">Gloves</a></li>
						<li><a href="<c:url value="" />/product/headwear">Headwear</a></li>
						<li><a href="<c:url value="" />/product/helmets">Helmets</a></li>
						<li><a href="<c:url value="" />/product/jackets">Jackets</a></li>
						<li><a href="<c:url value="" />/product/pants">Pants</a></li>
						<li><a href="<c:url value="" />/product/race suits">Race Suits</a></li>
						<li><a href="<c:url value="" />/product/rain gear">Rain Gear</a></li>
						<li><a href="<c:url value="" />/product/socks">Socks</a></li>
						<li><a href="<c:url value="" />/product/vests">Vests</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Parts</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href='<c:url value="/product/batteries" />'>Batteries</a></li>
						<li><a href='<c:url value="/product/bike protection" />'>Bike Protection</a></li>
						<li><a href='<c:url value="/product/body" />'>Body</a></li>
						<li><a href='<c:url value="/product/brakes" />'>Brakes</a></li>
<!-- Double Check -->	<li><a href='<c:url value="/product/caps bolts" />'>Caps and Bolts</a></li>
						<li><a href='<c:url value="/product/chains sprockets" />'>Chains/Sprockets</a></li>
						<li><a href='<c:url value="/product/electrical" />'>Electrical</a></li>
						<li><a href='<c:url value="/product/exhausts" />'>Exhausts</a></li>
						<li><a href='<c:url value="/product/filters" />'>Filters</a></li>
						<li><a href='<c:url value="/product/foot controls" />'>Foot Controls</a></li>
						<li><a href='<c:url value="/product/hand controls" />'>Hand Controls</a></li>
						<li><a href='<c:url value="/product/lights" />'>Lights</a></li>
						<li><a href='<c:url value="/product/seats" />'>Seats</a></li>
						<li><a href='<c:url value="/product/suspension" />'>Suspension</a></li>
						<li><a href='<c:url value="/product/wheels" />'>Wheels</a></li>
						<li><a href='<c:url value="/product/windscreens" />'>Windscreens</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Tires</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href='<c:url value="/product/crusier tires" />'>Crusier Tires</a></li>
						<li><a href='<c:url value="/product/offroad tires" />'>Offroad Tires</a></li>
						<li><a href='<c:url value="/product/scooter tires" />'>Scooter Tires</a></li>
						<li><a href='<c:url value="/product/sportbike tires" />'>Sportbike Tires</a></li>
						<li><a href='<c:url value="/product/touring adv tires" />'>Touring/ADV Tires</a></li>
						<li><a href='<c:url value="/product/tire accessories" />'>Tire Accessories</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Accessories</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href='<c:url value="/product/backpacks" />'>Backpacks</a>
						<li><a href='<c:url value="/product/battery charges" />'>Battery Chargers</a></li>
						<li><a href='<c:url value="/product/bike covers" />'>Bike Covers</a></li>
						<li><a href='<c:url value="/product/cameras" />'>Cameras</a></li>
						<li><a href='<c:url value="/product/cleaning supplies" />'>Cleaning Supplies</a></li>
						<li><a href='<c:url value="/product/communication" />'>Communication</a></li>
						<li><a href='<c:url value="/product/electrical accessories" />'>Electrical Accessories</a></li>
						<li><a href='<c:url value="/product/gps phone mounts" />'>GPS/Phone Mounts</a></li>
						<li><a href='<c:url value="/product/luggage saddlebags" />'>Luggage/Saddlebags</a></li>
						<li><a href='<c:url value="/product/navigation" />'>Navigation</a></li>
						<li><a href='<c:url value="/product/oils chemicals" />'>Oils/Chemicals</a></li>
						<li><a href='<c:url value="/product/security" />'>Security</a></li>
						<li><a href='<c:url value="/product/stands" />'>Stands</a></li>
						<li><a href='<c:url value="/product/tools" />'>Tools</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Closeouts</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">All Closeout Items</a></li>
						<li class="divider"></li>
						<li><a href="#">Body Armor</a></li>
						<li><a href="#">Boots</a></li>
						<li><a href="#">Gloves</a></li>
						<li><a href="#">Helmets</a></li>
						<li><a href="#">Jackets</a></li>
						<li><a href="#">Pants</a></li>
						<li><a href="#">Race Suits</a></li>
					</ul></li>
			</ul>



			<form class="navbar-form navbar-right" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>

		</div>
	</nav>
</div>