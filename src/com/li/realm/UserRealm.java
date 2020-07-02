package com.li.realm;

import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.li.entity.User;
import com.li.service.UserService;
import com.li.utils.Consts;

public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 获取授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//这个principals就是下面doGetAuthenticationInfo方法里SimpleAuthenticationInfo的principal参数
		if(principals.getPrimaryPrincipal() instanceof User){
			User user = (User) principals.getPrimaryPrincipal();
			Set<String> roles = userService.findRoleByUserId(user);
			if(roles != null && roles.size() > 0){
				simpleAuthorizationInfo.addRoles(roles);
			}
			Set<String> permissions = userService.findPermissionByUserId(user);
			if(permissions != null && permissions.size() > 0){
				simpleAuthorizationInfo.addStringPermissions(permissions);
			}
			simpleAuthorizationInfo.addRole("role_general_user");
			return simpleAuthorizationInfo;
		}
		return null;
	}

	/**
	 * 登录验证
	 * token:令牌，基于用户名和密码的令牌
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		User u = new User();
		u.setUserName(upToken.getUsername());
		User user = userService.getByEntity(u);
		if(user !=null){
			User principal = user;
			Object hashedCredentials = user.getPassWord();
			SecurityUtils.getSubject().getSession().setAttribute(Consts.USERNAME,user.getUserName());
			SecurityUtils.getSubject().getSession().setAttribute(Consts.USERID,user.getId());
			AuthenticationInfo authenInfo = new SimpleAuthenticationInfo(principal, hashedCredentials, getName());
			return authenInfo;
		}
		return null;
	}
}
