package miniProject.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

// bind all properties that start with "storage" prefix (defined in application.properties) 
// to their corresponding attribute of POJO class when app is started
@ConfigurationProperties(prefix = "storage")
public class StorageProperties {

	private String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}