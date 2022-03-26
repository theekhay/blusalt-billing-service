package blusalt.challenge.billingservice.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Configuration
    public class RabbitMQConfig {

        @Value("${spring.rabbitmq.queue}")
        private String queueName;

        @Value("${spring.rabbitmq.exchange}")
        private String exchange;

        @Value("${spring.rabbitmq.routingkey}")
        private String routingKey;

        @Value("${spring.rabbitmq.username}")
        private String username;

        @Value("${spring.rabbitmq.password}")
        private String password;

        @Value("${spring.rabbitmq.host}")
        private String host;

        @Bean
        Queue queue() {
            return new Queue(queueName);
        }

        @Bean
        TopicExchange exchange() {
            return new TopicExchange(exchange);
        }

        @Bean
        Binding binding(Queue queue, TopicExchange exchange) {
            return BindingBuilder.bind(queue).to(exchange).with(routingKey);
        }
        @Bean
        public ConnectionFactory connectionFactory() {
            CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
            cachingConnectionFactory.setUsername(username);
            cachingConnectionFactory.setPassword(password);
            return cachingConnectionFactory;
        }

        @Bean
        public MessageConverter jsonMessageConverter() {
            return new Jackson2JsonMessageConverter();
        }

        @Bean
        public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
            final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
            rabbitTemplate.setMessageConverter(jsonMessageConverter());
            return rabbitTemplate;
        }
    }

}
