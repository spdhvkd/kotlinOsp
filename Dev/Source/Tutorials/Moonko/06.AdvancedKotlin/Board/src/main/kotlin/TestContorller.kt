import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "Test", value = "/getBoard")
class HomeController : HttpServlet() {

	override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
		var dBConnect = TestDBConnect()
		dBConnect.select(dBConnect.getConnection()).apply {
			var items = listOf<String>(seq.toString(), title, contents, writer, writeDate)
			req.setAttribute("obj", items.joinToString("\n/ "))
		}
		
		var dispatcher = req.getRequestDispatcher("index.jsp")
		res.run {
			setContentType("text/html; charset=UTF-8")
			setCharacterEncoding("UTF-8")
			dispatcher.forward(req, res)
		}
	}
}
