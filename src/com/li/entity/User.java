package com.li.entity;

import java.io.Serializable;

import com.li.entity.shiro.UserRole;

/**
 * 用户
 */
public class User implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 电子邮箱
     */
    private String email;
    
    /**
     * 用户和Role之间的外键表格
     * 用于Shiro里的权限赋予
     */
    private UserRole userRole;

    public User(Integer id, String userName, String passWord, String phone, String realName, String sex, String address,
			String email, UserRole userRole) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.phone = phone;
		this.realName = realName;
		this.sex = sex;
		this.address = address;
		this.email = email;
		this.userRole = userRole;
	}

	public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", phone=" + phone
				+ ", realName=" + realName + ", sex=" + sex + ", address=" + address + ", email=" + email
				+ ", userRole=" + userRole + "]";
	}
}
