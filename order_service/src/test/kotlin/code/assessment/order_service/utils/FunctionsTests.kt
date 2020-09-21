package code.assessment.order_service.utils

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class FunctionsTests {

    @Test
    fun testGathering_WithOrderString() {
        val order = "apple orange orange appleapple"
        val expectation = mapOf(Product.APPLE to 3, Product.ORANGE to 2)
        val result = gather(order)
        assertEquals(expectation, result)
    }

    @Test
    fun testGathering_WithEmptyString() {
        val order = ""
        val expectation = mapOf(Product.APPLE to 0, Product.ORANGE to 0)
        val result = gather(order)
        assertEquals(expectation, result)
    }

    @Test
    fun testRegex() {
        assertNotNull(regex)
    }


}