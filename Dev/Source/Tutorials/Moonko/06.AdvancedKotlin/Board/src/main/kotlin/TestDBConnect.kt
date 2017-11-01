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
			con.prepareStatement(sql).executeQuery().apply {
				while (next())
				{
					vo.run{
						seq = getInt("seq")
						writer = getString("writer")
						title = getString("title")
						contents = getString("contents")
						writeDate = getString("write_date")
					}
				}
			}
		} catch (e : SQLException) {
			println("Query failed")
		} finally {
			con.close()
		}
		return vo
	}
}
