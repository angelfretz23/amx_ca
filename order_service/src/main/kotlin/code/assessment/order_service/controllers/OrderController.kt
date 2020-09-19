package code.assessment.order_service.controllers

import code.assessment.order_service.services.OrderServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController {

    @Autowired
    private lateinit var orderService: OrderServiceImpl

    @PostMapping("/order")
    fun orderProduce(@RequestBody order: String?): String {
        if (order.isNullOrBlank()) {
            return "Your order was empty."
        }
        return "Your total is: ${orderService.computeGrandTotalWithOrder(order)}"
    }
}