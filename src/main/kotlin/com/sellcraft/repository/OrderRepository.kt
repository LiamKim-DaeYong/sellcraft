package com.sellcraft.repository

import com.sellcraft.model.Orders
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Orders, Long> {
    fun findByUserName(userName: String): List<Orders>
}