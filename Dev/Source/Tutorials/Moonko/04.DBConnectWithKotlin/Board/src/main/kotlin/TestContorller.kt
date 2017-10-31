import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "Test", value = "/getBoard")
class HomeController : HttpServlet() {

	override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
		var dBConnect = TestDBConnect()
		res.setContentType("text/html; charset=UTF-8")
		res.setCharacterEncoding("UTF-8")

		// 얻어진 것이 정확히 확인 된 Connection객체를 select메소드에 인자로 전달
		var boardVo = dBConnect.select(dBConnect.getConnection())
		var items = listOf<String>(boardVo.seq.toString(), boardVo.title, boardVo.contents, boardVo.writer, boardVo.writeDate)

		res.writer.write(items.joinToString("\n/ "))
	}
}
