package com.tutor.module.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.tutor.module.demo.entity.SysUser;
import com.tutor.platform.base.BaseMapper;

/**
 * demo
 * @author xufeng
 * @date 2015.4.10
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser, String>{

}