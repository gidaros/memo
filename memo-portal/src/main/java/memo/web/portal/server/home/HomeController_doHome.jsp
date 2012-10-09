<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="./">Test</a>

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
