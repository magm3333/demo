package com.reedcons.demo.business;

import com.reedcons.demo.model.User;
import com.reedcons.demo.model.exception.NotFoundException;

public interface IUserBusiness {

	public User loadByUserNameOrEmail(String usernameOrEmail) throws BusinessException, NotFoundException;

}
