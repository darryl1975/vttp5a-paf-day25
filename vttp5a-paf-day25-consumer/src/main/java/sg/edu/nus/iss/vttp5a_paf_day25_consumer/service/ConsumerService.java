package sg.edu.nus.iss.vttp5a_paf_day25_consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_paf_day25_consumer.model.Order;
import sg.edu.nus.iss.vttp5a_paf_day25_consumer.model.Todo;

@Service
public class ConsumerService implements MessageListener {

    @Autowired
    @Qualifier("order")
    private RedisTemplate<String, Order> template;
    
    public void handleMessage(Todo todo) {
        System.out.println(todo);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {

            String orderData = new String(message.getBody());
            System.out.println(orderData);

            // using Json-P to map it back to object
            // call the API in day 24 using RestTemplate to write to MySQL database

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }
}
