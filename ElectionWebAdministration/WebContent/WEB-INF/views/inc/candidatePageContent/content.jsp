<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:if test="${not empty candidateDeleteConfirm}">
	<h3>${candidateDeleteConfirm}</h3>
</c:if>

<table class="table">
	<thead>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Detail</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="candidate" items="${allCandidates}">
			<tr>
				<td>${candidate.name}</td>
				<td>${candidate.description}</td>
				<td>
					<a href='<c:url value="/viewcandidatepage/${candidate.id}" />' >Detail</a>
				</td>
				<td>
					<a onclick="return confirm('Are you sure you want to delete this candidate?')" href='<c:url value="/candidatepage/delete/${candidate.id}" />' >Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<div class="list-group">
	<a href='<c:url value="/newcandidatepage" />' class="list-group-item active">
			<h4 class="list-group-item-heading">Create Candidates</h4>
			<p class="list-group-item-text">
				Administration page where candidate can be created.
			</p>
		</a>
</div>