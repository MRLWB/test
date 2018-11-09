package com.jx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jx.dao.SysUserEvaMessageDao;
import com.jx.exception.ServiceException;
import com.jx.pojo.SysUserEvaMessage;
import com.jx.service.SysUserEvaMessageService;
@Service
public class SysUserEvaMessageServiceImpl implements SysUserEvaMessageService {
    //关联对象
	@Autowired
	private SysUserEvaMessageDao sysUserEvaMessageDao;
	@Override
	public List<SysUserEvaMessage> findUserEvaMassege(Integer nunm) {
		//验证合理性
		if(nunm == null||nunm==0)
			throw new IllegalArgumentException("课程编号输入有误");
		//获取数据
		List<SysUserEvaMessage> list = 
				sysUserEvaMessageDao.findUserEvaMassege(nunm);
		if(list == null)
			throw new ServiceException("此课程不存在");
		return list;
	}

}
