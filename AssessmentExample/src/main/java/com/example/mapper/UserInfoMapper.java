package com.example.mapper;


import com.example.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 2020/5/7 13:08
 * root
 */
public interface UserInfoMapper {
    /**
     * 通过身份证查询userinfo表中的数据
     * @param no
     * @return
     */
    UserInfo selectByNo(@Param("no") String no);

    /**
     * 修改信息
     * @param userInfo
     * @return
     */
    Integer updateUserInfo(@Param("userInfo") UserInfo userInfo);

    /**
     * 保存
     * @param userInfo
     * @return
     */
    Integer saveUserInfo(@Param("userInfo") UserInfo userInfo);
}
