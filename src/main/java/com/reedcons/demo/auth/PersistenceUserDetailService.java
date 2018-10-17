package com.reedcons.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reedcons.demo.business.BusinessException;
import com.reedcons.demo.business.IUserBusiness;
import com.reedcons.demo.model.exception.NotFoundException;

@Service
public class PersistenceUserDetailService implements     UserDetailsService{

	@Autowired
	private IUserBusiness userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			return userService.loadByUserNameOrEmail(username);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (NotFoundException e) {
			throw new UsernameNotFoundException(e.getMessage(),e);
		}
	}

}
