package com.novel.basic.cms.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * @author cuichuping
 *
 */
public class ConvertUtil {

	
	
	public static Map<Object, Object> listToMap(List<? extends Object> list, String keyField) {
		
		if(list.isEmpty()) {
			return null;
		}
		
		Class<?> clazz = list.get(0).getClass();
		
		PropertyDescriptor descriptor = null;
		
		try {
			descriptor = new PropertyDescriptor(keyField, clazz);
		} catch (IntrospectionException e) {
			throw new RuntimeException("field ["+keyField+"] not found", e);
		}
		
		Method method = descriptor.getReadMethod();
		
		Map<Object, Object> map = new LinkedHashMap<Object, Object>();
		
		for (Object object : list) {
			try {
				map.put(method.invoke(object), object);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		return map;
		
		
	}
	
}
