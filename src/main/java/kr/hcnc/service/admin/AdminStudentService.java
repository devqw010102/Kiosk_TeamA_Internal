package kr.hcnc.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.admin.AdminStudentMapper;
import kr.hcnc.vo.StudentVO;

@Service("adminStudentService")
public class AdminStudentService extends EgovAbstractServiceImpl {

	@Resource(name = "adminStudentMapper")
	private AdminStudentMapper adminStudentMapper;
	
	private static final Logger log = LoggerFactory.getLogger(AdminStudentService.class);
	
	public List<StudentVO> selectStudent() {
		log.info("selectStudent");
		return adminStudentMapper.selectStudent();
	}
	
	public StudentVO selectStudentById(String studentId) {
		log.info("selectStudentById");
		return adminStudentMapper.selectStudentById(studentId);
	}
	
	public int insertStudent(StudentVO studentVO) {
		log.info("insertStudent");
		return adminStudentMapper.insertStudent(studentVO);
	}
	
	public int updateStudent(StudentVO studentVO) {
		log.info("updateStudent");
		return adminStudentMapper.updateStudent(studentVO);
	}
	
	public int deleteStudent(String studentId) {
		log.info("deleteStudent");
		return adminStudentMapper.deleteStudent(studentId);
	}
}
