package com.jx.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.jx.dao.SysUserDao;
/*import com.jx.dao.SysUserGradeListDao;
import com.jx.dao.SysUserMessageDao;
import com.jx.dao.SysUserMessageManageDao;*/
import com.jx.exception.ServiceException;
import com.jx.pojo.SysGradeList;
import com.jx.pojo.SysUser;
import com.jx.pojo.SysUserMessage;
import com.jx.service.SysUserMessageService;

@Service
public class SysUserMessageServiceImpl implements SysUserMessageService {

	/*
	 * @Autowired private SysUserMessageDao sysUserMessageDao;
	 * 
	 * @Autowired private SysUserMessageManageDao sysUserMessageManage;
	 * 
	 * @Autowired private SysUserGradeListDao sysUserGradeListDao;
	 */

	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public SysUserMessage findObject(Integer userId) {
		// 1 验证合法性
		System.out.println(userId);
		if (userId == null || userId < 0)
			throw new IllegalArgumentException("获取用户id失败");
		// 2 查询数据
		SysUserMessage user = sysUserDao.findObject(userId);
		if (user == null) {
			System.out.println("用户：");
			throw new ServiceException("用户信息可能不存在");
		}
		// 3 返回结果

		return user;
	}

	@Transactional
	@Override
	public int updateUserMessage(SysUser entity) {
		// 1、验证数据合法性
		if (entity == null)
			throw new IllegalArgumentException("请填写用户信息");
		if (StringUtils.isEmpty(entity.getPassWord())) {
			throw new ServiceException("密码不能为空");
		} else {
			String salt = UUID.randomUUID().toString();
			String pwd = entity.getPassWord();
			// 2.3 对密码进行加密,加密算法md5
			SimpleHash sh = // 这个api属于shiro框架,后续需要引入shiro依赖
					new SimpleHash("MD5", // algorithmName 表示加密算法
							pwd, // source 为要加密的对象
							salt);// salt 加密盐

			entity.setSalt(salt);
			entity.setPassWord(sh.toString());
		}
		// 2、更新数据
		int rows = sysUserDao.updateMessage(entity);

		// 3、返回结果
		return rows;
	}

	@Override
	public SysUser findSysUser(Integer id) {
		// 1 验证数据合法性
		if (id == null || id < 0)
			throw new ServiceException("用户id可能不存在");
		// 2 查询并获取用户信息
		SysUser user = sysUserDao.findSysUser(id);
		if (user == null)
			throw new ServiceException("用户可能不存在");

		return user;
	}

	@Override
	public List<SysGradeList> findUserGradeList(Integer user_id) {
		// 1验证数据合法性
		if (user_id == null || user_id < 0)
			throw new IllegalArgumentException("用户id不存在");
		// 2 查询获取数据
		List<SysGradeList> list = sysUserDao.findUserGradeList(user_id);
		if (list == null)
			throw new ServiceException("没有成绩");

		return list;
	}

}
