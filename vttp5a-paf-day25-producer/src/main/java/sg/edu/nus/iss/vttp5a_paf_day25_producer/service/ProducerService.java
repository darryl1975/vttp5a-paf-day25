package sg.edu.nus.iss.vttp5a_paf_day25_producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_paf_day25_producer.model.Order;
import sg.edu.nus.iss.vttp5a_paf_day25_producer.model.Todo;

@Service
public class ProducerService {
    
    @Autowired 
    @Qualifier("todo")
    RedisTemplate<String, Todo> redisTemplate;
    
    @Value("${redis.topic1}")
    private String topic1;

    @Autowired
    @Qualifier("order")
    RedisTemplate<String, Order> redisTemplate2;

    @Autowired
    ChannelTopic channelTopic;

    // public ProducerService() {
    //     redisTemplate = new RedisTemplate<>();
    // }

    public void sendMessage(Todo todo) {
        redisTemplate.convertAndSend(topic1, todo);
    }

    public Long publish(Order order) {
        return redisTemplate2.convertAndSend(channelTopic.getTopic(), order);
    }
}
