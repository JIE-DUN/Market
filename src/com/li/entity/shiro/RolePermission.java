package com.li.entity.shiro;


/**
 * 角色Role和Permission之间的外键表格
 * 用于Shiro里的权限赋予
 *
 */
public class RolePermission {
	
	/**角色表id*/
	private Integer roleId ;

	/**权限表id*/
	private Integer permId ;
	
	private Permission permission;

	public RolePermission(Integer roleId, Integer permId, Permission permission) {
		this.roleId = roleId;
		this.permId = permId;
		this.permission = permission;
	}

	public RolePermission() {
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermId() {
		return permId;
	}

	public void setPermId(Integer permId) {
		this.permId = permId;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "RolePermission [roleId=" + roleId + ", permId=" + permId + ", permission=" + permission + "]";
	}
	
}
