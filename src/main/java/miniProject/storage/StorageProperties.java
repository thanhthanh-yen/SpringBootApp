package miniProject.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// bind all properties that start with "storage" prefix (defined in application.properties) 
// to their corresponding attribute of POJO class when app is started
@ConfigurationProperties(prefix = "storage")
public class StorageProperties {

	private String location;

}