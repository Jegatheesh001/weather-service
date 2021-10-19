package com.projects.weatherservice.configuration;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.projects.weatherservice.persistence.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * For basic authentication
 * 
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On 19-Oct-2021
 *
 */
@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private UserRepository repository;

    @Override
	public Authentication authenticate(Authentication authentication) {
		String loginName = authentication.getName();
		String password = authentication.getCredentials().toString();

		long count = repository.countByLoginNameAndLoginPassword(loginName, password);
		if (count == 0) {
			log.error("Wrong password. User accessed: {}", loginName);
			return null;
		}
		log.info("User Authorized: {}", loginName);
		return new UsernamePasswordAuthenticationToken(loginName, password, new ArrayList<>());
	}

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
