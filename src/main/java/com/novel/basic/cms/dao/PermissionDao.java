package com.novel.basic.cms.dao;

import com.novel.basic.cms.model.Permission;


/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface PermissionDao {

    Permission createPermission(Permission permission);

    void deletePermission(Long permissionId);

}
