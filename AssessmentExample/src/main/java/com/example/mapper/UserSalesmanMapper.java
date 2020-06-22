package com.example.mapper;

import com.example.entity.UserSalesman;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 16:17
 * @description：
 * @modified By：
 */
public interface UserSalesmanMapper {
    /**
     * 通过id  password 查询数据
     * @param id
     * @param password
     * @return
     */
    UserSalesman selectUserSalemanByIdPwd(@Param("id") String id, @Param("password") String password);

    /**
     * 保存数据
     * @param userSalesman
     * @return
     */
    Integer saveUserSalesman(@Param("userSalesman") UserSalesman userSalesman);

    /**
     * 通过id查询
     * @param salesmanId
     * @return
     */
    UserSalesman selectUserSalemanById(@Param("id") String salesmanId);
}
