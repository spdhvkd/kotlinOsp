package com.kotlinweb.demo.board


import com.kotlinweb.demo.board.service.BoardService
import com.kotlinweb.demo.domain.Board
import com.kotlinweb.demo.domain.JsonResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView


@RestController
class AppController {

    var boardService: BoardService? = null
    @Autowired set

    @RequestMapping(value = "/")
    fun board(board: Board,mav: ModelAndView):ModelAndView{

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

    @RequestMapping(value = "/board/new", method = arrayOf(RequestMethod.GET))
    fun newBoard(mav : ModelAndView):ModelAndView{
        mav.viewName = "newBoard"
        return mav
    }

    @RequestMapping(value = "/board/save", method = arrayOf(RequestMethod.POST))
    fun saveBoard(@RequestBody board : Board, jsonResponse: JsonResponse):JsonResponse{

        boardService!!.saveBoard(board)
        jsonResponse.status = "00"

        return jsonResponse
    }

    @RequestMapping(value = "/board/update", method = arrayOf(RequestMethod.PUT))
    fun updateBoard(@RequestBody board : Board, jsonResponse: JsonResponse):JsonResponse{

        boardService!!.updateBoard(board)

        jsonResponse.status = "00"

        return jsonResponse
    }

    @RequestMapping(value = "/board/delete", method = arrayOf(RequestMethod.DELETE))
    fun deleteBoard(@RequestBody board : Board, jsonResponse: JsonResponse):JsonResponse{

        boardService!!.deleteBoard(board.seq)

        jsonResponse.status = "00"

        return jsonResponse
    }
}