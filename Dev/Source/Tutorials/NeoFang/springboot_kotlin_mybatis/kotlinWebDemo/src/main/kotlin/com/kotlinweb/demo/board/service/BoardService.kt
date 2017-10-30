package com.kotlinweb.demo.board.service

import com.kotlinweb.demo.domain.Board

interface BoardService {
    fun saveBoard(board: Board)

    fun getBoardList():List<Board>

    fun getBoard(seq:Int):Board
}