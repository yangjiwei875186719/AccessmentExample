package com.example.service;

import com.example.entity.UserSalesman;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 16:37
 * @description：
 * @modified By：
 */
public interface UserSalesmanService {
    /**
     * 登录时查询
     * @param id
     * @param password
     * @return
     */
    UserSalesman selectUserSalesmanByIdPwd(String id, String password);

    /**
     * 解析txt文件，保存到数据库
     * @param file
     * @return
     */
    Boolean addSalesmanUpload(MultipartFile file);
}
