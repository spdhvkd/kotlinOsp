import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class TestDBConnect{
	var driver = "org.mariadb.jdbc.Driver"
	var url = "jdbc:mariadb://localhost:3306/board"
	var uId = "root"
	var uPwd = "1004"

	var con: Connection? = null
	var pstmt: PreparedStatement? = null
	var rs: ResultSet? = null

	fun TestDBConnect() {
		try {
			Class.forName(driver)
			con = DriverManager.getConnection(url, uId, uPwd)
			if (con != null) {
				println("데이터 베이스 접속 성공")
			}

		} catch (e: ClassNotFoundException) {
			println("드라이버 로드 실패")
		} catch (e: SQLException) {
			println("데이터 베이스 접속 실패")
		}
	}

	fun select() :  BoardVO {
		var vo = BoardVO()
		val sql = "SELECT * FROM BOARD"
		try {

			//Compiler 입장에서 con이 Null인지 아닌지 확인되지 않는 상태이기 때문에 오류를 출력
			pstmt = con.prepareStatement(sql)
			rs = pstmt.executeQuery()
			while (rs.next()) {
				val seq = rs.getInt("seq")
				val writer = rs.getString("writer")
				val title = rs.getString("title")
				val contents = rs.getString("contents")
				val writeDate = rs.getString("write_date")

				println(" seq  : " + seq)
				println(" writer  : " + writer)
				println(" title  : " + title)
				println(" content  : " + contents)
				println(" writeDate  : " + writeDate)

				vo.seq = seq
				vo.writer = writer
				vo.title = title
				vo.contents = contents
				vo.writeDate = writeDate

			}
		} catch (e: SQLException) {
			println("쿼리 수행 실패")
		} finally {
			con.close()
		}
		return vo
	}
}
