package com.novel.basic.cms.controller;

import com.novel.basic.cms.service.NovelService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class NovelController {

	@Resource
	private NovelService service;

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 登陆
	 * @return
	 */
	@RequestMapping(value = "/login", method ={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView login(ModelMap modelMap) throws Exception {

		return new ModelAndView("/login", modelMap);
	}

	/**
	 * 小说列表
	 * @return
	 */
	@RequestMapping(value = "/novelList", method ={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView novelList(ModelMap modelMap, String id, String password) throws Exception {
			return new ModelAndView("/novel/novelList", modelMap);
	}
	/** 
	 * 实际的登录代码 
	 * 如果登录成功，跳转至首页；登录失败，则将失败信息反馈对用户 
	 *  
	 * @param request 
	 * @param model 
	 * @return 
	 */  
	@RequestMapping(value = "/dologin", method ={RequestMethod.POST,RequestMethod.GET})  
	public ModelAndView doLogin(HttpServletRequest request, ModelMap model) {

		String msg = "";
	    String userName = request.getParameter("id");  
	    String password = request.getParameter("password");
	    UsernamePasswordToken token = new UsernamePasswordToken(userName, password);  
	    token.setRememberMe(true);  
	    Subject subject = SecurityUtils.getSubject();  
	    try {  
	        subject.login(token);
	        if (subject.isAuthenticated()) {
				HttpSession session = request.getSession();
				session.setAttribute("loginName", userName);
	        	return new ModelAndView("/rate/rate", model);
	        } else {  
	        	return new ModelAndView("/login/login", model);
	        }  
	    } catch (IncorrectCredentialsException e) {  
	        msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (ExcessiveAttemptsException e) {  
	        msg = "登录失败次数过多";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (LockedAccountException e) {  
	        msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (DisabledAccountException e) {  
	        msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (ExpiredCredentialsException e) {  
	        msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (UnknownAccountException e) {  
	        msg = "帐号不存在. There is no user with username of " + token.getPrincipal();  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    } catch (UnauthorizedException e) {  
	        msg = "您没有得到相应的授权！" + e.getMessage();  
	        model.addAttribute("message", msg);  
	        System.out.println(msg);  
	    }  
	    return new ModelAndView("/login/login", model);
	}  
}
