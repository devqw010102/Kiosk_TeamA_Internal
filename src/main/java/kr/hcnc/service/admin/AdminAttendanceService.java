package kr.hcnc.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.admin.AdminAttendancesMapper;
import kr.hcnc.vo.AttendVO;

@Service("adminAttendanceService")
public class AdminAttendanceService extends EgovAbstractServiceImpl {
	@Resource(name = "adminAttendancesMapper")
	private AdminAttendancesMapper adminAttendancesMapper;
	
	private static final Logger log = LoggerFactory.getLogger(AdminAttendanceService.class);
	
//	public List<Map<String, Object>> selectAttendances(String date) {
//		log.info("selectAttendances date = {}", date);
//		return new ArrayList<>();
//	}
	
	public List<AttendVO> selectAttendance(AttendVO attendVO) {
		log.info("studentId = {}", attendVO.getStudentId());
		return adminAttendancesMapper.selectAttend(attendVO);
	}
	
	public int updateAttendMsg(AttendVO attendVO) {
		log.info("Called::updateAttendMsg()");
		int result = adminAttendancesMapper.updateAttendMsg(attendVO);
		return result;
	}
}
