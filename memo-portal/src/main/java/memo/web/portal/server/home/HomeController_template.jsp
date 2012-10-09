<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="jwr" uri="http://jawr.net/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tls" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<fmt:setBundle basename="memo.web.portal.messages" scope="session" />
	<head>
		<title>
			<fmt:message key="title" />
		</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="text/css" rel="stylesheet" href="resources/reset.css" />
		<link type="text/css" rel="stylesheet" href="resources/style1.css" title="Style 1" />
		<link type="text/css" rel="alternate stylesheet" href="resources/style2.css" title="Style 2" />
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
		<script type="text/javascript" src="app/app.nocache.js"></script>

		<jwr:script  src="/bundles/messages.js" />

		<c:if test="${not empty sessionScope.contextUser}">
			<script type="text/javascript">
				var User = {
					nickname: "${sessionScope.contextUser.nickname}"
				};
			</script>
		</c:if>

	</head>
	<body>
		<div class="headerZone">
			<div class="gridRow container_12">
				<div class="gridCol grid_9">
					<ul id="menu">
						<li id="menu-forum"><a href="#">Συζητήσεις</a></li>
						<li id="menu-users"><a href="#">Μέλη</a></li>
					</ul>
				</div>
				<div class="gridCol grid_3">
					<form id="search" action="">
						<input id="searchField" type="text" name="search" value="αναζήτηση" />
					</form>
				</div>
				<div class="clear"></div>
			</div>
		</div>

		<div class="contentZone">
			<div class="gridRow container_12">
				<div class="gridCol grid_12">
					<div id="content" class="content">
						<div id="contentPanel">
							<!-- content-bgn -->
							<tls:insertAttribute name="content" />
							<!-- content-end -->
						</div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>

		<div class="footerZone">
			<div class="gridRow container_12">
				<div class="gridCol grid_12">
					<div>&copy; memo.gr &nbsp;&nbsp;|&nbsp;&nbsp; Επικοινωνία</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>

		<iframe src="javascript:''" id="__gwt_historyFrame" style="display: none;"></iframe>
	</body>
</html>
