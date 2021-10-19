package com.projects.weatherservice.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.weatherservice.business.vo.UserVO;
import com.projects.weatherservice.configuration.aspects.TrackLog;
import com.projects.weatherservice.service.AuthService;

import lombok.AllArgsConstructor;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 19-Oct-2021
 *
 */
@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthResource {
	private AuthService service;
	
	@TrackLog
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserVO user) {
		return service.registerUser(user);
	}
}
