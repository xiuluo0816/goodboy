package com.novel.basic.cms.controller;

import com.novel.basic.cms.model.Rate;
import com.novel.basic.cms.model.User;
import com.novel.basic.cms.service.RateService;
import com.novel.basic.cms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * desc : 利率管理
 */
@Controller
public class RateController {

	@Resource
	private RateService rateService;

	@Resource
	private UserService userService;
	
	/**
	 * 利率管理查询
	 * @return
	 */
	@RequestMapping(value = "/rate", method ={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findRate(HttpServletRequest request,  ModelMap modelMap) throws Exception {
		List<Rate> rates = rateService.findAll();
		String userName =  request.getSession().getAttribute("loginName").toString();
		User user = userService.findByUsername(userName);
		modelMap.addAttribute("rates", rates);
		modelMap.addAttribute("user", user);
		return new ModelAndView("/rate/rate", modelMap);
	}
	
	/**
	 * put
	 * @return
	 */
	@RequestMapping(value = "/rate", method ={RequestMethod.PUT})
	public ModelAndView put(HttpServletRequest request, ModelMap modelMap, String[] marked) throws Exception {

		String userName =  request.getSession().getAttribute("loginName").toString();
		User user = userService.findByUsername(userName);
		modelMap.addAttribute("user", user);

		if(marked!=null && marked.length>0){
			modelMap.put("rate", rateService.findById(marked[0]));
			//edit
			return new ModelAndView("/rate/edit", modelMap);
		}
		// add 
		return new ModelAndView("/rate/add", modelMap);
	}
	
	/**
	 * 添加利率
	 * @return
	 */
	@RequestMapping(value = "/rate/add", method ={RequestMethod.POST})
	public @ResponseBody boolean add(Rate rate) throws Exception {
		try {
			rateService.add(rate);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(value = "/rate/edit", method ={RequestMethod.POST})
	public @ResponseBody boolean edit(Rate rate) throws Exception {
		try {
			rateService.update(rate);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(value = "/rate", method ={RequestMethod.DELETE})
	public @ResponseBody boolean delete(String[] marked) throws Exception {
		try {
			rateService.delete(marked);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
