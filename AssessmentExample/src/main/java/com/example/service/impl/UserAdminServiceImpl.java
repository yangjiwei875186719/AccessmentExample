package com.example.service.impl;

import com.example.entity.UserAdmin;
import com.example.mapper.UserAdminMapper;
import com.example.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 16:36
 * @description：
 * @modified By：
 */
@Service
public class UserAdminServiceImpl implements UserAdminService {

    @Autowired
    private UserAdminMapper userAdminMapper;

    @Override
    public UserAdmin selectUserAdminByIdPwd(String id, String password) {
        UserAdmin userAdmin = userAdminMapper.selectUserAdminByIdPwd(id, password);
        return userAdmin;
    }
}
