package com.projects.weatherservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projects.weatherservice.business.vo.UserVO;

import lombok.RequiredArgsConstructor;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 18-Oct-2021
 *
 */
@RequiredArgsConstructor
@Service
public class AuthService {
	public ResponseEntity<String> registerUser(UserVO user) {
		return null;
	}
}
