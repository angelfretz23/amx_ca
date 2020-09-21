package code.assessment.mail_service.services

import code.assestment.commons.Order
import code.assestment.commons.OrderError
import code.assestment.commons.utils.Currency
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.util.*

@Service
class KafkaConsumerServiceImpl: KafkaConsumerService {

    @KafkaListener(topics = ["order-submitted"], containerFactory = "orderKafkaListenerContainerFactory")
    override fun consume(order: Order) {
        handleOrder(order)
    }

    private fun handleOrder(order: Order) {
        if (order.error != null) {
            when (order.error) {
                OrderError.EMPTY_ORDER -> print("Your Order was empty. If you think this was a mistake, please contact Customer Support.")
                OrderError.INVENTORY_DEPLETED -> print("One of your items in your order is in backorder.")
            }
            return
        }

        if (order.cart != null) {
            val formattedTotal = Currency.format(order.cart?.total ?: 0.0F)
            println("Your order has been completed. Your total is ${formattedTotal}")
        }
    }

}