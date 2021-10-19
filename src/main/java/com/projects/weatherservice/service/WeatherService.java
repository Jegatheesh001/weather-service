package com.projects.weatherservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

	public ResponseEntity<String> getWeatherDetailsByCity(String city) {
		return ResponseEntity.status(HttpStatus.OK).body(proxy.getWeatherDetailsByCity(city));
	}

	public ResponseEntity<String> getWeatherDetailsByCoordinate(String lat, String lon) {
		return ResponseEntity.status(HttpStatus.OK).body(proxy.getWeatherDetailsByCoordinate(lat, lon));
	}
}
