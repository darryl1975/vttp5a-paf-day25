package sg.edu.nus.iss.vttp5a_paf_day25_consumer.service;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_paf_day25_consumer.model.Todo;

@Service
public class ConsumerService {
    
    public void handleMessage(Todo todo) {
        System.out.println(todo);
    }
}
