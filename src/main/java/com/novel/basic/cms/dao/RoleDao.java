package com.novel.basic.cms.dao;

import com.novel.basic.cms.model.Role;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface RoleDao {

    Role createRole(Role role);
    void deleteRole(Long roleId);

    void correlationPermissions(Long roleId, Long... permissionIds);
    void uncorrelationPermissions(Long roleId, Long... permissionIds);

}
