package code.assessment.order_service.utils

import code.assestment.commons.Apple
import code.assestment.commons.Orange
import code.assestment.commons.Produce
import org.junit.Test
import kotlin.math.exp
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
    fun testConsolidateExtensionFunction_WithEmptyList() {
        val emptyList = emptyList<Produce>()
        val expectation = mapOf(Product.APPLE to 0, Product.ORANGE to 0)
        val result = emptyList.consolidate
        assertEquals(expectation, result)
    }

    @Test
    fun testGetCostPerItemExtensionFunction_WithNoOffers() {
        val mapOfProducts = mapOf(Product.APPLE to 1, Product.ORANGE to 1)
        val expectation = mapOf(Product.APPLE to 0.60F, Product.ORANGE to 0.25F)
        val result = mapOfProducts.getCostPerItem()

        assertEquals(expectation, result)
    }

    @Test
    fun testGetCostPerItemExtensionFunction_WithOneOffer() {
        val offers = mapOf(Product.APPLE to buyOneGetOneFree)
        val mapOfProducts = mapOf(Product.APPLE to 4, Product.ORANGE to 2)
        val expectation = mapOf(Product.APPLE to 1.2F, Product.ORANGE to 0.5F)
        val result = mapOfProducts.getCostPerItem(offers)

        assertEquals(expectation, result)
    }

    @Test
    fun testGetCostPerItemExtensionFunction_WithTwoOffer() {
        val offers = mapOf(Product.APPLE to buyOneGetOneFree, Product.ORANGE to buyOneGetOneFree)
        val mapOfProducts = mapOf(Product.APPLE to 4, Product.ORANGE to 2)
        val expectation = mapOf(Product.APPLE to 1.2F, Product.ORANGE to 0.25F)
        val result = mapOfProducts.getCostPerItem(offers)

        assertEquals(expectation, result)
    }

    @Test
    fun testGrandTotalExtensionFunction_WithEmptyMap() {
        val emptyMapOfProductTotals: Map<Product, Float> = emptyMap()
        val expectation = 0F
        val result = emptyMapOfProductTotals.grandTotal

        assertEquals(expectation, result)
    }

    @Test
    fun testGrandTotalExtensionFunction() {
        val emptyMapOfProductTotals: Map<Product, Float> = mapOf(Product.ORANGE to 0.50F)
        val expectation = 0.5F
        val result = emptyMapOfProductTotals.grandTotal

        assertEquals(expectation, result)
    }
}