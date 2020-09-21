package code.assessment.order_service.services

import code.assessment.order_service.utils.*
import code.assestment.commons.Cart
import code.assestment.commons.ProduceIndex
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl : OrderService {
    override fun computeGrandTotalWithOrder(order: String, offers: Map<Product, OfferHandler>): Cart {
        val gatherOrder = gather(order)
        val appleCount = gatherOrder[ProduceIndex.APPLE] ?: 0
        val orangeCount = gatherOrder[ProduceIndex.ORANGE] ?: 0
        val cart = Cart(appleCount, orangeCount)

        return gatherOrder
                .verifyInventory
                .getCostPerItem(offers)
                .grandTotal(cart)
    }
}