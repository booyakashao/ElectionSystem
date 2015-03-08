<jsp:directive.page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title><tiles:insertAttribute name="title"/></title>
<tiles:insertAttribute name="header"></tiles:insertAttribute>

</head>
<body>
	<tiles:insertAttribute name="navBar"/>

	<div id="container">

		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	
	</div>

	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</body>
</html>