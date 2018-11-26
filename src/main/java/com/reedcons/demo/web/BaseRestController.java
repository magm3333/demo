package com.reedcons.demo.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.reedcons.demo.model.User;

public class BaseRestController {
	protected User getUserPrincipal () {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		User u=(User)auth.getPrincipal();
		return u;
	}
}
