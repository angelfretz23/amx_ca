package code.assessment.order_service.services

import org.junit.Test
import kotlin.test.assertEquals

class OrderServiceImplTests {

    private val orderService: OrderService
        get() = OrderServiceImpl()

    @Test
    fun testGrandTotalWithOrder() {
        val order = "orangeapple watermelon"
        val expectation = 0.85F
        val result = orderService.computeGrandTotalWithOrder(order)

        assertEquals(expectation, result)
    }

    @Test
    fun testGrandTotalWhenOrderIsEmpty() {
        val order = ""
        val expectation = 0F
        val result = orderService.computeGrandTotalWithOrder(order)

        assertEquals(expectation, result)
    }
}