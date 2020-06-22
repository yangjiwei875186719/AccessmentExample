package com.example.service;


import com.example.entity.Assessment;
import com.example.entity.UserInfo;

/**
 * 2020/5/7 14:00
 * root
 */
public interface AssessmentService {

    /**
     * 数据处理
     * @return
     */
    Assessment handler(UserInfo userInfo);
    /**
     * 通过身份证号查询assessment表中的数据
     * @param no
     * @return
     */
    Assessment selectByNo(String no);
}
