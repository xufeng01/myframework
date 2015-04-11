package com.tutor.platform.redis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;

/**
 * mybatis二级缓存
 * @author xufeng
 * @date 2015.4.7
 * <cache eviction="LRU" type="com.tutor.platform.redis.MybatisRedisCache" />
 */
public class MybatisRedisCache implements Cache{

	private static Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);
	
	@Autowired
    private JedisConnectionFactory jedisConnectionFactory;
	
	private Jedis redisClient=createReids(); 
	
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); 
    
    private String id;
    
    public MybatisRedisCache(final String id) {    
        if (id == null) {  
            throw new IllegalArgumentException("Cache instances require an ID");  
        }  
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id="+id);  
        this.id = id;  
    }   
    
	public void clear() {
		redisClient.flushDB();
	}

	public String getId() {
		return this.id;
	}

	public Object getObject(Object key) {
		 Object value = SerializeUtil.unserialize(redisClient.get(SerializeUtil.serialize(key.toString())));  
	     logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>getObject:"+key+"="+value);  
	     return value;
	}

	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	public int getSize() {
		return Integer.valueOf(redisClient.dbSize().toString());
	}

	public void putObject(Object key, Object value) {
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>putObject:"+key+"="+value);  
        redisClient.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));  
	}

	public Object removeObject(Object key) {
		return redisClient.expire(SerializeUtil.serialize(key.toString()),0); 
	}

	protected  Jedis createReids(){  
		return jedisConnectionFactory.getShardInfo().createResource();
	 }  
	
}
