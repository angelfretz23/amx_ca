package code.assessment.order_service.controllers

import code.assessment.order_service.services.OrderService
import code.assestment.commons.utils.Currency
import code.assessment.order_service.utils.currentOffers
import code.assestment.commons.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController {

    companion object {
        const val TOPIC = "order-submitted"
    }

    @Autowired
    private lateinit var orderKafkaTemplate: KafkaTemplate<String, Order>

    @Autowired
    private lateinit var orderService: OrderService

    @PostMapping("/order")
    fun orderProduce(@RequestBody order: String?): String {
        if (order.isNullOrBlank()) {
            return "Your order was empty."
        }

        val offers = currentOffers
        val result = orderService.computeGrandTotalWithOrder(order, offers)

        orderKafkaTemplate.send(TOPIC, Order(result))

        return Currency.format(result.total ?: 0F)
    }
}