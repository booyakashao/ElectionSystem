<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:if test="${not empty voterDeleteConfirm}">
	<h3>${voterDeleteConfirm}</h3>
</c:if>

<table class="table">
	<thead>
		<tr>
			<th>Username</th>
			<th>Role</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="voter" items="${allVoters}">
			<tr>
				<td>${voter.username}</td>
				<td>${voter.role.roleName}</td>
				<td>
					<a onclick="return confirm('Are you sure you want to delete this voter?')" href='<c:url value="/delete/${voter.id}" />' >Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>