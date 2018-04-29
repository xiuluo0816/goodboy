package com.novel.basic.cms.service;

import com.novel.basic.cms.model.Rate;

import java.util.List;

/**
 * 
 * @author dennis.sun
 * 利率  Service
 */
public interface RateService {

	/**
	 * 查询所有利率
	 * */
	List<Rate> findAll();

	/**
	 * 添加利率
	 * */
	void add(Rate rate);
	
	/**
	 * 根据Id查询
	 * */
	Rate findById(String id);
	
	/**
	 * 更新利率
	 * */
	void update(Rate rate);

	/**
	 * 删除利率
	 * */
	void delete(String[] marked);

}
