<%--
	Created by IntelliJ IDEA.
	User: CZ-shmun-N1
	Date: 2017-10-26
	Time: 오전 9:17
	To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>JSP 호출 테스트</title>
	</head>
	<body>
		여기는 JSP페이지 입니다
		<%= request.getAttribute("obj")%>
	</body>
</html>
