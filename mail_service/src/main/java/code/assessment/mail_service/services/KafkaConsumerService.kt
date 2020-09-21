package code.assessment.mail_service.services

import code.assestment.commons.Order

interface KafkaConsumerService {
    fun consume(order: Order)
}