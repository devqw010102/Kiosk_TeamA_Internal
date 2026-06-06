package kr.hcnc.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import kr.hcnc.mapper.admin.AdminStudentMapper;
import kr.hcnc.vo.StudentVO;

@Service("adminStudentService")
public class AdminStudentService extends EgovAbstractServiceImpl {

	@Resource(name = "adminStudentMapper")
	private AdminStudentMapper adminStudentMapper;
	
	@Resource(name = "studentIdGnService")
	private EgovIdGnrService studentIdGnService;
	
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
		try {
			studentVO.setStudentId(studentIdGnService.getNextStringId());
		}
		catch(FdlException e) {
			log.error("STUDENT ID 채번 실패", e);
			throw new RuntimeException("ID 생성에 실패했습니다.");
		}
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
	
	@Transactional
	public int batchInsertStudent(List<StudentVO> students) {
		log.info("batchInsertStudent");
		for(StudentVO student : students) {
			try {
				student.setStudentId(studentIdGnService.getNextStringId());
			}
			catch(FdlException e) {
				log.error("STUDENT ID 채벌 실패", e);
				throw new RuntimeException("ID 생성에  실패했습니다.");
			}
			adminStudentMapper.insertStudent(student);
		}
		return students.size();
	}
}
