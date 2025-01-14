package sg.edu.nus.iss.vttp5a_paf_day25;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.vttp5a_paf_day25.service.MessagePoller;

@SpringBootApplication
public class Vttp5aPafDay25Application implements CommandLineRunner {

	// slide 11
	@Autowired
	private MessagePoller messagePoller;

	public static void main(String[] args) {
		SpringApplication.run(Vttp5aPafDay25Application.class, args);


	}

	@Override
	public void run(String... args) throws Exception {

		messagePoller.start();
	}

}
