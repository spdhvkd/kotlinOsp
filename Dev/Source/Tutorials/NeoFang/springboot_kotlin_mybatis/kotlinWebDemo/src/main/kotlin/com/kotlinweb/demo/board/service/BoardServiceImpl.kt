package com.kotlinweb.demo.board.service

import com.kotlinweb.demo.board.mapper.BoardMapper
import com.kotlinweb.demo.domain.Board
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service



@Service("BoardService")
class BoardServiceImpl : BoardService  {

    @Autowired
    lateinit var boardMapper : BoardMapper

    override fun saveBoard(board: Board) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBoardList(): List<Board> {
        return boardMapper.getBoardList()
    }

    override fun getBoard(seq:Int): Board {
        return boardMapper.getBoard(seq)
    }
}