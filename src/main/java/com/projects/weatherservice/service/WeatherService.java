package com.projects.weatherservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projects.weatherservice.exception.CustomException;

import lombok.RequiredArgsConstructor;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 18-Oct-2021
 *
 */
@RequiredArgsConstructor
@Service
public class WeatherService {
	private final WeatherServiceProxy proxy;

	public ResponseEntity<String> getWeatherDetailsByCity(String city) throws CustomException {
		return ResponseEntity.status(HttpStatus.OK).body(proxy.getWeatherDetailsByCity(city));
	}

	public ResponseEntity<String> getWeatherDetailsByCoordinate(String lat, String lon) throws CustomException {
		return ResponseEntity.status(HttpStatus.OK).body(proxy.getWeatherDetailsByCoordinate(lat, lon));
	}
}
