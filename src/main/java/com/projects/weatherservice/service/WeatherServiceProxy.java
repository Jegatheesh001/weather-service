package com.projects.weatherservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.RestTemplate;

import com.projects.weatherservice.business.vo.ErrorMessage;
import com.projects.weatherservice.exception.CustomException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 18-Oct-2021
 *
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class WeatherServiceProxy {
	private final RestTemplate restTemplate;
	private final HttpHeaders authHeader;

	@Value("${api.appKey}")
	private String apiKey;
	@Value("${api.path.weatherService}")
	private String weatherServiceURL;

	public String getWeatherDetailsByCity(String city) throws CustomException {
		StringBuilder queryString = new StringBuilder(weatherServiceURL);
		queryString.append("?q=");
		queryString.append(city);
		queryString.append("&appid=");
		queryString.append(apiKey);
		try {
			ResponseEntity<String> response = restTemplate.exchange(queryString.toString(), HttpMethod.POST,
					new HttpEntity<>(authHeader), String.class);
			return response.getBody();
		} catch (NotFound e) {
			throw new CustomException(new ErrorMessage(404, "City not found. Try different one"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new CustomException(new ErrorMessage(500, "Unknown error"));
		}
	}

	public String getWeatherDetailsByCoordinate(String lat, String lon) throws CustomException {
		StringBuilder queryString = new StringBuilder(weatherServiceURL);
		queryString.append("?lat=");
		queryString.append(lat);
		queryString.append("&lon=");
		queryString.append(lon);
		queryString.append("&appid=");
		queryString.append(apiKey);
		try {
			ResponseEntity<String> response = restTemplate.exchange(queryString.toString(), HttpMethod.POST,
					new HttpEntity<>(authHeader), String.class);
			return response.getBody();
		} catch (NotFound e) {
			throw new CustomException(new ErrorMessage(404, "Coordinates not found. Try different one"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new CustomException(new ErrorMessage(500, "Unknown error"));
		}
	}
}
