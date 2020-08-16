package miniProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import miniProject.dto.UserDto;

@Service
public interface UserService {
	List<UserDto> getUserList();
}
