package code.assessment.order_service.utils

import code.assestment.commons.ProduceIndex

internal val regex: Regex
    get() {
        val regexString = ProduceIndex.values()
                .map { it.toString() }
                .reduce { acc, next -> "$acc|$next" } // (APPLE|ORANGE)
        return Regex("($regexString)")
    }

internal fun gather(order: String): Map<Product, Int> {
    val produceList = regex.findAll(order.toUpperCase())
            .map { it.value }
            .map { ProduceIndex.valueOf(it).pick }
            .toList()
    return produceList.consolidate
}