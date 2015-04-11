package com.tutor.module.demo.controller;

import java.util.List;

import org.springframework.asm.commons.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tutor.module.demo.entity.SysUser;
import com.tutor.module.demo.service.impl.SysUserServiceImpl;
import com.tutor.platform.base.BaseController;

/**
 * demo
 * @author xufeng
 * @date 2015.4.10
 */
@Controller
@RequestMapping("/user") 
public class SysUserController extends BaseController{
	
	@Autowired
	private SysUserServiceImpl sysUserService; 
	
	/**
	 * 首页跳转
	 * @return
	 */
	@RequestMapping(value="/test1")
	public ModelAndView  intoPage(Model model)  {
		try {
			List<SysUser> list=sysUserService.loadListByParams(null);
			model.addAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return forword("userlist");
	}
	
	/**
	 * 首页跳转
	 * @return
	 */
	@RequestMapping(value="/test2")
	public ModelAndView  todetail(Model model)  {
		try {
			sysUserService.addTest();
			SysUser user=sysUserService.getAll();
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return forword("userdetail");
	}
}
