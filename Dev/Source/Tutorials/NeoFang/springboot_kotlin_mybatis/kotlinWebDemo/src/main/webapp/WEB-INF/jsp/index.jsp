<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
        <title>메인화면</title>
        <link rel="stylesheet" href="/css/bootstrap.min.css" />
        <script src="/script/jquery/jquery.min.js"></script>
        <script src="/script/bootstrap/bootstrap.min.js"></script>
        <script type="text/javascript">
            function getBoard(seq){
                var frmBoard = document.getElementById("_frmBoard");
                frmBoard.action="/board/get/"+seq
                frmBoard.method="get";
                frmBoard.submit();
            }
        </script>
</head>
<body>
<div class="container">
    <form name="frmBoard" id="_frmBoard" onsubmit="return false;">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>seq</th>
                <th>제목</th>
                <th>등록일</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="list" items="${list}" varStatus="status">
                    <tr>
                        <td><c:out value="${list.seq}" /></td>
                        <td onclick="getBoard('${list.seq}')"><c:out value="${list.title}" /></td>
                        <td><c:out value="${list.ymdFrt}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
</div>

</body>
</html>