package code.assessment.order_service.utils

import code.assestment.commons.ProduceIndex
import org.junit.Test
import kotlin.test.assertEquals

class OffersFunctionsTests {

    @Test
    fun testBuyOneGetOneFreeFunction() {
        var total = buyOneGetOneFree(Product.APPLE, 0)
        assertEquals(0F, total)

        total = buyOneGetOneFree(ProduceIndex.APPLE, 3)
        assertEquals(1.2F, total)
    }

    @Test
    fun testThreeForTwoFunction() {
        var total = threeForTwo(ProduceIndex.ORANGE, 0)
        assertEquals(0F, total)

        total = threeForTwo(ProduceIndex.ORANGE, 6)
        assertEquals(1F, total)
    }
}