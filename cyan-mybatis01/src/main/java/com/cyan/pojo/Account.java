package com.cyan.pojo;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {

    private static final long serialVersionUID = -2939413098835096092L;

    private Integer id;
    private Integer userId;
    private String money;
    private Date createTime;

    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", money='" + money + '\'' +
                ", createTime=" + createTime +
                ", user=" + user +
                '}';
    }
}
