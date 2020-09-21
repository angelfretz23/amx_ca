package code.assessment.order_service.services

import code.assessment.order_service.utils.OfferHandler
import code.assessment.order_service.utils.Product
import code.assestment.commons.Cart

interface OrderService {
    fun computeGrandTotalWithOrder(
            order: String,
            offers: Map<Product, OfferHandler> = mapOf()
    ):Cart
}
