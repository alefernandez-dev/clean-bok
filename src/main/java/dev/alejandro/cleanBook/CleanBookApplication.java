package dev.alejandro.cleanBook;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CleanBookApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(CleanBookApplication.class)
				.run(args);
	}

}
