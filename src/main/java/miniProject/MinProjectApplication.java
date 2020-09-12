package miniProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import miniProject.storage.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MinProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinProjectApplication.class, args);
	}

}
