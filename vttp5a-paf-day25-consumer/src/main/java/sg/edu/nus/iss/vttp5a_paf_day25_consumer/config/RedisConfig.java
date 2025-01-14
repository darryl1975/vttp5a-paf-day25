package sg.edu.nus.iss.vttp5a_paf_day25_consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import sg.edu.nus.iss.vttp5a_paf_day25_consumer.model.Order;
import sg.edu.nus.iss.vttp5a_paf_day25_consumer.model.Todo;
import sg.edu.nus.iss.vttp5a_paf_day25_consumer.service.ConsumerService;

@Configuration
public class RedisConfig {

    @Value("${redis.topic1}")
    private String redisTopic;

    @Value("${redis.topic3}")
    String orderTopic;

    @Bean
    public RedisTemplate<String, Todo> redisTemplate(RedisConnectionFactory connFac,
            Jackson2JsonRedisSerializer<Todo> serializer) {
        RedisTemplate<String, Todo> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connFac);
        redisTemplate.setDefaultSerializer(serializer);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    @Bean
    public Jackson2JsonRedisSerializer<Todo> jackson2JsonRedisSerializer() {
        return new Jackson2JsonRedisSerializer<>(Todo.class);
    }

    @Bean
    public RedisMessageListenerContainer listenerContainer(MessageListenerAdapter messageListenerAdapter,
            RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(messageListenerAdapter, new PatternTopic(redisTopic));

        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(ConsumerService redisConsumerService) {
        MessageListenerAdapter adapter = new MessageListenerAdapter(redisConsumerService);
        adapter.setSerializer(new Jackson2JsonRedisSerializer<>(Todo.class));

        return adapter;
    }

    @Bean
    public RedisTemplate<String, Order> redisTemplate2(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Order> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic(orderTopic);
    }

    private MessageListener messageListener;
    private RedisConnectionFactory redisConnFac;

    @Bean
    public MessageListenerAdapter messageListenerAdapter() {
        return new MessageListenerAdapter(messageListener);
    }

    @Bean
    public RedisMessageListenerContainer redisContainer(ChannelTopic topic) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnFac);
        container.addMessageListener(messageListener, topic);
        return container;
    }
}
