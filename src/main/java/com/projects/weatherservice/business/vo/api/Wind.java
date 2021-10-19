package com.projects.weatherservice.business.vo.api;

import lombok.Data;

@Data
public class Wind {
	private double speed;
	private int deg;
	private double gust;
}
