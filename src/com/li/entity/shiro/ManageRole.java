package com.li.entity.shiro;

/**
 * 管理员和Role之间的外键表格
 * 用于Shiro里的权限赋予
 *
 */
public class ManageRole {
	
	/**管理员id*/
	private Integer manageId ;

	/**角色表id*/
	private Integer roleId ;
	
	private Role role;

	public ManageRole(Integer manageId, Integer roleId, Role role) {
		super();
		this.manageId = manageId;
		this.roleId = roleId;
		this.role = role;
	}

	public ManageRole() {
	}

	public Integer getManageId() {
		return manageId;
	}

	public void setManageId(Integer manageId) {
		this.manageId = manageId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "ManageRole [manageId=" + manageId + ", roleId=" + roleId + ", role=" + role + "]";
	}

}
