package com.kotlinweb.demo.board


import com.kotlinweb.demo.board.service.BoardService
import com.kotlinweb.demo.domain.Board
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
class AppController {

    var boardService: BoardService? = null
    @Autowired set

    @RequestMapping(value = "/board")
    fun board(board: Board,mav: ModelAndView):ModelAndView{

        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
        val formatted = current.format(formatter)

        board.title = "리퀘스트"
        board.content = "바디바디바디"
        board.ymdFrt = formatted

        mav.addObject("list",boardService!!.getBoardList())
        mav.viewName = "index"
        return mav
    }

    @RequestMapping(value = "/board/get/{seq}", method = arrayOf(RequestMethod.GET))
    fun getBoard(@PathVariable(value = "seq") seq:Int, mav: ModelAndView):ModelAndView{
        mav.addObject("board",boardService!!.getBoard(seq))
        mav.viewName = "detail"
        return mav
    }
}