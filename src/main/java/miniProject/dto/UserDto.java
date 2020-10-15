package miniProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private Long userId;
	private String userName;
	private int userAge;
	private String userUri;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserDto [id=" + userId + ", name=" + userName + ", age=" + userAge + ", uri=" + userUri + "]";
	}
}
