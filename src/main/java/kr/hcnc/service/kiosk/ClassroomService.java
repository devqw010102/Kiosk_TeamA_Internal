package kr.hcnc.service.kiosk;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.kiosk.ClassroomMapper;
import kr.hcnc.vo.ClassroomVO;

@Service("classroomService")
public class ClassroomService extends EgovAbstractServiceImpl {
	
	@Resource(name = "classroomMapper")
	private ClassroomMapper classroomMapper;
	
	private static final Logger log = LoggerFactory.getLogger(ClassroomService.class);
	
	public List<ClassroomVO> selectClassroom() {
		log.info("Called :: selectClassroom()");
		return classroomMapper.selectClassroom();
	}
}
