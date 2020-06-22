package com.example.controller;

import com.example.entity.Record;
import com.example.entity.UserInfo;
import com.example.service.RecordService;
import com.example.service.UserInfoService;
import com.example.service.UserSalesmanService;
import com.example.utils.JSONResult;
import org.apache.arrow.flatbuf.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 20:56
 * @description：  管理员添加业务员信息  用户信息
 * @modified By：
 */
@RestController
public class AddInfomationController {


    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserSalesmanService userSalesmanService;

    @Autowired
    private RecordService recordService;

    /**
     * 从userinfo表查询用户信息
     * @param no
     * @return
     */
    @RequestMapping("queryUserInfo")
    public JSONResult queryUserInfo(String no) {
        UserInfo userInfo = userInfoService.selectUserInfoByNo(no);
        return userInfo == null ? JSONResult.error(1, "查询数据不存在") : JSONResult.success(userInfo);
    }

    /**
     * 更新userinfo信息
     * @param userInfo
     * @return
     */
    @RequestMapping("updateUserInfo")
    public JSONResult updateUserInfo(UserInfo userInfo) {
        System.out.println("userInfo = " + userInfo);
        System.out.println();
        Integer i = userInfoService.updateUserInfo(userInfo);
        return i == 1 ? JSONResult.success(null) : JSONResult.error(1, "修改失败");
    }

    /**
     * 上传文件添加用户信息
     * @param file
     * @return
     */
    @RequestMapping("fileUpload")
    public JSONResult fileUpload(MultipartFile file) {
        System.out.println("file.getName() = " + file.getName());
        Boolean b = userInfoService.fileUpload(file);
        return b ? JSONResult.success(null) : JSONResult.error(1, "文件解析失败，请检查文件内容以及格式！");
    }

    /**
     * 上传文件添加业务员信息
     * @param file
     * @return
     */
    @RequestMapping("addSalesmanUpload")
    public JSONResult addSalesmanUpload(MultipartFile file){
        System.out.println(" addSalesmanUpload   file.getName() = " + file.getName());
        Boolean b = userSalesmanService.addSalesmanUpload(file);
        return b ? JSONResult.success(null) : JSONResult.error(1, "文件解析失败，请检查文件内容以及格式！");
    }

    @RequestMapping("queryRecord")
    public JSONResult queryRecord(String no){
        Record record = recordService.queryRecord(no);
        return record==null?JSONResult.error(1,"查询数据不存在！"):JSONResult.success(record);
    }

    @RequestMapping("lending")
    public JSONResult lending(Record record){
        System.out.println(" lending  record = " + record);
        Integer i = recordService.lending(record);
        return i>0?JSONResult.success(null):JSONResult.error(1,"系统错误");
    }
}
