package com.kotlinweb.demo

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@MapperScan("com.kotlinweb.demo.board.mapper")
class KotlinwebdemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinwebdemoApplication::class.java, *args)
}