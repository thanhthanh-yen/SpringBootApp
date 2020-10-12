package miniProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import miniProject.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// @Query(value = "select * from userlist order by id", nativeQuery = true)
	@Query(value = "select u from User u order by userId")
	List<User> getAllUser();

	User findByUserName(String userName);

	User findByUserId(Long userId);

	@Query("SELECT u FROM User u WHERE u.userName LIKE %?1%")
	List<User> search(String keyword);
}
