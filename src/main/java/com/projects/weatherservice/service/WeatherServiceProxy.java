package com.projects.weatherservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.RestTemplate;

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

	private String apiKey = "cd54b7fbdaf08c6e9677d93bfb7a35b2";
	@Value("${path.api.weatherService}")
	private String weatherServiceURL;

	public String getWeatherDetailsByCity(String city) {
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
			return e.getMessage();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return "Unknown error";
		}
	}

	public String getWeatherDetailsByCoordinate(String lat, String lon) {
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
			return e.getMessage();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return "Unknown error";
		}
	}
}
