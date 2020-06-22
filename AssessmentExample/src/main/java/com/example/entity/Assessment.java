package com.example.entity;

/**
 * 2020/5/7 12:46
 * root     Assessment用户信息处理之后实体类
 */
public class Assessment {
    private String no;
    private String name;
    private String sex;
    private Integer age;
    private String level;
    private String userPhotos;
    private String remarks;//备注


    public Assessment() {
        this.remarks="无备注";
    }

    public Assessment(String no, String name, String sex, Integer age, String level, String userPhotos) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.level = level;
        this.userPhotos = userPhotos;
        this.remarks="无备注";
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUserPhotos() {
        return userPhotos;
    }

    public void setUserPhotos(String userPhotos) {
        this.userPhotos = userPhotos;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", level='" + level + '\'' +
                ", userPhotos='" + userPhotos + '\'' +
                '}';
    }
}
