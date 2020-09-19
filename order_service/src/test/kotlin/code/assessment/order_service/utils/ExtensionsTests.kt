package code.assessment.order_service.utils

import code.assestment.commons.Apple
import code.assestment.commons.Orange
import code.assestment.commons.Produce
import org.junit.Test
import kotlin.test.assertEquals

class ExtensionsTests {

    @Test
    fun testConsolidateExtensionFunction() {
        val listOfProduce = listOf(Apple(), Orange())
        val expectation = mapOf(Product.APPLE to 1, Product.ORANGE to 1)
        val result = listOfProduce.consolidate
        assertEquals(expectation, result)
    }

    @Test
    fun testConsolidateExtensionFunctionWithEmptyList() {
        val emptyList = emptyList<Produce>()
        val expectation = mapOf(Product.APPLE to 0, Product.ORANGE to 0)
        val result = emptyList.consolidate
        assertEquals(expectation, result)
    }
}