package kr.hcnc.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.AdminAttendancesMapper;
import kr.hcnc.vo.AttendSearchVO;

@Service("adminAttendanceService")
public class AdminAttendanceService extends EgovAbstractServiceImpl {
	@Resource(name = "adminAttendancesMapper")
	private AdminAttendancesMapper adminAttendancesMapper;
	
	private static final Logger log = LoggerFactory.getLogger(AdminAttendanceService.class);
	
	public List<Map<String, Object>> selectAttendances(String date) {
		log.info("selectAttendances date = {}", date);
		return new ArrayList<>();
	}
	
	public List<Map<String, Object>> selectAttendance(AttendSearchVO attendSearchVO) {
		log.info("studentId = {}", attendSearchVO.getStudentId());
		return adminAttendancesMapper.selectAttend(attendSearchVO);
	}
}
