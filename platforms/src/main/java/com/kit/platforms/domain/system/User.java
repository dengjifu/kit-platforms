package com.kit.platforms.domain.system;

/**
 * Created by Jelly on 2016/8/22.
 */
public class User {
    /* 用户编码*/
    private Integer userId;

    /*用户登录名*/
    private String loginName;
    /*姓名*/
    private String realName;
    /*用户状态*/
    private String userStatus;
    /*	密码*/
    private String password;
    /*创建时间*/
    private String createTime;
    /*修改时间*/
    private String modifyTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }


}
