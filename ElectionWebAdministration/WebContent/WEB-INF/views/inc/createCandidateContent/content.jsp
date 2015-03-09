<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="formAction" value="/createcandidate" />

<form:form method="post" action="${formAction}" commandName="candidate">
	<div class="form-group">
		<label for="inputName">Name:</label>
		<form:input class="control" path="name" name="name" type="text" />
	</div>
	<div class="form-group">
		<label for="inputDescription">Description:</label><br/>
		<form:textarea rows="4" cols="50" class="control" path="description" name="description" type="text" />
	</div>
	<div class="form-group">
		<form:button class="control" type="submit">Create Candidate</form:button>
	</div>
</form:form>