package com.kotlinweb.demo.board.mapper

import com.kotlinweb.demo.domain.Board
import org.apache.ibatis.annotations.Mapper

@Mapper
interface BoardMapper {
    fun getBoardList():List<Board>

    fun getBoard(seq:Int):Board

    fun saveBoard(board:Board)

    fun updateBoard(board:Board)

    fun deleteBoard(seq:Int)

}