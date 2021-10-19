package com.projects.weatherservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projects.weatherservice.business.vo.api.ResponseVO;
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
	private final WeatherServiceCache cache;

	public ResponseEntity<ResponseVO> getWeatherDetailsByCity(String city) throws CustomException {
		ResponseVO data = cache.getWeatherDetailsByCity(city);
		if(data == null) {
			data = proxy.getWeatherDetailsByCity(city);
			cache.setWeatherDetailsByCity(city, data);
		}
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}

	public ResponseEntity<ResponseVO> getWeatherDetailsByCoordinate(String lat, String lon) throws CustomException {
		ResponseVO data = cache.getWeatherDetailsByCoordinate(lat, lon);
		if(data == null) {
			data = proxy.getWeatherDetailsByCoordinate(lat, lon);
			cache.getWeatherDetailsByCoordinate(lat, lon, data);
		}
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
}
