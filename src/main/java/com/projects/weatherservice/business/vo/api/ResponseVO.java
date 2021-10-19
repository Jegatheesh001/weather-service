package com.projects.weatherservice.business.vo.api;

import java.util.List;

import lombok.Data;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 18-Oct-2021
 *
 */
@Data
public class ResponseVO {
	private Coordinate coord;
	private List<Weather> weather;
	private String base;
	private Climate main;
	private int visibility;
	private Wind wind;
	private Clouds clouds;
	private int dt;
	private General sys;
	private int timezone;
	private int id;
	private String name;
	private int cod;
}
