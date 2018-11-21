package com.reedcons.demo.model.persistence;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reedcons.demo.model.User;
import com.reedcons.demo.model.util.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByUsernameOrEmail(String username, String email);

	@Query(name="usuarioResumido",nativeQuery=true)
	public List<UserDTO> listUsersSintetico(boolean enabled);
	

	@Transactional
	@Modifying
	@Query(value="UPDATE users SET password=? WHERE username=? OR email=?",nativeQuery=true)
	public int setPassword(String password, String username, String email);
}
