package sg.edu.nus.iss.vttp5a_paf_day25_producer.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.vttp5a_paf_day25_producer.model.Order;
import sg.edu.nus.iss.vttp5a_paf_day25_producer.model.Todo;
import sg.edu.nus.iss.vttp5a_paf_day25_producer.service.ProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/messages")
public class ProducerController {
    
    @Autowired
    ProducerService producerService;

    @PostMapping("")
    public ResponseEntity<String> sendMessage(@RequestBody Todo todo) {
        producerService.sendMessage(todo);
        
        return new ResponseEntity<>("Message sent", HttpStatus.OK);
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendOrder(@RequestBody Order order) {
        producerService.publish(order);
        
        return new ResponseEntity<>("Message sent", HttpStatus.OK);
    }
    
    
}
