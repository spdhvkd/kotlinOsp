package com.kotlinweb.demo.board.service

import com.kotlinweb.demo.board.mapper.BoardMapper
import com.kotlinweb.demo.domain.Board
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service



@Service("BoardService")
class BoardServiceImpl : BoardService  {

    var boardMapper: BoardMapper? = null
      @Autowired set

    override fun saveBoard(board: Board) {
        boardMapper!!.saveBoard(board)
    }

    override fun getBoardList(): List<Board> {
        return boardMapper!!.getBoardList()
    }

    override fun getBoard(seq:Int): Board {
        return boardMapper!!.getBoard(seq)
    }

    override fun updateBoard(board: Board) {
        boardMapper!!.updateBoard(board)
    }

    override fun deleteBoard(seq: Int) {
        boardMapper!!.deleteBoard(seq)
    }
}