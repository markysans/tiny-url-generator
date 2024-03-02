package dolan.maity.tiny.url.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TinyUrlGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinyUrlGeneratorApplication.class, args);
	}

}
