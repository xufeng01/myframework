package com.tutor.module.demo.service;

import com.tutor.module.demo.entity.SysUser;
import com.tutor.platform.base.BaseService;

/**
 * @author xufeng
 */
public interface SysUserService extends BaseService<SysUser, String>{

	/**
	 * 测试redis
	 * @return
	 */
	public boolean addTest();
	
	/**
	 * 测试redis
	 * @return
	 */
	public SysUser getAll();
}