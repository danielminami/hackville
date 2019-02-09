package hackville.elderly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ElderlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElderlyApplication.class, args);
	}

}

