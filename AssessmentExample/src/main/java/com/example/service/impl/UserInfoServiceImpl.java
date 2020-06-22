package com.example.service.impl;


import com.example.entity.UserInfo;
import com.example.mapper.UserInfoMapper;
import com.example.service.UserInfoService;
import com.example.utils.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2020/5/7 14:00
 * root
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private AsyncTask asyncTask;

    @Override
    public UserInfo selectUserInfoByNo(String no) {
        UserInfo userInfo = userInfoMapper.selectByNo(no);
        return userInfo;
    }

    @Override
    public Integer updateUserInfo(UserInfo userInfo) {
        Integer i = userInfoMapper.updateUserInfo(userInfo);
        asyncTask.doTask();
        return i;
    }

    @Transactional(rollbackFor={ Exception.class })
    @Override
    public Boolean fileUpload(MultipartFile file) {
        UserInfo userInfo = new UserInfo();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(),"utf-8"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("\\s+");
                userInfo.setNo(split[0]);
                userInfo.setName(split[1]);
                userInfo.setSex(split[2]);
                userInfo.setAge(Integer.valueOf(split[3]));
                userInfo.setProvidentFunRatio(Float.valueOf(split[4]));
                userInfo.setMonthlyIncome(Float.valueOf(split[5]));
                userInfo.setMonthlySpending(Float.valueOf(split[6]));
                userInfo.setDefaultRecord(split[7]);
                userInfo.setUserPhotos(split[8]);
                Integer i = userInfoMapper.saveUserInfo(userInfo);
                if(i < 0){
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("出现异常！！！！");
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        //异步执行数据处理
        asyncTask.doTask();
        return true;
    }
}
