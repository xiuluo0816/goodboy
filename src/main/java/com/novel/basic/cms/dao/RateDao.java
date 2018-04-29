package com.novel.basic.cms.dao;


import com.novel.basic.cms.model.Rate;

import java.util.List;

/**
 * 利率Dao层
 */
public interface RateDao {

    /**
     * desc : 查询利率
     * @return List<Rate>
     */
    List<Rate> findAll();

    /**
     * desc : 添加一个利率
     * @param rate
     */
    void add(Rate rate);

    /**
     * desc : 根据id查询利率
     * @return Rate
     */
    Rate findById(String id, Rate rate);

    /**
     * desc : 编辑利率
     */
    void update(Rate rate);

    /**
     * desc : 删除利率
     */
    void deleteByIds(List<Integer> rates);
}
