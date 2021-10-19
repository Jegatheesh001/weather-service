package com.projects.weatherservice.business.vo.api;

import lombok.Data;

@Data
public class General {
	private int type;
	private int id;
	private String country;
	private int sunrise;
	private int sunset;
}
