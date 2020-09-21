package code.assessment.mail_service.kafka

import code.assestment.commons.Order
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
open class KafkaConsumerConfiguration {

    @Value("\${kafka.bootstrapServer}")
    private lateinit var bootstrapServer: String

    fun orderConsumerFactory(): ConsumerFactory<String, Order> {
        val configItems = mapOf(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServer,
                ConsumerConfig.GROUP_ID_CONFIG to "order-submitted"
        )

        return DefaultKafkaConsumerFactory(configItems, StringDeserializer(), JsonDeserializer(Order::class.java))
    }

    @Bean
    open fun orderKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, Order> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, Order>()
        factory.consumerFactory = orderConsumerFactory()
        return factory
    }
}