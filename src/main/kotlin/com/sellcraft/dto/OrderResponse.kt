package com.sellcraft.dto

data class OrderResponse(
    val orderId: Long,
    val productName: String,
    val userName: String,
    val quantity: Int,
    val orderStatus: String
)
