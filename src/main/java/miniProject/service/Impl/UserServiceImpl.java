package miniProject.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
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
	@Autowired
	UserMapper userMapper;

	public List<UserDto> getUserList() {
		// TODO Auto-generated method stub
		try {
			List<User> users = userRepository.getAllUser();

			List<UserDto> userDtos = new ArrayList<>();
			if (users != null && !users.isEmpty()) {
				users.forEach(user -> userDtos.add(userMapper.toDto(user)));
			}
			return userDtos;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public UserDto insertUser(UserDto userDto) {
		// TODO Auto-generated method stub
		try {
			User userDb = userRepository.findByUserName(userDto.getUserName());
			if (userDb == null) {
				User user = userMapper.toEntity(userDto);
				UserDto saveUserDto = userMapper.toDto(userRepository.save(user));
				return saveUserDto;
			} else {
				throw new ApplicationContextException("User has existed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ApplicationContextException("Can not inser user!");
		}
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		try {
			User userDb = userRepository.findByUserId(userDto.getUserId());
			if (userDb != null) {
				User user = userMapper.toEntity(userDto);
				UserDto saveUserDto = userMapper.toDto(userRepository.save(user));
				return saveUserDto;
			} else {
				throw new ApplicationContextException("User has not found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ApplicationContextException("Can not update user!");
		}
	}

}
