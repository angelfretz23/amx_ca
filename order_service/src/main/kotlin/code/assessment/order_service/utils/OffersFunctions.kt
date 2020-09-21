package code.assessment.order_service.utils

typealias OfferHandler = (product: Product, count: Int) -> Float

val buyOneGetOneFree: OfferHandler
    get() = { product, count ->
        val price = product.pick.price
        val validCount: Int = count / 2
        val remainder = count % 2
        price * (validCount + remainder)
    }

val threeForTwo: OfferHandler
    get() = { product, count ->
        val price = product.pick.price
        val validCount: Int = count / 3
        val remainder = count % 3
        price * (remainder + (validCount * 2))
    }

val currentOffers = mapOf(Product.APPLE to buyOneGetOneFree, Product.ORANGE to threeForTwo)