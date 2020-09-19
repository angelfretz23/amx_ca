package code.assestment.commons

import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ProduceFinderTests {

    @Test
    fun testAbleToInitProducefromString() {
        val appleString = "APPLE"
        val apple = ProduceFinder.valueOf(appleString).produce
        assertNotNull(apple)
        assertEquals(0.60, apple.price)

        val orangeString = "ORANGE"
        val orange = ProduceFinder.valueOf(orangeString).produce
        assertNotNull(orange)
        assertEquals(0.25, orange.price)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testInitProduceWithInvalidString() {
        ProduceFinder.valueOf("WATERMELON")
    }
}