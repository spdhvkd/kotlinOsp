import java.sql.Connection;
import java.sql.DriverManager
import java.sql.SQLException;

class TestDBConnect {
	var driver = "org.mariadb.jdbc.Driver"
	var url = "jdbc:mariadb://localhost:3306/board"
	var uId = "id"
	var uPwd = "pwd"

	fun getConnection() : Connection{
		Class.forName(driver)
		val con : Connection = DriverManager.getConnection(url, uId, uPwd)
		println("DB Connect")
		return con
	}

	fun select(con :Connection) : BoardVO {

		var sql = "SELECT * FROM BOARD"
		var vo = BoardVO()

		try {
			val pstmt = con.prepareStatement(sql)
			val rs = pstmt.executeQuery()
			while (rs.next()) {
				val seq = rs.getInt("seq")
				val writer = rs.getString("writer")
				val title = rs.getString("title")
				val contents = rs.getString("contents")
				val writeDate = rs.getString("write_date")
				vo.seq = seq
				vo.writer = writer
				vo.title = title
				vo.contents = contents
				vo.writeDate = writeDate
			}
		} catch (e : SQLException) {
			println("Query failed")
		} finally {
			con.close()
		}
		return vo
	}
}
