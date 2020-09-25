package miniProject.dto;

public class UserDto {

	public interface New {

	}

	private Long userId;
	private String userName;
	private int userAge;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserDto [id=" + userId + ", name=" + userName + ", age=" + userAge + ", uri=" + userUri + "]";
	}
}
