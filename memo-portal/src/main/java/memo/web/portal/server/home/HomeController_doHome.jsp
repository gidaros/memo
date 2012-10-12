<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>HOME PAGE</h2>

<a href='${contextPath}/app/test.htm'>TEST PAGE</a>
<a href='#foo'>PLAIN HASH</a>
<a href='#ContentActivity.ContentPlace:http://localhost:8080/memo-portal/'>GWT ACTIVITY</a>
<a href='http://google.com/'>GOOGLE.COM</a>

<c:if test="${not empty contextUser}">
	<ul>
		<li>Nickname: ${contextUser.nickname}</li>
		<li>Fullname: ${contextUser.fullname}</li>
		<li>Gender:   ${contextUser.gender}</li>
		<li>Postcode: ${contextUser.postcode}</li>
		<li>Email:    ${contextUser.email}</li>
		<li>Country:  ${contextUser.country}</li>
		<li>Language: ${contextUser.language}</li>
		<li>Timezone: ${contextUser.timezone}</li>
	</ul>
</c:if>
