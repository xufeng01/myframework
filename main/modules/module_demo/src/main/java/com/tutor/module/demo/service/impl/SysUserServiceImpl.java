package com.tutor.module.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import com.tutor.module.demo.dao.SysUserMapper;
import com.tutor.module.demo.entity.SysUser;
import com.tutor.module.demo.service.SysUserService;
import com.tutor.platform.base.BaseMapper;
import com.tutor.platform.base.BaseServiceImpl;

/**
 * @author xufeng
 */
@Service
public class SysUserServiceImpl  extends BaseServiceImpl<SysUser, String> implements SysUserService{
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired  
	protected RedisTemplate<String,SysUser> redisTemplate;
	
	@Override
	public BaseMapper<SysUser, String> getMapper() {
		return sysUserMapper;
	}
	
	/**
	 * 测试redis
	 * @return
	 */
	public boolean addTest(){
		 boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {  
	            public Boolean doInRedis(RedisConnection connection)  
	                    throws DataAccessException {  
	                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
	                byte[] key  = serializer.serialize("3"); 
	                byte[] name = serializer.serialize("username3");
	                return connection.setNX(key, name);  
	            }  
	        });  
		 return result;
	}
	
	/**
	 * 测试redis
	 * @return
	 */
	public SysUser getAll(){
		SysUser result = redisTemplate.execute(new RedisCallback<SysUser>() {  
	            public SysUser doInRedis(RedisConnection connection)  
	                    throws DataAccessException {  
	            	 byte[] key = redisTemplate.getStringSerializer().serialize("3");  
	                 byte[] value = connection.get(key);  
	                 if (value == null) {  
	                     return null;  
	                 }  
	                 String name = redisTemplate.getStringSerializer().deserialize(value);
	                 SysUser user=new SysUser();
	                 user.setUserid("3");
	                 user.setUsername(name);
	                return user;
	            }  
	        });  
		 return result;
	}

}