package kr.hcnc.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.admin.AdminAttendancesMapper;
import kr.hcnc.mapper.admin.AdminKioskOperationalLogMapper;
import kr.hcnc.vo.AttendVO;
import kr.hcnc.vo.KioskOperationalLogVO;

@Service("adminAttendanceService")
public class AdminAttendanceService extends EgovAbstractServiceImpl {
	@Resource(name = "adminAttendancesMapper")
	private AdminAttendancesMapper adminAttendancesMapper;
	
	@Resource(name = "adminKioskOperationalMapper")
	private AdminKioskOperationalLogMapper adminKioskOperationalLogMapper;
	
	private static final Logger log = LoggerFactory.getLogger(AdminAttendanceService.class);
	
	public List<AttendVO> selectAttendance(AttendVO attendVO) {
		log.info("studentId = {}", attendVO.getStudentId());
		return adminAttendancesMapper.selectAttend(attendVO);
	}
	
	@Transactional
	public int updateAttendMsg(AttendVO attendVO) {
		log.info("Called::updateAttendMsg()");
		int result = adminAttendancesMapper.updateAttendMsg(attendVO);
		KioskOperationalLogVO logVO = new KioskOperationalLogVO();
		logVO.setStudentId(attendVO.getStudentId());
		logVO.setPrinting(attendVO.getStatus().equals("결석") ? "N" : "Y");
		adminKioskOperationalLogMapper.insertOpLog(logVO);
		return result;
	}
	
	public int insertAttend(AttendVO attendVO) {
		log.info("Called :: insertAttend");
		return adminAttendancesMapper.insertAttend(attendVO);
	}
	
	public int deleteAttend(String attendId) {
		log.info("Called :: deleteAttend");
		return adminAttendancesMapper.deleteAttend(attendId);
	}
}
