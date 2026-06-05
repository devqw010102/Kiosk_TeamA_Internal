package kr.hcnc.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.admin.AdminClassroomMapper;
import kr.hcnc.vo.ClassroomVO;

@Service("adminClassroomService")
public class AdminClassroomService extends EgovAbstractServiceImpl {

	@Resource(name = "adminClassroomMapper")
	private AdminClassroomMapper adminClassroomMapper;
	
	private static final Logger log = LoggerFactory.getLogger(AdminClassroomService.class);
	
	public List<ClassroomVO> selectClassroom() {
		log.info("selectClassroom");
		return adminClassroomMapper.selectClassroom();
	}
	
	public ClassroomVO selectClassroomById(String classroomId) {
		log.info("selectClassroomById");
		return adminClassroomMapper.selectClassroomById(classroomId);
	}
	
	public int insertClassroom(ClassroomVO classroomVO) {
		log.info("insertClassroom");
		return adminClassroomMapper.insertClassroom(classroomVO);
	}
	
	public int updateClassroom(ClassroomVO classroomVO) {
		log.info("updateClassroom");
		return adminClassroomMapper.updateClassroom(classroomVO);
	}
	
	public int deleteClassroom(String classroomId) {
		log.info("deleteClassroom");
		return adminClassroomMapper.deleteClassroom(classroomId);
	}
}
