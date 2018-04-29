package com.novel.basic.cms.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.novel.basic.cms.dao.PermissionDao;
import com.novel.basic.cms.model.Permission;
import org.springframework.stereotype.Service;

@Service
public class PermissionDaoImpl implements PermissionDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Permission createPermission(final Permission permission) {
    	sqlSessionTemplate.insert("createPermission", permission);
        return permission;
    }

    @Override
    public void deletePermission(Long permissionId) {
        //首先把与permission关联的相关表的数据删掉
        sqlSessionTemplate.delete("deleteRolePermission", permissionId);
        //把permission资源删掉
        sqlSessionTemplate.delete("deletePermission", permissionId);
    }

}
