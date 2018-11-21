package com.reedcons.demo.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reedcons.demo.business.BusinessException;
import com.reedcons.demo.business.IUserBusiness;
import com.reedcons.demo.model.User;
import com.reedcons.demo.model.exception.NotFoundException;
import com.reedcons.demo.model.persistence.UserRepository;
import com.reedcons.demo.model.util.UserDTO;

@Service
public class UserBusiness implements IUserBusiness {

	@Autowired
	private UserRepository userDAO;

	@Override
	public User loadByUserNameOrEmail(String usernameOrEmail) throws BusinessException, NotFoundException {
		try {
			List<User> l = userDAO.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
			if (l.size() == 0)
				throw new NotFoundException("No se encontró el usuario con id=" + usernameOrEmail);
			return l.get(0);
		} catch (Exception e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public List<UserDTO> listUsersSintetico(boolean enabled) throws BusinessException {
		try {
			return userDAO.listUsersSintetico(enabled);
			
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void setPassword(String password, String userOrEmail) throws BusinessException, NotFoundException {
		try {
			if( userDAO.setPassword(password, userOrEmail, userOrEmail)==0) {
				throw new NotFoundException("No se encontró el usuario "+userOrEmail);
			}
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
}

































