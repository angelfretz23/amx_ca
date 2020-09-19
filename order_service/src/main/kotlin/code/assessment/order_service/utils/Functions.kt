package code.assessment.order_service.utils

import code.assestment.commons.ProduceFinder

private val regex: Regex
    get() {
        val regexString = ProduceFinder.values()
                .map { it.toString() }
                .reduce { acc, next ->  "$acc|$next"}
        return Regex("($regexString)")
    }

internal fun gather(order: String): Map<Product, Int> {
    val produceList = regex.findAll(order.toUpperCase())
            .map{ it.value }
            .map{ ProduceFinder.valueOf(it).pick }
            .toList()
    return produceList.consolidate
}