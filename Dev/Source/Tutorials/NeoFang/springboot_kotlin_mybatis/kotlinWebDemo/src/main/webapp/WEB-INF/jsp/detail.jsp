<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
        <title>상세</title>
        <link rel="stylesheet" href="/css/bootstrap.min.css" />
        <script src="/script/jquery/jquery.min.js"></script>
        <script src="/script/bootstrap/bootstrap.min.js"></script>
        <script type="text/javascript">

        </script>
</head>
<body>
<div class="container">
    <form name="frmBoard" id="_frmBoard" onsubmit="return false;">
        <table class="table table-striped">
            <colgroup>
                <col width="30%" />
                <col width="*" />
            </colgroup>

            <tbody>
                <tr>
                    <th>seq</th><td><c:out value="${board.seq}" /></td>
                </tr>
                <tr>
                    <th>제목</th><td><c:out value="${board.title}" /></td>
                </tr>
                <tr>
                    <th>등록일</th><td><c:out value="${board.ymdFrt}" /></td>
                </tr>
                <tr>
                    <th>내용</th><td><c:out value="${board.content}" /></td>
                </tr>
            </tbody>
        </table>
    </form>
</div>

</body>
</html>