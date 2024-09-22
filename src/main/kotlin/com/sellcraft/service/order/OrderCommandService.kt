package com.sellcraft.service.order

import com.sellcraft.dto.OrderRequest
import com.sellcraft.dto.OrderResponse
import com.sellcraft.mapper.toOrderEntity
import com.sellcraft.mapper.toOrderResponse
import com.sellcraft.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface OrderCommandService {
    fun createOrder(request: OrderRequest): OrderResponse
}

@Service
@Transactional
class OrderCommandServiceImpl(
    private val orderRepository: OrderRepository,
) : OrderCommandService {

    override fun createOrder(request: OrderRequest): OrderResponse {
        val order = request.toOrderEntity()
        val savedOrder = orderRepository.save(order)

        return savedOrder.toOrderResponse()
    }
}