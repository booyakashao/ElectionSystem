<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<table class="table">
	<thead>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Vote</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="candidate" items="${allCandidates}">
			<tr>
				<td>${candidate.name}</td>
				<td>${candidate.description}</td>
				<td>
					<a href='<c:url value="/votecandidate/${candidate.id}" />' >Vote</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>