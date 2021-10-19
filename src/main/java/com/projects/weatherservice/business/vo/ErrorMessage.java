package com.projects.weatherservice.business.vo;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 19-Oct-2021
 *
 */
@Data
public class ErrorMessage {
	@ApiModelProperty(notes = "Error code")
	private Integer errorCode;
	@ApiModelProperty(notes = "Error message")
	private String errorMsg;
	private String timestamp;
	
	public ErrorMessage(Integer errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.timestamp = LocalDateTime.now().toString();
	}
}
