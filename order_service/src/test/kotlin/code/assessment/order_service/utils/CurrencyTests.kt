package code.assessment.order_service.utils

import org.junit.Test
import kotlin.test.assertEquals

class CurrencyTests {

    @Test
    fun testCurrencyFormatting() {
        assertEquals("$1.00", Currency.format(1))
        assertEquals("$1.50", Currency.format(1.5))
        assertEquals("$4.50", Currency.format(4.50F))
        assertEquals("$7.00", Currency.format(7L))
    }
}