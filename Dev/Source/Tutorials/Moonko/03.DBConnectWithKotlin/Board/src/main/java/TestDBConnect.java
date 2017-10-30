
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDBConnect {

	String driver		= "org.mariadb.jdbc.Driver";
	String url		   = "jdbc:mariadb://localhost:3306/board";
	String uId		   = "id";
	String uPwd		  = "pwd";

	Connection			   con;
	PreparedStatement		pstmt;
	ResultSet				rs;

	public TestDBConnect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uId, uPwd);

			if( con != null ){ System.out.println("데이터 베이스 접속 성공"); }

		} catch (ClassNotFoundException e) { System.out.println("드라이버 로드 실패");	}
		catch (SQLException e) { System.out.println("데이터 베이스 접속 실패"); }
	}

	public boardVO select(){
		boardVO vo = new boardVO() ;
		vo.setSeq(1);
		String sql	= "select * from board";
		try {
			pstmt				= con.prepareStatement(sql);
			rs				   = pstmt.executeQuery();
			while(rs.next()){
				int seq = rs.getInt("seq") ;
				String writer = rs.getString("writer") ;
				String title = rs.getString("title") ;
				String contents = rs.getString("contents") ;
				String writeDate = rs.getString("write_date") ;

				System.out.println(" seq  : "  + seq ) ;
				System.out.println(" writer  : "  + writer ) ;
				System.out.println(" title  : "  + title ) ;
				System.out.println(" content  : "  + contents ) ;
				System.out.println(" writeDate  : "  + writeDate ) ;

				vo.setSeq(seq) ;
				vo.setWriter(writer) ;
				vo.setTitle(title) ;
				vo.setContents(contents) ;
				vo.setWriteDate(writeDate) ;
			}
		} catch (SQLException e) { System.out.println("쿼리 수행 실패"); }

		return vo ;
	}

}
