package com.example.entity;

/**
 * 2020/5/7 12:42
 * root
 *      userinfo用户初始信息实体类
 */
public class UserInfo {
    private String no;
    private String name;
    private String sex;
    private Integer age;
    private float providentFunRatio;
    private float monthlyIncome;
    private float monthlySpending;
    private String defaultRecord;
    private String userPhotos;

    public UserInfo() {
    }

    public UserInfo(String no, String name, String sex, Integer age, float providentFunRatio, float monthlyIncome, float monthlySpending, String defaultRecord, String userPhotos) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.providentFunRatio = providentFunRatio;
        this.monthlyIncome = monthlyIncome;
        this.monthlySpending = monthlySpending;
        this.defaultRecord = defaultRecord;
        this.userPhotos = userPhotos;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public float getProvidentFunRatio() {
        return providentFunRatio;
    }

    public void setProvidentFunRatio(float providentFunRatio) {
        this.providentFunRatio = providentFunRatio;
    }

    public float getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(float monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public float getMonthlySpending() {
        return monthlySpending;
    }

    public void setMonthlySpending(float monthlySpending) {
        this.monthlySpending = monthlySpending;
    }

    public String getDefaultRecord() {
        return defaultRecord;
    }

    public void setDefaultRecord(String defaultRecord) {
        this.defaultRecord = defaultRecord;
    }

    public String getUserPhotos() {
        return userPhotos;
    }

    public void setUserPhotos(String userPhotos) {
        this.userPhotos = userPhotos;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", providentFunRatio=" + providentFunRatio +
                ", monthlyIncome=" + monthlyIncome +
                ", monthlySpending=" + monthlySpending +
                ", defaultRecord='" + defaultRecord + '\'' +
                ", userPhotos='" + userPhotos + '\'' +
                '}';
    }
}
