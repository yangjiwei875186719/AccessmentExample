package com.example.entity;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 16:10
 * @description：    user_salesman业务员信息实体类
 * @modified By：
 */
public class UserSalesman {
    private String role;
    private String id;
    private String password;
    private String name;
    private String photo;

    public UserSalesman() {
    }

    @Override
    public String toString() {
        return "UserAdmin{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public UserSalesman(String id, String password, String name, String photo) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.photo = photo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
