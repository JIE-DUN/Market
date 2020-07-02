package com.li.entity.shiro;

/**
 * 权限表格
 * 用于Shiro里的权限赋予
 * 1	后台所有管理权限	manage:all	/manager/**
 * 2	新闻公告管理权限	manage:news	/manager/news/**
 */
public class Permission {
	
	private Integer id ;
	
	/**权限名称*/
	private String name ;
	
	/**权限关键字*/
	private String code ;
	
	/**权限请求路径*/
	private String url;

	public Permission(Integer id, String name, String code, String url) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.url = url;
	}

	public Permission() {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", code=" + code + ", url=" + url + "]";
	}

}
