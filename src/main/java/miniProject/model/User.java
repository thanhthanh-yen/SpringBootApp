package miniProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//specify the name of database table to be used for mapping
@Entity
@Table(name = "userlist")
public class User {
	// specify the primary key of an entity
	// increment of specified column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Long userId;

	@Column(name = "name")
	private String userName;

	@Column(name = "age")
	private int userAge;

	@Column(name = "uri")
	private String userUri;

	public User() {

	}
}
