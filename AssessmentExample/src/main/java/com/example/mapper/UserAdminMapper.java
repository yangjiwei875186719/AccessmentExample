package com.example.mapper;

import com.example.entity.UserAdmin;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 16:16
 * @description：
 * @modified By：
 */
public interface UserAdminMapper {

    /**
     * 通过id pwd查询数据
     * @param id
     * @param password
     * @return
     */
    UserAdmin selectUserAdminByIdPwd(@Param("id") String id, @Param("password") String password);
}
