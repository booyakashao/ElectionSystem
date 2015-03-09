<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="list-group">
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href='<c:url value="/admin" />' class="list-group-item active">
			<h4 class="list-group-item-heading">Administration Page</h4>
			<p class="list-group-item-text">Administration page for voters and other admins</p>
		</a>
		<a href='<c:url value="/candidatepage" />' class="list-group-item">
			<h4 class="list-group-item-heading">View Candidates</h4>
			<p class="list-group-item-text">
				Administration page for candidates. Here an admin can view, delete, and create candidates.
			</p>
		</a>
		<a href='<c:url value="/newcandidatepage" />' class="list-group-item">
			<h4 class="list-group-item-heading">Create Candidates</h4>
			<p class="list-group-item-text">
				Administration page where candidate can be created.
			</p>
		</a>
	</sec:authorize>
</div>