package com.projects.weatherservice.business.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.projects.weatherservice.business.vo.UserVO;

import lombok.Data;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 19-Oct-2021
 *
 */
@Data
@Entity
@Table
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String userEmail;
	private String loginName;
	private String loginPassword;
	
	/**
	 * For persisting user data
	 * 
	 * @param user
	 */
	public UserDetails(UserVO user) {
		super();
		this.userName = user.getUserName();
		this.userEmail = user.getUserEmail();
		this.loginName = user.getLoginName();
		this.loginPassword = user.getLoginPassword();
	}
}
