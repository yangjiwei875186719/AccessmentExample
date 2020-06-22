package com.example.controller;

import com.example.entity.Vo.UserVo;
import com.example.service.LoginService;

import com.example.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 16:22
 * @description：登录控制器
 * @modified By：
 */
@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;


    @RequestMapping("login")
    public JSONResult login(UserVo userVo){
        String role = userVo.getRole();
        String id = userVo.getId();
        String password = userVo.getPassword();
        if(role==null || id == null || password == null || role.equals("")||id.equals("")||password.equals("")){
            return JSONResult.error(2,"参数错误！");
        }
        JSONResult jsonResult = loginService.login(userVo);
        return jsonResult;
    }

    @RequestMapping("hello")
    public String hello(){

        return "String";
    }
}
