package com.jx.service.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jx.dao.SysRoleDao;
import com.jx.dao.SysUserDao;
import com.jx.pojo.SysRole;
import com.jx.pojo.SysUser;

@Service
public class ShiroUserRealm extends AuthorizingRealm {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysRoleDao sysRoleDao;

	/**
	 * 设置凭证匹配器
	 * 
	 * @param credentialsMatcher
	 */

	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
		cMatcher.setHashAlgorithmName("MD5");
		super.setCredentialsMatcher(cMatcher);
	}

	/*
	 * 执行认证操作时,此方法用户获取用户认证信息 说明:此方法由认证管理器调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("==doGetAuthenticationInfo===");
		// 1.获取客户端提交的用户信息
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		Integer number = Integer.parseInt(username);
		// 2.基于用户名从数据库查询用户信息
		SysUser user = sysUserDao.findObjectByUserName(number);
		System.out.println(user);
		// 3.校验用户信息(用户存在吗)
		if (user == null)
			throw new AuthenticationException();
		// 4.对用户信息进行封装
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, // principal(用户身份)
				user.getPassWord(), // hashedCredentials(已经加密的密码)
				credentialsSalt, // credentialsSalt(盐)
				this.getName());// realm name
		System.out.println(info);
		return info;// 此对象返回给谁了?认证管理器

	}

	// ** 执行授权操作时,此方法用于获取用户的权限信息 *//
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("doGetAuthorizationInfo");
		// 1.获取用户的id(基于此id逐步获取用户具备的权限)
		SysUser user = (SysUser) principals.getPrimaryPrincipal();
		int roleid = sysUserDao.findRoleIdsByUserName(user.getNumber());
		System.out.println("roleid" + roleid);
		SysRole name = sysRoleDao.findRoleByRoleId(roleid);

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addObjectPermission((Permission) name);
		return info;
	}

}
