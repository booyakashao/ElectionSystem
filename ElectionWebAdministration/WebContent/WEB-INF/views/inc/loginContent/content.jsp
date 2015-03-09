<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h3>Login</h3>

<c:if test="${param.error != null}">
	<p class="error">
		Login failed. Check that your username and password are correct. 
	</p>
	<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
</c:if>

<form class="form-signin" name="f" method="post" action='<c:url value="/j_spring_security_check" />'>
	<h2 class="form-signin-heading">Please sign in</h2>
	
	<label for="inputUsername" class="sr-only">Username</label>
		<input type="text" name="j_username" placeholder="Username" required autofocus />
	<label for="inputPassword" class="sr-only">Password</label>
		<input type="password" name='j_password' placeholder="Password" required />
	<div class="checkbox">
    	<label>
   			<input type="checkbox" name='_spring_security_remember_me' /> Remember me
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <a href='<c:url value="/registeruser" />'>Register</a>
</form>