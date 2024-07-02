package pe.edu.upeu.syspoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SysPooSwingApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SysPooSwingApplication.class, args);
		new SpringApplicationBuilder(SysPooSwingApplication.class)
				.headless(false)
				.web(WebApplicationType.NONE)
				.run(args);
	}

}
