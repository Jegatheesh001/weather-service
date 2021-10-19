package com.projects.weatherservice.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.weatherservice.configuration.aspects.TrackLog;

import lombok.AllArgsConstructor;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 18-Oct-2021
 *
 */
@AllArgsConstructor
@RestController
@RequestMapping("/weather/v1")
public class WeatherResource {
	private WeatherService service;
	
	@TrackLog
	@GetMapping("/byCity")
	public ResponseEntity<String> getWeatherDetailsByCity(String city) {
		return service.getWeatherDetailsByCity(city);
	}
}
