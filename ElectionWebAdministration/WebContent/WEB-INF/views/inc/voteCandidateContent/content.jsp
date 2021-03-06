<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div class="col-sm-3">
	<ul class="list-group">
		<c:if test="${!empty currentVote}">
			<li class="list-group-item text-muted">${currentVote}</li>
		</c:if>
		<li class="list-group-item text-muted" contenteditable="false">Candidate</li>
		<li class="list-group-item text-right"><span class="pull-left"><strong class="">Name</strong></span> ${currentCandidate.name}</li>
		<li class="list-group-item text-right"><span class="pull-left"><strong class="">Description</strong></span> ${currentCandidate.description}</li>
		<c:if test="${not thisCandidateVoted}">
			<li class="list-group-item text-right">
				<a href='<c:url value="/castvote/${currentCandidate.id}" />'>Vote</a>
			</li>
		</c:if>
	</ul>
</div>