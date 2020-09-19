package code.assessment.order_service.utils

import org.junit.Test
import kotlin.test.assertEquals

class FunctionsTests {

    @Test
    fun testGatheringWithOrderString() {
        val order = "apple orange orange appleapple"
        val expectation = mapOf(Product.APPLE to 3, Product.ORANGE to 2)
        val result = gather(order)
        assertEquals(expectation, result)
    }

    @Test
    fun testGatheringWithEmptyString() {
        val order = ""
        val expectation = mapOf(Product.APPLE to 0, Product.ORANGE to 0)
        val result = gather(order)
        assertEquals(expectation, result)
    }
}