import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "Test", value = "/getBoard")
class HomeController : HttpServlet() {
	override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
		var testDBConnect = TestDBConnect()
		var boardVo = testDBConnect.select()
		res.setContentType("text/html; charset=UTF-8")
		res.setCharacterEncoding("UTF-8")
		
		var items = listOf<String>(boardVo.seq.toString(), boardVo.title, boardVo.contents, boardVo.writer, boardVo.writeDate)
		res.writer.write(items.joinToString("\n/ "))
	}
}
