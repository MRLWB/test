package com.jx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jx.dao.SysClassDao;
import com.jx.dao.SysCourseDao;
import com.jx.dao.SysCourseUserDao;
import com.jx.dao.SysDeptDao;
import com.jx.dao.SysGardeDao;
import com.jx.dao.SysHourDao;
import com.jx.dao.SysHourMenuDao;
import com.jx.dao.SysProDao;
import com.jx.dao.SysTXDao;
import com.jx.dao.SysUserDao;
import com.jx.exception.ServiceException;
import com.jx.pojo.SysCourse;
import com.jx.pojo.SysGarde;
import com.jx.pojo.SysHour;
import com.jx.pojo.SysUser;
import com.jx.vo.CourseGuideVO;
import com.jx.vo.CourseTeacherVO;
import com.jx.vo.CourseVO;
import com.jx.vo.PageVO;
import com.jx.service.SysCourseService;
import com.jx.pojo.SysClass;

@Service
public class SysCourseServiceImpl implements SysCourseService{

	@Autowired
	private SysCourseDao sysCourseDao;

	@Autowired
	private SysGardeDao sysGardeDao;

	@Autowired
	private SysTXDao sysTXDao;
	
	@Autowired
	private SysDeptDao sysDeptDao;
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired 
	private SysCourseUserDao sysCourseUserDao;
	
	@Autowired
    private SysClassDao sysClassDao;
	
	@Autowired
	private SysHourMenuDao sysHourMenuDao;
	
	@Autowired
	private SysProDao sysproDao;
	
	@Autowired
	private SysHourDao sysHourDao;
	
	@Override
	public List<CourseVO> findCourse(int userId) {
		if(userId<1){
			throw new ServiceException("用户id错误!");
		}


		List<CourseVO> cvoList = new ArrayList<CourseVO>();
		List<SysGarde> sgList = sysGardeDao.findCourseNumByUserId(userId);

		if(sgList==null){
			throw new ServiceException("成绩数据发生错误");
		}
		List<Integer> courseNum = new ArrayList<Integer>();
		
		for(SysGarde sg : sgList){
			courseNum.add(sg.getCourse_num());
		}
		
 		List<SysCourse> scList =  sysCourseDao.findAll(courseNum);
 		
 		if(scList==null){
 			throw new ServiceException("课程数据发生错误!");
 		}
		
		for(SysCourse sc : scList){
			CourseVO cvo = new CourseVO();
			cvo.setId(sc.getId());
			cvo.setNunm(sc.getNunm());
			cvo.setName(sc.getName());
			cvo.setNote(sc.getNote());
			cvo.setGoal(sc.getGoal());
			cvo.setWay(sc.getWay());
			cvo.setGrade(sysGardeDao.findById(userId,sc.getNunm()));
			cvo.setTx(sysTXDao.findById(sc.getTx_id()));
			cvoList.add(cvo);
		}

		return cvoList;
	}

	@Override
	public List<CourseGuideVO> findCourseGuide(int userId) {
		if(userId<1){
			throw new ServiceException("用户id错误!");
		}
		
		List<CourseGuideVO> cgvoList = new ArrayList<CourseGuideVO>();
		List<SysGarde> sgList = sysGardeDao.findCourseNumByUserId(userId);

		if(sgList==null){
			throw new ServiceException("成绩数据发生错误");
		}
		List<Integer> courseNum = new ArrayList<Integer>();
		
		for(SysGarde sg : sgList){
			courseNum.add(sg.getCourse_num());
		}
		
 		List<SysCourse> scList =  sysCourseDao.findAll(courseNum);
 		
 		if(scList==null){
 			throw new ServiceException("课程数据发生错误!");
 		}
		
 		for(SysCourse sc : scList){
 			CourseGuideVO cgvo = new CourseGuideVO();
 			cgvo.setNunm(sc.getNunm());
 			cgvo.setStart_time(sc.getStart_time());
 			cgvo.setId(sc.getId());
 			cgvo.setTx(sysTXDao.findById(sc.getTx_id()));
 			cgvo.setPeriod(sc.getPeriod());
 			cgvo.setDeptname(sysDeptDao.findById(sc.getDept_id()));
 			cgvo.setGoal(sc.getGoal());
 			cgvo.setName(sc.getName());
 			cgvo.setWay(sc.getWay());

 			cgvoList.add(cgvo);
 		}

		return cgvoList;
	}

	@Override
	public PageVO<CourseTeacherVO> findCourseTeacher(String courseName,int pageCurrent) {
		if(courseName==null || courseName.trim()==""){
			throw new ServiceException("请输入课程名称");
		}
		SysCourse sysCourse = sysCourseDao.findByCouserName(courseName);
		
		if (pageCurrent<1){
			throw new ServiceException("页码错误"); 
		}
		
		if(sysCourse==null){
			throw new ServiceException("没有这个课程");
		}
		
		String deptName = sysDeptDao.findById(sysCourse.getDept_id());
		
		List<Integer> list = sysCourseUserDao.findByIds(sysCourse.getId());
		
		if(list.size()==0){
			throw new ServiceException("此课程还没有分配老师");
		}
		int pageSize = 1;
		int startIndex = (pageCurrent-1) * pageSize;
		List<SysUser> userList = sysUserDao.findByIds(list,startIndex,pageSize);
		if(userList.size()==0){
			throw new ServiceException("数据发生错误");
		}
		
		
		List<CourseTeacherVO> CourseTeacherVOList = new ArrayList<CourseTeacherVO>();
		CourseTeacherVO ctvo = new CourseTeacherVO();
		ctvo.setCourseName(courseName);
		ctvo.setDeptName(deptName);
		ctvo.setNote(sysCourse.getNote());
		
		for(SysUser su : userList){
			ctvo.setTeacherName(su.getUserName());
			ctvo.setPhone(su.getMobile());
			ctvo.setEmail(su.getEmail());
			CourseTeacherVOList.add(ctvo);
		}
		
		PageVO<CourseTeacherVO> pvo = new PageVO<CourseTeacherVO>();
		pvo.setPageSize(1);
		pvo.setRecords(CourseTeacherVOList);
		pvo.setRowCount(userList.size());
		pvo.setPageCurrent(pageCurrent);
		
		return pvo;
	}

	
	@Override
	public List<SysHour> findHourCourse(int userId) {
		if(userId<1){
			throw new ServiceException("用户id错误!");
		}

		SysClass sysClass = sysClassDao.findClassByUserId(userId);
		List<Integer> courseIds = sysHourMenuDao.findCourseIdByProIds(sysClass.getPro_id());
		List<SysCourse> sysCourseList = sysCourseDao.findCourseByCourseId(courseIds);
		List<SysHour> sysHourList = sysHourDao.findAllByCourseId(courseIds);
		
		for(SysCourse sc : sysCourseList){
			for(SysHour sh : sysHourList){
				if(sc.getId() == sh.getCourse_id()){
					sh.setName(sc.getName());
				}
			}
		}

		return sysHourList;
	}

}
