package miniProject.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import miniProject.dto.UserDto;
import miniProject.model.User;

@Component
public class UserMapper implements IMapper<User, UserDto> {

	public User toEntity(UserDto dto) {
		// TODO Auto-generated method stub
		User entity = new User();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public UserDto toDto(User entity) {
		// TODO Auto-generated method stub
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
