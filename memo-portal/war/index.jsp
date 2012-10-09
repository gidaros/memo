<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty sessionScope.jsessionrd }">
	<c:set var="jsessionrd" value="1" scope="session" />
	<c:redirect url="/" />
</c:if>

<%-- after 1st redirect --%>
<%-- browser will create the session cookie --%>
<%-- however java container does not know it yet --%>
<%-- as such jsessionid will be present in the generated url --%>

<c:if test="${sessionScope.jsessionrd == 1 }">
	<c:set var="jsessionrd" value="2" scope="session" />
	<c:redirect url="/" />
</c:if>

<%-- 2nd redirect --%>
<%-- java container detects browser session cookie --%>
<%-- as such the generated url is clean --%>

<jsp:forward page="/app/home.htm" />
