package com.tutor.platform.base;

import java.util.List;
import java.util.Map;


public  abstract class BaseServiceImpl<T, PK> implements BaseService<T, PK>{
	
	/**
	 * 传入dao
	 * @return
	 */
	public abstract BaseMapper<T,PK> getMapper();
	
	/**
	 * 查询所有结果
	 * 
	 * @param params
	 * @return
	 */
	public List<T> loadListByParams(Map<String, Object> params) throws Exception{
		return getMapper().loadListByParams(params);
	}

	/**
	 * 保存
	 * 
	 * @param t
	 */
	public void save(T t) throws Exception{
		getMapper().save(t);
	}

	/**
	 * 更新
	 * 
	 * @param t
	 */
	public void update(T t) throws Exception{
		getMapper().update(t);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void delete(PK id) throws Exception{
		getMapper().delete(id);
	}

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	public T loadById(PK id) throws Exception{
		return getMapper().loadById(id);
	}

}
