package com.projects.weatherservice.exception;

import com.projects.weatherservice.business.vo.ErrorMessage;

import lombok.Getter;

/**
 * Custom Exception from API
 * 
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 19-Oct-2021
 *
 */
public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	private final transient ErrorMessage errorMsg;

	public CustomException(String message) {
		super(message);
		this.errorMsg = null;
	}
	public CustomException(ErrorMessage errorMsg) {
		super(errorMsg.getErrorMsg());
		this.errorMsg = errorMsg;
	}
}
