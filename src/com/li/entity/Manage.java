package com.li.entity;

import java.io.Serializable;

import com.li.entity.shiro.ManageRole;

/**
 * 管理员
 */
public class Manage implements Serializable {

    /**主键*/
    private Integer id;
    /**登录名*/
    private String userName;
    /**密码*/
    private String passWord;
    /**姓名*/
    private String realName;
    
    /**
     * 管理员和Role之间的外键表格
     * 用于Shiro里的权限赋予
     */
    private ManageRole manageRole;

    public Manage(Integer id, String userName, String passWord, String realName, ManageRole manageRole) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.realName = realName;
		this.manageRole = manageRole;
	}

	public Manage() {
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

	public ManageRole getManageRole() {
		return manageRole;
	}

	public void setManageRole(ManageRole manageRole) {
		this.manageRole = manageRole;
	}

	@Override
	public String toString() {
		return "Manage [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", realName=" + realName
				+ ", manageRole=" + manageRole + "]";
	}
	
}
