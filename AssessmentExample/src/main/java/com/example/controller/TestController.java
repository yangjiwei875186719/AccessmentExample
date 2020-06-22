package com.example.controller;


import com.example.entity.Assessment;
import com.example.entity.Record;
import com.example.entity.UserInfo;
import com.example.service.AssessmentService;
import com.example.service.UserInfoService;
import com.example.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2020/5/6 16:01
 * root
 * 控制层
 */
@RestController
public class TestController {

    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("queryData")
    public JSONResult<Assessment> queryData(String no){
        UserInfo userInfo = userInfoService.selectUserInfoByNo(no);
        if(userInfo==null){
            return JSONResult.error(1,"数据不存在,请重新输入！");
        }
        Assessment assessment = assessmentService.handler(userInfo);
        return assessment==null?JSONResult.error(2,"未知错误，请重试"):JSONResult.success(assessment);
    }
    @RequestMapping("selectUser")
    public JSONResult selectUser(String no){
        UserInfo userInfo = userInfoService.selectUserInfoByNo(no);
        return JSONResult.success(userInfo);
    }

    @RequestMapping("queryAssessment")
    public JSONResult<Assessment> queryData2(String no){
        Assessment assessment = assessmentService.selectByNo(no);
        return assessment==null?JSONResult.error(1,"数据不存在,请重新输入！"):JSONResult.success(assessment);
    }


}
