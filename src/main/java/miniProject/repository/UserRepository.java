package miniProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import miniProject.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select * from userlist", nativeQuery = true)
	List<User> getAllUser();

	User findByUserName(String userName);

	User findByUserId(Long userId);

}
