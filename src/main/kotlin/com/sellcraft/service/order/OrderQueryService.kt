package com.sellcraft.service.order

import com.sellcraft.dto.OrderResponse
import com.sellcraft.mapper.toOrderResponse
import com.sellcraft.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface OrderQueryService {
    fun getOrderById(orderId: Long): OrderResponse
    fun getOrdersByUserName(userName: String): List<OrderResponse>
}

@Service
@Transactional(readOnly = true)
class OrderQueryServiceImpl(
    private val orderRepository: OrderRepository
) : OrderQueryService {

    override fun getOrderById(orderId: Long): OrderResponse {
        val orders = orderRepository.findById(orderId)
            .orElseThrow { IllegalArgumentException("Order not found") }

        return orders.toOrderResponse()
    }

    override fun getOrdersByUserName(userName: String): List<OrderResponse> {
        val orders = orderRepository.findByUserName(userName)
        return orders.map { it.toOrderResponse() }
    }
}