package com.example.entity.Vo;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 17:14
 * @description：
 * @modified By：
 */
public class UserVo {
    private String id;
    private String password;
    private String role;

    public UserVo() {
    }

    public UserVo(String id, String password, String role) {
        this.id = id;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
