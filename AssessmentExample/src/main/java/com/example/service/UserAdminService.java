package com.example.service;

import com.example.entity.UserAdmin;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 16:35
 * @description：
 * @modified By：
 */
public interface UserAdminService {
    UserAdmin selectUserAdminByIdPwd(String id, String password);
}
