package miniProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// specify the name of database table to be used for mapping
@Table(name = "userlist")
public class User {
	// specify the primary key of an entity
	@Id
	// increment of specified column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Long userId;

	@Column(name = "name")
	private String userName;

	@Column(name = "age")
	private int userAge;

	@Column(name = "uri")
	private String userUri;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserUri() {
		return userUri;
	}

	public void setUserUri(String userUri) {
		this.userUri = userUri;
	}

	public User() {

	}
}
