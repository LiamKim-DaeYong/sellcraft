package com.sellcraft.model

import com.sellcraft.common.enums.OrderStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "orders")
class Orders(
    @Column(nullable = false)
    var productName: String,

    @Column(nullable = false)
    var userName: String,

    @Column(nullable = false)
    var quantity: Int,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
    @Column(nullable = false, unique = true)
    val orderNumber: String = generateOrderNumber()

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: OrderStatus = OrderStatus.PENDING
        private set

    fun updateOrderStatus(newStatus: OrderStatus) {
        this.status = newStatus
    }

    companion object {
        fun generateOrderNumber(): String {
            return UUID.randomUUID().toString()
        }
    }
}
