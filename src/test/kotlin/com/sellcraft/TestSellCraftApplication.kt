package com.sellcraft

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<SellCraftApplication>().with(TestcontainersConfiguration::class).run(*args)
}
