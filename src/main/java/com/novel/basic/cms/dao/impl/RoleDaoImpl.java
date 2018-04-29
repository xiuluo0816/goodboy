package com.novel.basic.cms.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.novel.basic.cms.dao.RoleDao;
import com.novel.basic.cms.model.Role;
import com.novel.basic.cms.model.RolePermssion;
import org.springframework.stereotype.Service;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service
public class RoleDaoImpl implements RoleDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Role createRole(final Role Role) {
    	sqlSessionTemplate.insert("createRole", Role);
        return Role;
    }

    @Override
    public void deleteRole(Long roleId) {
        //首先把和role关联的相关表数据删掉
    	sqlSessionTemplate.delete("deleteUserRoles", roleId);
    	//删除角色
    	sqlSessionTemplate.delete("deleteRole", roleId);
    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        if(permissionIds == null || permissionIds.length == 0) {
            return;
        }
        for(Long permissionId : permissionIds) {
            if(!exists(roleId, permissionId)) {
            	RolePermssion rp = new RolePermssion();
            	rp.setRoleId(roleId);
            	rp.setPermissionId(permissionId);
            	sqlSessionTemplate.insert("createRolePermission", rp);
            }
        }
    }

    @Override
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        if(permissionIds == null || permissionIds.length == 0) {
            return;
        }
        
        for(Long permissionId : permissionIds) {
            if(exists(roleId, permissionId)) {
            	RolePermssion rp = new RolePermssion();
            	rp.setRoleId(roleId);
            	rp.setPermissionId(permissionId);
            	sqlSessionTemplate.delete("deleteRolePermission", rp);
            }
        }
    }

    private boolean exists(Long roleId, Long permissionId) {
    	RolePermssion rp = new RolePermssion();
    	rp.setRoleId(roleId);
    	rp.setPermissionId(permissionId);
        return sqlSessionTemplate.selectOne("existsRolePermission", rp);
    }

}
