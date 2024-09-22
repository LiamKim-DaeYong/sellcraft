package com.sellcraft

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SellCraftApplication

fun main(args: Array<String>) {
    runApplication<SellCraftApplication>(*args)
}
