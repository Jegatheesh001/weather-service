package com.projects.weatherservice.service;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projects.weatherservice.business.entity.UserDetails;
import com.projects.weatherservice.business.vo.UserVO;
import com.projects.weatherservice.persistence.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 18-Oct-2021
 *
 */
@RequiredArgsConstructor
@Service
public class AuthService {
	private final UserRepository repo;
	
	@Transactional
	public ResponseEntity<String> registerUser(UserVO user) {
		repo.save(new UserDetails(user));
		return ResponseEntity.status(HttpStatus.CREATED).body("Done");
	}
}
