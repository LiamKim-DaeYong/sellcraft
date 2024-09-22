package com.sellcraft.controller

import com.sellcraft.dto.OrderRequest
import com.sellcraft.dto.OrderResponse
import com.sellcraft.service.order.OrderCommandService
import com.sellcraft.service.order.OrderQueryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/orders")
class OrderController(
    private val orderCommandService: OrderCommandService,
    private val orderQueryService: OrderQueryService
) {

    @GetMapping("/{orderId}")
    fun getOrderById(@PathVariable orderId: Long): ResponseEntity<OrderResponse> {
        val orderResponse = orderQueryService.getOrderById(orderId)
        return ResponseEntity.ok(orderResponse)
    }

    @GetMapping
    fun getOrdersByUserName(@RequestParam userName: String): ResponseEntity<List<OrderResponse>> {
        val orderResponses = orderQueryService.getOrdersByUserName(userName)
        return ResponseEntity.ok(orderResponses)
    }


    @PostMapping
    fun createOrder(@RequestBody orderRequest: OrderRequest): ResponseEntity<OrderResponse> {
        val orderResponse = orderCommandService.createOrder(orderRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse)
    }
}