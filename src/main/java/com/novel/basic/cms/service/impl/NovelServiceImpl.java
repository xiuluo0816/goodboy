package com.novel.basic.cms.service.impl;

import org.springframework.beans.factory.annotation.Value;
/**
 * @author sun
 * */
import org.springframework.stereotype.Service;

import com.novel.basic.cms.service.NovelService;
@Service
public class NovelServiceImpl implements NovelService {

	@Value("${username}")
	private String username;
	
	@Value("${password}")
	private String password;
	
	@Override
	public boolean login(String id, String password) {
		if(username.equals(id.trim()) && password.equals(password.trim())){
			return true;
		}else{
			return false;
		}
	}

}
