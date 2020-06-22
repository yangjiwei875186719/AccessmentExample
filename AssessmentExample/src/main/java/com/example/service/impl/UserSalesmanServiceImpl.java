package com.example.service.impl;

import com.example.entity.UserInfo;
import com.example.entity.UserSalesman;
import com.example.mapper.UserSalesmanMapper;
import com.example.service.UserSalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 16:37
 * @description：
 * @modified By：
 */
@Service
public class UserSalesmanServiceImpl implements UserSalesmanService {

    @Autowired
    private UserSalesmanMapper userSalesmanMapper;

    /**
     * 登录时查询
     *
     * @param id
     * @param password
     * @return
     */
    @Override
    public UserSalesman selectUserSalesmanByIdPwd(String id, String password) {

        UserSalesman userSalesman = userSalesmanMapper.selectUserSalemanByIdPwd(id, password);

        return userSalesman;
    }

    /**
     * 解析txt文件保存到数据库
     *
     * @param file
     * @return
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Boolean addSalesmanUpload(MultipartFile file) {
        UserSalesman userSalesman = new UserSalesman();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(),"utf-8"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                String[] split = line.split("\\s+");
                userSalesman.setId(split[0]);
                userSalesman.setPassword(split[1]);
                userSalesman.setName(split[2]);
                userSalesman.setPhoto(split[3]);
                Integer i = userSalesmanMapper.saveUserSalesman(userSalesman);
                if (i < 0) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("出现异常！！！！");
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }
}
