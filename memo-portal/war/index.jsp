<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 1st render --%>
<%-- browser will create the session cookie --%>
<%-- however java container does not know it yet --%>
<%-- as such jsessionid will be present in the redirect url --%>

<c:if test="${empty sessionScope.jsessionrd }">
	<c:set var="jsessionrd" value="1" scope="session" />
	<c:redirect url="/" />
</c:if>

<%-- 2nd render --%>
<%-- java container detects browser session cookie --%>
<%-- as such the redirect url will be clean --%>

<c:if test="${sessionScope.jsessionrd == 1 }">
	<c:set var="jsessionrd" value="2" scope="session" />
	<c:redirect url="/" />
</c:if>

<jsp:forward page="/app/home" />
