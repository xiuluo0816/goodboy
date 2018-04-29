package com.novel.basic.cms.dao.impl;

import com.novel.basic.cms.dao.RateDao;
import com.novel.basic.cms.model.Rate;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service
public class RateDaoImpl implements RateDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<Rate> findAll() {
        return sqlSessionTemplate.selectList("findAllRates");
    }

    @Override
    public void add(Rate rate) {
        rate.setCreateTime(new Date());
        rate.setCreatedBy("张三");
        sqlSessionTemplate.insert("createRate", rate);
    }

    @Override
    public Rate findById(String id, Rate rate) {
        return sqlSessionTemplate.selectOne("queryRateById", rate);
    }

    @Override
    public void update(Rate rate) {
        sqlSessionTemplate.update("updateRateById", rate);
    }

    @Override
    public void deleteByIds(List<Integer> rates) {
        for(int id: rates){
            sqlSessionTemplate.update("deleteById", id);
        }
    }


}
