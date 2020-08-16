package miniProject.service;

import org.springframework.stereotype.Service;

import miniProject.dto.UserDto;

@Service
public interface UserService {
	UserDto getUserList();
}
