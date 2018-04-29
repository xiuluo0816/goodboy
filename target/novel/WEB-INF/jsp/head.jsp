<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="CTX" value="${pageContext.request.contextPath}" scope="request" />
<c:set var="RES" value="http://res.1862.cn" scope="request" />
<head>
	<title>${title}</title>
	<base href="${CTX}/">
	<link rel="stylesheet" href="${RES}/lib/bootstrap/3.3.4/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${CTX}/scripts/theme/normal/css/syspart_menu.css" />
	<link rel="stylesheet" href="${CTX}/scripts/theme/normal/css/treeStyle.css" />
	<link rel="stylesheet" href="${RES}/lib/artDialog/6.0.5/css/ui-dialog.css" />
  	<script data-main="${CTX}/${mainJs}" src="${RES}/require.js"></script> 
	<script type="text/javascript">
		var _changePlt = function (_platformId) {
			this.location.href = "${CTX}/home?platformId=" + _platformId;
		};
	</script>
</head>