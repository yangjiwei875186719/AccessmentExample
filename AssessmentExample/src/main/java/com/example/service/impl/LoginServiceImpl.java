package com.example.service.impl;

import com.example.entity.UserAdmin;
import com.example.entity.UserSalesman;
import com.example.entity.Vo.UserVo;
import com.example.mapper.UserAdminMapper;
import com.example.mapper.UserSalesmanMapper;
import com.example.service.LoginService;
import com.example.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 16:53
 * @description：
 * @modified By：
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private UserAdminMapper userAdminMapper;

    @Autowired
    private UserSalesmanMapper userSalesmanMapper;

    @Override
    public JSONResult login(UserVo userVo) {

        switch (userVo.getRole()){
            case "0":
                UserAdmin userAdmin = userAdminMapper.selectUserAdminByIdPwd(userVo.getId(), userVo.getPassword());

                if(userAdmin==null){
                    return JSONResult.error(1,"用户名或密码错误");
                }
                userAdmin.setRole("系统管理员");
                return JSONResult.success(userAdmin);
            case "1":
                UserSalesman userSalesman = userSalesmanMapper.selectUserSalemanByIdPwd(userVo.getId(), userVo.getPassword());
                if(userSalesman==null){
                    return JSONResult.error(1,"用户名或密码错误");
                }
                userSalesman.setRole("信贷业务员");
                return JSONResult.success(userSalesman);
            default:
                return JSONResult.error(1,"权限错误！");
        }
    }
}
