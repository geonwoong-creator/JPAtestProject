package JPA.TEST.Project.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WoongApplication {

	public static void main(String[] args) {
		SpringApplication.run(WoongApplication.class, args);
	}


}
