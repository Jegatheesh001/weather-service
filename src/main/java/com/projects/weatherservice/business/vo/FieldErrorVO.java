package com.projects.weatherservice.business.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On 19-Oct-2021
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldErrorVO {
	private String objectName;
	private String field;
	private String message;
}
