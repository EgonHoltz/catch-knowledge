package pt.holtz.catchknowledge.catchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pt.holtz.catchknowledge.catchservice.model.Activity;

@SpringBootApplication
public class CatchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatchServiceApplication.class, args);
		//Activity ID is  instantiated on start of app (Singleton)
		Activity.getInstance();
		
	}

}
