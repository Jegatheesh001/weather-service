package com.projects.weatherservice.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.weatherservice.configuration.aspects.TrackLog;
import com.projects.weatherservice.exception.CustomException;
import com.projects.weatherservice.service.WeatherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 18-Oct-2021
 *
 */
@Api("Weather API's - REST")
@AllArgsConstructor
@RestController
@RequestMapping("/weather/v1")
public class WeatherResource {
	private WeatherService service;
	
	@TrackLog
	@GetMapping("/byCity")
	@ApiOperation("Get Weather details by city")
	public ResponseEntity<String> getWeatherDetailsByCity(String city) throws CustomException {
		return service.getWeatherDetailsByCity(city);
	}
	
	@TrackLog
	@GetMapping("/byCoordinate")
	@ApiOperation("Get Weather details by coordinate")
	public ResponseEntity<String> getWeatherDetailsByCoordinate(String lat, String lon) throws CustomException {
		return service.getWeatherDetailsByCoordinate(lat, lon);
	}
}
