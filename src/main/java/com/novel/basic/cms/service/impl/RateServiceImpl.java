package com.novel.basic.cms.service.impl;


import com.novel.basic.cms.dao.RateDao;
import com.novel.basic.cms.model.Rate;
import com.novel.basic.cms.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dennis.sun
 */
@Service
public class RateServiceImpl implements RateService {


    @Autowired
    RateDao rateDaoImpl;

    @Override
    public List<Rate> findAll() {

        List<Rate> rates = rateDaoImpl.findAll();
        for(Rate rate : rates) {
            StringBuilder stringBuilder = new StringBuilder();
            //年不为空
            if(rate.getTerminable().contains("-")) {

                String showTerminables[] = rate.getTerminable().split("-");
                stringBuilder.append(showTerminables[0]);
                if("year".equals(showTerminables[1])) {
                    stringBuilder.append("年");
                }else {
                    stringBuilder.append("个月");
                }
            }

            rate.setTerminable(stringBuilder.toString());
        }

        return rates;
    }

    @Override
    public void add(Rate rate) {
        String annualInterestRate = rate.getAnnualInterestRate();
        DecimalFormat df  = new DecimalFormat("0.####");
        double drate = Double.parseDouble(annualInterestRate);
        rate.setAnnualInterestRate(df.format(drate));
        rateDaoImpl.add(rate);
    }

    @Override
    public Rate findById(String id) {
        Rate rate = new Rate();
        rate.setId(Integer.parseInt(id));
        return rateDaoImpl.findById(id, rate);
    }

    @Override
    public void update(Rate rate) {
        rateDaoImpl.update(rate);
    }

    @Override
    public void delete(String[] marked) {
        List<Integer> rates = new ArrayList<>();
        for(String id : marked){
            rates.add(Integer.parseInt(id));
        }
        rateDaoImpl.deleteByIds(rates);
    }
}
