package com.sellcraft.dto

data class OrderRequest(
    val productName: String,
    val userName: String,
    val quantity: Int
)