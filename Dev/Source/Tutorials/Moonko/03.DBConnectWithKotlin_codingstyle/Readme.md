#### JAVA TO KOTLIN과정에서 생긴 문제
- Connection, PreparedStatement, ResultSet 같은 경우에 DB접속하는 부분과 쿼리 조회해오는 부분을 분리해서 쓰려고하니 문제가 생겼다. Class 속성값으로 이용하고 있는 위의 나열한 값들이 Null값 일 수도 있으니 사용하지 않겠다는 Compiler의 오류
    * Null인지 아닌지 따위는 신경쓰지 않는 자바에서는 생기지 않는 문제

- 어떻게 문제를 해결해야할까?
