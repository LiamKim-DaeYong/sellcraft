package com.sellcraft.mapper

import com.sellcraft.dto.OrderRequest
import com.sellcraft.dto.OrderResponse
import com.sellcraft.model.Orders

fun Orders.toOrderResponse(): OrderResponse {
    return OrderResponse(
        orderId = this.id!!,
        productName = this.productName,
        userName = this.userName,
        quantity = this.quantity,
        orderStatus = this.status.toString()
    )
}

fun OrderRequest.toOrderEntity(): Orders {
    return Orders(
        productName = this.productName,
        userName = this.userName,
        quantity = this.quantity
    )
}