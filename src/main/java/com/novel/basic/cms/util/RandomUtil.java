package com.novel.basic.cms.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 随机串生成
 * @author cuichuping
 *
 */
public class RandomUtil {

	
	final static String RANDOM_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	
	final static int RANDOM_CHAR_COUNT = RANDOM_CHAR.length();
	
	
	
	public static String random(int length) {
	
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < length; i++) {
		
			builder.append(RANDOM_CHAR.charAt((int)(Math.random() * RANDOM_CHAR_COUNT)));
		
		}
		
		return builder.toString();
		
	}
	
	
	
	public static void main(String[] args) {
	
		Map<String, String> map = new HashMap<String, String>();
		
		for (int i = 0; i < 1000; i++) {
		
			String sequence = random(6);
			
			map.put(sequence, null);
			
			System.out.println(sequence);
		
		}
		
		System.out.println("重复(n): " + (1000 - map.size()));
	
	}
	
}
