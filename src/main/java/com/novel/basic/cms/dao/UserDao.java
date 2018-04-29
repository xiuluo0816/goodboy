package com.novel.basic.cms.dao;

import com.novel.basic.cms.model.User;

import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface UserDao {

    User createUser(User user);
    void updateUser(User user);
    void deleteUser(Long userId);

    void correlationRoles(Long userId, Long... roleIds);
    void uncorrelationRoles(Long userId, Long... roleIds);

    User findOne(Long userId);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
