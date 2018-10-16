package com.reedcons.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("password")).roles("USER")
				.and().withUser("admin").password(passwordEncoder().encode("password")).roles("USER", "ADMIN");

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Value("${recursos.estaticos}")
	private String recursosNoProtegidos;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] resources = recursosNoProtegidos.split(",");
		http.authorizeRequests().antMatchers(resources).permitAll().anyRequest().authenticated();

		http.httpBasic();

		http.formLogin().loginPage("/login.html").defaultSuccessUrl("/index.html").loginProcessingUrl("/dologin").permitAll()
				.failureUrl("/login.html");
		
		http.logout().logoutSuccessUrl("/logout.html");
		
		http.rememberMe().rememberMeParameter("rm");

		http.csrf().disable();

	}
}
