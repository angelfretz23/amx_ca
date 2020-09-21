package code.assessment.order_service.kafka

import code.assestment.commons.Order
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer

@Configuration
class KafkaProducerConfig {

    @Value("\${kafka.bootstrapServer}")
    private lateinit var bootstrapServer: String


    @Bean
    fun orderProducerFactory(): ProducerFactory<String, Order> {
        val configItems = mapOf(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServer,
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java
        )

        return DefaultKafkaProducerFactory(configItems)
    }

    @Bean
    fun orderKafkaTemplate(): KafkaTemplate<String, Order> {
        return KafkaTemplate(orderProducerFactory())
    }
}