package com.projects.weatherservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.projects.weatherservice.business.vo.ErrorMessage;
import com.projects.weatherservice.business.vo.api.ResponseVO;
import com.projects.weatherservice.exception.CustomException;

/**
 * Test cases
 * 
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 19-Oct-2021
 *
 */
@ExtendWith(MockitoExtension.class)
class WeatherServiceProxyTest {
	@InjectMocks
	private WeatherServiceProxy proxy;
	
	@Mock
	private RestTemplate restTemplate;
	
	private String weatherServiceURL = "/api/v1/weather";
	private String apiKey = "1234";
	
	@Test
	@DisplayName("getWeatherDetailsByCity - success response")
	void getWeatherDetailsByCity() throws CustomException {
		String city = "dubai";
		StringBuilder queryString = new StringBuilder(weatherServiceURL);
		queryString.append("?q=");
		queryString.append(city);
		queryString.append("&appid=");
		queryString.append(apiKey);
		HttpHeaders authHeader = new HttpHeaders();
		ResponseVO response = new ResponseVO();
		response.setId(5);
		ReflectionTestUtils.setField(proxy, WeatherServiceProxy.class, "weatherServiceURL", weatherServiceURL, String.class);
		ReflectionTestUtils.setField(proxy, WeatherServiceProxy.class, "apiKey", apiKey, String.class);
		ResponseEntity<ResponseVO> entity = ResponseEntity.ok(response);
		when(restTemplate.exchange(queryString.toString(), HttpMethod.POST, new HttpEntity<>(authHeader), ResponseVO.class)).thenReturn(entity);
		ResponseVO res = proxy.getWeatherDetailsByCity(city);
		assertEquals(res.getId(), entity.getBody().getId());
	}
	
	@Test
	@DisplayName("getWeatherDetailsByCity - CityNotFoundException")
	void getWeatherDetailsByCityOnCityNotFoundException() throws CustomException {
		String city = "dubai-dex";
		StringBuilder queryString = new StringBuilder(weatherServiceURL);
		queryString.append("?q=");
		queryString.append(city);
		queryString.append("&appid=");
		queryString.append(apiKey);
		HttpHeaders authHeader = new HttpHeaders();
		ReflectionTestUtils.setField(proxy, WeatherServiceProxy.class, "weatherServiceURL", weatherServiceURL, String.class);
		ReflectionTestUtils.setField(proxy, WeatherServiceProxy.class, "apiKey", apiKey, String.class);
		Exception ex = HttpClientErrorException.create(HttpStatus.NOT_FOUND, "City not found", null, null, null);
		CustomException exp = new CustomException(new ErrorMessage(404, "City not found. Try different one"));
		when(restTemplate.exchange(queryString.toString(), HttpMethod.POST, new HttpEntity<>(authHeader), ResponseVO.class)).thenThrow(ex);
		Exception exception = assertThrows(CustomException.class, () -> {
			proxy.getWeatherDetailsByCity(city);
	    });
		assertEquals(exception.getMessage(), exp.getErrorMsg().getErrorMsg());
	}

	@Test
	@DisplayName("getWeatherDetailsByCoordinate - success response")
	void getWeatherDetailsByCoordinate() throws CustomException {
		String lat = "1.3333";
		String lon = "4.2366";
		StringBuilder queryString = new StringBuilder(weatherServiceURL);
		queryString.append("?lat=");
		queryString.append(lat);
		queryString.append("&lon=");
		queryString.append(lon);
		queryString.append("&appid=");
		queryString.append(apiKey);
		HttpHeaders authHeader = new HttpHeaders();
		ResponseVO response = new ResponseVO();
		response.setId(5);
		ReflectionTestUtils.setField(proxy, WeatherServiceProxy.class, "weatherServiceURL", weatherServiceURL, String.class);
		ReflectionTestUtils.setField(proxy, WeatherServiceProxy.class, "apiKey", apiKey, String.class);
		ResponseEntity<ResponseVO> entity = ResponseEntity.ok(response);
		when(restTemplate.exchange(queryString.toString(), HttpMethod.POST, new HttpEntity<>(authHeader), ResponseVO.class)).thenReturn(entity);
		ResponseVO res = proxy.getWeatherDetailsByCoordinate(lat, lon);
		assertEquals(res.getId(), entity.getBody().getId());
	}
}
