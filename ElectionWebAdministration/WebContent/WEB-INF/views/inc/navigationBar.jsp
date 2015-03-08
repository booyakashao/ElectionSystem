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

		<div class="topbuttons">
			<!-- Single button -->

			<div class="btn-group">
			
				<sec:authorize access="!isAuthenticated()">
					<form class="" action='<c:url value="/login" />' method="GET">
						<button class="btn btn-default dropdown-toggle" type="submit">Login</button>
					</form>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<form class="" action='<c:url value="/j_spring_security_logout" />' method="GET">
						<button class="btn btn-default dropdown-toggle" type="submit">Logout</button>
					</form>
				</sec:authorize>
				
				
			</div>
		</div>
	</div>
</div>

<!-- 
<div class="container-fluid">

	<nav class="navbar navbar-default">


		<div class="container">

			<form class="navbar-form navbar-right" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>

		</div>
	</nav>
</div>

-->