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
            function saveBoard(){
                var formData = new FormData(document.getElementById("_frmBoard"));
                var jsonObject = {};
                formData.forEach(function(value, key){
                    jsonObject[key] = value;
                });

                $.ajax({
                    url : "/board/save",
                    data : JSON.stringify(jsonObject),
                    method : "post",
                    contentType : "application/json",
                    dataType: "json",
                    aSync : false,
                    success : function (result) {
                        var status = result.status;
                        if(status == "00"){
                            alert("정상적으로 저장되었습니다.");
                            location.href = "/";
                        }else {
                            alert("오류가 발생했습니다.");
                        }
                    },
                    error : function (e) {
                        alert(e.responseText);
                    }
                });
            }
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
                    <th>제목</th><td><input type="text" class="form-control" name="title"> </td>
                </tr>
                <tr>
                    <th>내용</th><td><input type="text" class="form-control" name="content"></td>
                </tr>
            </tbody>
        </table>
        <button class="btn btn-primary" onclick="saveBoard();" style="float:right;">저장</button>
        <button class="btn btn-primary" onclick="javascript:location.href='/'" style="float:right;">목록</button>
    </form>
</div>

</body>
</html>