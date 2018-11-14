package com.reedcons.demo.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reedcons.demo.model.User;

@RestController
public class CoreRestController extends BaseRestController {

	@GetMapping(Constantes.URL_DENY)
	public ResponseEntity<String> deny() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}

	@GetMapping(Constantes.URL_LOGINOK)
	public ResponseEntity<UserSintetico> loginok() {
		return new ResponseEntity<UserSintetico>(new UserSintetico(getUserPrincipal()), HttpStatus.OK);
	}
	@GetMapping(Constantes.URL_AUTHINFO)
	public ResponseEntity<UserSintetico> authInfo() {
		return new ResponseEntity<UserSintetico>(new UserSintetico(getUserPrincipal()), HttpStatus.OK);
	}
	@GetMapping(Constantes.URL_LOGOUTOK)
	public ResponseEntity<String> logoutok() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}

class UserSintetico {

	public UserSintetico(User u) {
		setName(u.getUsername());
		setMail(u.getEmail());
		setRoles(u.getRoles().stream().map(role -> new String(role.getName())).collect(Collectors.toList()));
	}

	private String name;
	private List<String> roles;
	private String mail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
