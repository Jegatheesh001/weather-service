package com.projects.weatherservice.business.vo;

import lombok.Data;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 19-Oct-2021
 *
 */
@Data
public class UserVO {
	private String loginName;
	private String userName;
	private String userEmail;
	private String loginPassword;
}
