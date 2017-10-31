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

		var boardVo = dBConnect.select(dBConnect.getConnection())
		var items = listOf<String>(boardVo.seq.toString(), boardVo.title, boardVo.contents, boardVo.writer, boardVo.writeDate)

		var dispatcher = req.getRequestDispatcher("index.jsp")
		// JSP에서 제공하는 request객체 이용가능
		req.setAttribute("obj", items.joinToString("\n/ "))

		dispatcher.forward(req, res)
	}
}
