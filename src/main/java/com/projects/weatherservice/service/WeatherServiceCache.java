package com.projects.weatherservice.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.projects.weatherservice.business.vo.api.ResponseVO;

/**
 * In-memory cache is used, realizes cache at the last minute. 
 * 
 * @author jegatheesh.mageswaran
 * 	<b>Created</b> On On 20-Oct-2021
 *
 */
@Service
public class WeatherServiceCache {
	private Map<String, ResponseVO> cityCache = new HashMap<>();
	private Map<String, LocalDateTime> cityCacheTime = new HashMap<>();
	
	public ResponseVO getWeatherDetailsByCity(String city) {
		if(cityCache.containsKey(city)) {
			if(LocalDateTime.now().isBefore(cityCacheTime.get(city).plusMinutes(10))) {
				return cityCache.get(city);
			} else {
				cityCache.remove(city);
			}
		}
		return null;
	}

	public synchronized void setWeatherDetailsByCity(String city, ResponseVO data) {
		cityCache.put(city, data);
		cityCacheTime.put(city, LocalDateTime.now());
	}

	private Map<String, ResponseVO> coordinateCache = new HashMap<>();
	private Map<String, LocalDateTime> coordinateCacheTime = new HashMap<>();
	
	public ResponseVO getWeatherDetailsByCoordinate(String lat, String lon) {
		String key = lat.concat("-").concat(lon);
		if(coordinateCache.containsKey(key)) {
			if(LocalDateTime.now().isBefore(coordinateCacheTime.get(key).plusMinutes(10))) {
				return coordinateCache.get(key);
			} else {
				coordinateCache.remove(key);
			}
		}
		return null;
	}
	
	public synchronized void getWeatherDetailsByCoordinate(String lat, String lon, ResponseVO data) {
		String key = lat.concat("-").concat(lon);
		coordinateCache.put(key, data);
		coordinateCacheTime.put(key, LocalDateTime.now());
	}
}
