<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>HOME PAGE</h2>

<a href='${contextPath}/app/test.htm'>TEST</a>
<a href='#foo'>HASH</a>
<a href='#ContentActivity.ContentPlace:http://localhost:8080/memo-portal/'>ACTIVITY</a>
<a href='http://google.com/'>GOOGLE</a>

<c:if test="${not empty sessionScope.contextUser}">
	<ul>
		<li>Nickname: ${sessionScope.contextUser.nickname}</li>
		<li>Fullname: ${sessionScope.contextUser.fullname}</li>
		<li>Gender:   ${sessionScope.contextUser.gender}</li>
		<li>Postcode: ${sessionScope.contextUser.postcode}</li>
		<li>Email:    ${sessionScope.contextUser.email}</li>
		<li>Country:  ${sessionScope.contextUser.country}</li>
		<li>Language: ${sessionScope.contextUser.language}</li>
		<li>Timezone: ${sessionScope.contextUser.timezone}</li>
	</ul>
</c:if>
