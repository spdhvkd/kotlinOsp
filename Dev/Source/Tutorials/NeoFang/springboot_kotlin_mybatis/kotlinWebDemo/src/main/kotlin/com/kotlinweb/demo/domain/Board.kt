package com.kotlinweb.demo.domain

data class Board(
        var seq: Int = -1
        , var title: String? = ""
        , var content: String? = ""
        , var ymdFrt: String? = "")