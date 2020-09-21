package code.assessment.order_service.controllers

import code.assessment.order_service.services.OrderService
import code.assessment.order_service.utils.Currency
import code.assessment.order_service.utils.currentOffers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController {

    @Autowired
    private lateinit var orderService: OrderService

    @PostMapping("/order")
    fun orderProduce(@RequestBody order: String?): String {
        if (order.isNullOrBlank()) {
            return "Your order was empty."
        }
        val offers = currentOffers

        val result = orderService.computeGrandTotalWithOrder(order, offers)

        return "Your total is: ${Currency.format(result)}"
    }
}