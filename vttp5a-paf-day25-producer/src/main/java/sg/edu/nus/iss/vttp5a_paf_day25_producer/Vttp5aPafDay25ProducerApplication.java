package sg.edu.nus.iss.vttp5a_paf_day25_producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.vttp5a_paf_day25_producer.model.Todo;
import sg.edu.nus.iss.vttp5a_paf_day25_producer.service.ProducerService;

@SpringBootApplication
public class Vttp5aPafDay25ProducerApplication {

	// static ProducerService producerService = new ProducerService();

	public static void main(String[] args) {
		SpringApplication.run(Vttp5aPafDay25ProducerApplication.class, args);

		// for (int i = 0; i < 1000; i++) {
		// 	Todo todo = new Todo();
		// 	todo.setId(i);
		// 	todo.setTaskName("Task " + i);
		// 	producerService.sendMessage(todo);
		// }
	}

}
