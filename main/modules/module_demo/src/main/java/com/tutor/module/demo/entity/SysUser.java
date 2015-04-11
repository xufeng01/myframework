package com.tutor.module.demo.entity;

import java.io.Serializable;

/**
 * demo
 * @author xufeng
 */
public class SysUser implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private String userid;
    
    /**
     * 登陆账号
     */
    private String username;
    
    /**
     * 登陆密码
     */
    private String password;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

 

}