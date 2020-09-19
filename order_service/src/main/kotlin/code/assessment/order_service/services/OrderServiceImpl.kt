package code.assessment.order_service.services

import code.assessment.order_service.utils.gather
import code.assessment.order_service.utils.getCostPerItem
import code.assessment.order_service.utils.grandTotal
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl: OrderService {
    override fun computeGrandTotalWithOrder(order: String): Float {
        return gather(order)
                .getCostPerItem
                .grandTotal
    }
}