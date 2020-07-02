package com.li.entity.shiro;

/**
 * 用户和Role之间的外键表格
 * 用于Shiro里的权限赋予
 *
 */
public class UserRole {
	
	/**用户id*/
	private Integer userId ;

	/**角色表id*/
	private Integer roleId ;
	
	private Role role;

	public UserRole(Integer userId, Integer roleId, Role role) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.role = role;
	}

	public UserRole() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
		return "UserRole [userId=" + userId + ", roleId=" + roleId + ", role=" + role + "]";
	}
}
