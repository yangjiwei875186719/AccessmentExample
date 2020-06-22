package com.example.service;

import com.example.entity.Vo.UserVo;
import com.example.utils.JSONResult;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 16:53
 * @description：
 * @modified By：
 */
public interface LoginService {
    JSONResult login(UserVo userVo);
}
