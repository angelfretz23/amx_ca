package code.assessment.order_service.utils

import code.assestment.commons.Cart
import code.assestment.commons.Produce
import code.assestment.commons.ProduceIndex

typealias Product = ProduceIndex

val List<Produce>.consolidate: Map<Product, Int>
    get() {
        return ProduceIndex.values()
                .map { p ->
                    val countForProduct = this.filter { p.name == it.id }.count()
                    Pair(p, countForProduct)
                }.toMap()
    }

fun Map<Product, Int>.getCostPerItem(offers: Map<Product, OfferHandler> = emptyMap()): Map<Product, Float> {
    return this.map { (product, count) ->
        val offer = offers[product] ?: { p, c -> p.pick.price * c }
        Pair(product, offer(product, count))
    }.toMap()
}

val Map<Product, Float>.grandTotal: (Cart) -> Cart
    get() = { cart ->
        val total = this.map { it.value }
                .takeIf { it.isNotEmpty() }
                ?.reduce { acc, next -> acc + next } ?: 0.0F
         Cart(cart.appleCount, cart.orangeCount, total)
    }