<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="formAction" value="/createaccount" />
<form:form id="details" method="post" action="${formAction}" commandName="voter">
	<div class="form-group">
		<label for="inputUserName">Username:</label>
		<form:input class="control" path="username" name="username" type="text" />
	</div>
	<div class="form-group">
		<label for="inputPassword">Password</label>
		<form:input class="control" path="password" name="password" type="password" />
	</div>
	<div class="form-group">
		<label for="inputRole">Role:</label>
		<form:select class="control" path="role" name="role">
			<form:option value="ROLE_VOTER">Voter</form:option>
			<form:option value="ROLE_ADMIN">Administrator</form:option>
		</form:select>
	</div>
	<div class="form-group">
		<form:button class="control" type="submit">Register</form:button>
	</div>
</form:form>