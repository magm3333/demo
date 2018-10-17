package com.reedcons.demo.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reedcons.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByUsernameOrEmail(String username, String email);

}
