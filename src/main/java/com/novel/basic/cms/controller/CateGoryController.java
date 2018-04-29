package com.novel.basic.cms.controller;

import com.novel.basic.cms.model.Category;
import com.novel.basic.cms.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CateGoryController {

	@Resource
	private CategoryService service;
	
	/**
	 * 分类
	 * @return
	 */
	@RequestMapping(value = "/category", method ={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findCategory(ModelMap modelMap) throws Exception {
		List<Category> categorys = service.findAll();
		//modelMap.addAttribute("categorys", categorys);
		return new ModelAndView("/category/category", modelMap);
	}
	
	/**
	 * put
	 * @return
	 */
	@RequestMapping(value = "/category", method ={RequestMethod.PUT})
	public ModelAndView put(ModelMap modelMap, String[] marked) throws Exception {
		if(marked!=null && marked.length>0){
			modelMap.put("category", service.findById(marked[0]));
			//edit
			return new ModelAndView("/category/edit", modelMap);
		}
		// add 
		return new ModelAndView("/category/add", modelMap);
	}
	
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping(value = "/category/add", method ={RequestMethod.POST})
	public @ResponseBody boolean add(Category category) throws Exception {
		try {
			service.add(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(value = "/category/edit", method ={RequestMethod.POST})
	public @ResponseBody boolean edit(Category category) throws Exception {
		try {
			service.update(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(value = "/category", method ={RequestMethod.DELETE})
	public @ResponseBody boolean delete(String[] marked) throws Exception {
		try {
			service.delete(marked);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
