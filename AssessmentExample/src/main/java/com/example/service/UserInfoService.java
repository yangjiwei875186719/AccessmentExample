package com.example.service;


import com.example.entity.UserInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 2020/5/7 13:58
 * root
 */
public interface UserInfoService {

    /**
     * 通过身份证号查询数据
     * @param no
     * @return
     */
    UserInfo selectUserInfoByNo(String no);

    /**
     * 更新
     * @param userInfo
     * @return
     */
    Integer updateUserInfo(UserInfo userInfo);

    /**
     * 文件上传
     * @param file
     * @return
     */
    Boolean fileUpload(MultipartFile file);
}
