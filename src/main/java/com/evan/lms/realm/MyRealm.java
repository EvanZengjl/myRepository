package com.evan.lms.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evan.lms.entity.User;
import com.evan.lms.service.RoleService;
import com.evan.lms.service.UserService;

@Component
public class MyRealm extends AuthorizingRealm{

	
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String name = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addRole(String.valueOf(userService.getUserByName(name).getRoleNum()));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String name = (String) authenticationToken.getPrincipal();
		User user = userService.getUserByName(name);
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getName(),user.getPassword(),"ww");
		return authenticationInfo;
	}

}
