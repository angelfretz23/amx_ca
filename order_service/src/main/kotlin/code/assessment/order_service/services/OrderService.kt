package code.assessment.order_service.services

interface OrderService {
    fun computeGrandTotalWithOrder(order: String):Float
}
