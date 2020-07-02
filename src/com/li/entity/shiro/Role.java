package com.li.entity.shiro;

/**
 * 角色表格
 * 用于Shiro里的权限赋予
 * 1	超级管理员	role_superman		能操作所有后台功能
 * 2	普通用户	role_general_user	一般用户，仅能操作自己账号
 *
 */
public class Role {
	
	private Integer id ;
	
	/**角色名称*/
	private String name ;
	
	/**角色关键字*/
	private String code ;
	
	/**描述*/
	private String intro;
	
	/**Role 对 Permission 的外键关联表*/
	private RolePermission rolePermission;

	public Role(Integer id, String name, String code, String intro, RolePermission rolePermission) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.intro = intro;
		this.rolePermission = rolePermission;
	}

	public Role() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public RolePermission getRolePermission() {
		return rolePermission;
	}

	public void setRolePermission(RolePermission rolePermission) {
		this.rolePermission = rolePermission;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", code=" + code + ", intro=" + intro + ", rolePermission="
				+ rolePermission + "]";
	}
}
