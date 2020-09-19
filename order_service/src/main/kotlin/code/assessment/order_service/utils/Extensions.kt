package code.assessment.order_service.utils

import code.assestment.commons.Produce
import code.assestment.commons.ProduceFinder

typealias Product = ProduceFinder

val List<Produce>.consolidate: Map<Product, Int>
    get() {
        return ProduceFinder.values()
                .map { p ->
                    val countForProduct = this.filter { p.name == it.id }.count()
                    Pair(p, countForProduct)
                }.toMap()
    }

val Map<Product, Int>.getCostPerItem: Map<Product, Float>
    get() {
        return this.map { (product, count) ->
            Pair(product, product.pick.price * count.toFloat())
        }.toMap()
    }

val Map<Product, Float>.grandTotal: Float
    get() {
        return this.map { it.value }
                .takeIf { it.isNotEmpty() }
                ?.reduce { acc, next -> acc + next} ?: 0.0F
    }