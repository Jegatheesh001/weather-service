package com.projects.weatherservice.business.vo;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 18-Oct-2021
 *
 */
@Data
public class CoordinateVO {
	@ApiModelProperty(notes = "Latitude", required=true)
	@NotEmpty(message = "lat field should not empty")
	private String lat;
	@ApiModelProperty(notes = "Longitude", required=true)
	@NotEmpty(message = "lon field should not empty")
	private String lon;
}
