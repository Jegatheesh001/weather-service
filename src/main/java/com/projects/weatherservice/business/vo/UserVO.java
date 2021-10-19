package com.projects.weatherservice.business.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 19-Oct-2021
 *
 */
@ApiModel("User Details")
@Data
public class UserVO {
	@ApiModelProperty(notes = "User login name (will be used for authentication)", required=true)
	private String loginName;
	@ApiModelProperty(notes = "User login password (will be used for authentication)", required=true)
	private String loginPassword;
	@ApiModelProperty(notes = "User name", required=true)
	private String userName;
	@ApiModelProperty(notes = "User email", required=true)
	private String userEmail;
}
