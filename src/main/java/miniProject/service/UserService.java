package miniProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import miniProject.dto.UserDto;

@Service
public interface UserService {
	List<UserDto> getUserList();

	UserDto insertUser(UserDto userDto);

	UserDto updateUser(UserDto userDto);

	List<UserDto> searchUser(String keyword);
}
