package com.example.entity;

/**
 * @author ：root
 * @date ：Created in 2020/5/14 16:13
 * @description：记录     Record业务员给用户放贷信息实体类
 * @modified By：
 */
public class Record {
    private String no;
    private String userName;
    private String salesmanId;
    private String salesmanName;
    private String photo;
    private String loan;


    public Record() {
    }

    public Record(String no, String userName, String salesmanId, String salesmanName, String photo) {
        this.no = no;
        this.userName = userName;
        this.salesmanId = salesmanId;
        this.salesmanName = salesmanName;
        this.photo = photo;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
