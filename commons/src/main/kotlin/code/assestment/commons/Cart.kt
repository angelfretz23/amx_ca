package code.assestment.commons

data class Cart(
        val appleCount: Int,
        val orangeCount: Int,
        var total: Float? = null
)