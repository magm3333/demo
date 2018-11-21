package com.reedcons.demo.business;

import java.util.List;

import com.reedcons.demo.model.User;
import com.reedcons.demo.model.exception.NotFoundException;
import com.reedcons.demo.model.util.UserDTO;

public interface IUserBusiness {

	public User loadByUserNameOrEmail(String usernameOrEmail) throws BusinessException, NotFoundException;
	
	public List<UserDTO> listUsersSintetico(boolean enabled) throws BusinessException;

	public void setPassword(String password, String userOrEmail) throws BusinessException, NotFoundException;
}
