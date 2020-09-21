package code.assestment.commons

import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ProduceIndexTests {

    @Test
    fun testAbleToInitProducefromString() {
        val appleString = "APPLE"
        val apple = ProduceIndex.valueOf(appleString).pick
        assertNotNull(apple)
        assertEquals(0.60F, apple.price)

        val orangeString = "ORANGE"
        val orange = ProduceIndex.valueOf(orangeString).pick
        assertNotNull(orange)
        assertEquals(0.25F, orange.price)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testInitProduceWithInvalidString() {
        ProduceIndex.valueOf("WATERMELON")
    }
}