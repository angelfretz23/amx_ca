package code.assessment.order_service.services

import code.assessment.order_service.utils.*
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl : OrderService {
    override fun computeGrandTotalWithOrder(order: String, offers: Map<Product, OfferHandler>): Float {
        return gather(order)
                .getCostPerItem(offers)
                .grandTotal
    }
}