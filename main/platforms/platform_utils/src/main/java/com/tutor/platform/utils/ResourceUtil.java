package com.tutor.platform.utils;

import java.util.ResourceBundle;


/**
 * 资源工具类
 * @author xufeng
 * @date 2014.8.21
 */
public class ResourceUtil {

	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("sysconfig");

	/**
	 * 获取配置文件参数
	 * 
	 * @param name
	 * @return
	 */
	public static final String getConfigByName(String name) {
		return bundle.getString(name);
	}

}
