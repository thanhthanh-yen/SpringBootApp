package miniProject.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniProject.dto.UserDto;
import miniProject.mapper.UserMapper;
import miniProject.model.User;
import miniProject.repository.UserRepository;
import miniProject.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public UserDto getUserList() {
		// TODO Auto-generated method stub
		try {
			List<User> users = userRepository.getAllUser();

			List<UserDto> userDtos = new ArrayList<UserDto>();
			if (users != null && !users.isEmpty()) {
				users.forEach(user -> userDtos.add(UserMapper.toDto(user)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
