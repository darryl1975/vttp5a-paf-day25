package sg.edu.nus.iss.vttp5a_paf_day25.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MessagePoller {
    
    @Autowired
    @Qualifier("myredis")
    public RedisTemplate<String, String> template;

    @Async
    public void start() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new ThreadWorker(template, "task 01"));
        executorService.submit(new ThreadWorker(template, "task 02"));
    }
}
