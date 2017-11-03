package com.kotlinweb.demo.board.service

import com.kotlinweb.demo.domain.Board

interface BoardService {
    fun saveBoard(board: Board)

    fun getBoardList():List<Board>

    fun getBoard(seq:Int):Board

    fun updateBoard(board:Board)

    fun deleteBoard(seq:Int)
}