package in.ac.ymcaust.AlumniBackendUMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AlumniBackendUmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlumniBackendUmsApplication.class, args);
	}

}
