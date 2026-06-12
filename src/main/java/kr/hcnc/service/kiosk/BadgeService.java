package kr.hcnc.service.kiosk;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.kiosk.BadgeMapper;
import kr.hcnc.service.admin.AdminAttendanceService;
import kr.hcnc.service.admin.AdminKioskLogService;
import kr.hcnc.service.admin.AdminKioskOperationalLogService;
import kr.hcnc.validator.StudentValidator;
import kr.hcnc.vo.AttendVO;
import kr.hcnc.vo.KioskLogVO;
import kr.hcnc.vo.KioskOperationalLogVO;
import kr.hcnc.vo.StudentSearchVO;

@Service("badgeService")
public class BadgeService extends EgovAbstractServiceImpl {

	@Resource(name = "badgeMapper")
	private BadgeMapper badgeMapper;
	
	@Resource(name = "adminAttendanceService")
	private AdminAttendanceService attendService;
	
	@Resource(name = "adminKioskLogService")
	private AdminKioskLogService logService;
	
	@Resource(name = "adminKioskOperationalLogService")
	private AdminKioskOperationalLogService operService;
	
	private static final Logger log = LoggerFactory.getLogger(BadgeService.class);
	
	public List<Map<String, Object>> selectStudents(StudentSearchVO searchVO) {
		log.info("Called :: selectStudents()");
		
		if(!StudentValidator.isValidSearchVO(searchVO) || !StudentValidator.isValidBirthDate(searchVO.getBirthDate()))
			return new ArrayList<>();
		
		List<Map<String, Object>> result = badgeMapper.selectStudents(searchVO);
		log.info("result = {}", result);
		
		return result;
	}
	
	public Map<String, Object> selectStudentDetail(StudentSearchVO searchVO) {
		log.info("Called :: selectStudentDetail()");
		
		if(!StudentValidator.isValidSearchVO(searchVO) || !StudentValidator.isValidStudentId(searchVO.getStudentId())) 
			return new HashMap<>();
		
		Map<String, Object> result = badgeMapper.selectStudentDetail(searchVO);
		log.info("result = {}", result);
		
		List<Map<String, Object>> subject = badgeMapper.selectTodaySubject(searchVO);
		result.put("subject", subject);
		return result;
	}
	
	@Transactional
	public Map<String, Object> updateStudentStatus(StudentSearchVO searchVO) {
		log.info("BadgeService :: updateStudentStatus()");
		Map<String, Object> result = new HashMap<>();
		
		try {
			// SearchVO, StudentId 유효성 검사
			if(!StudentValidator.isValidSearchVO(searchVO) || !StudentValidator.isValidStudentId(searchVO.getStudentId())) {
				result.put("status", "fail");
				result.put("message", "잘못된 요청입니다.");
				return result;
			}
			
			Map<String, Object> student = badgeMapper.selectStudentStatus(searchVO);
			log.info("student status : {}", student);
			if(student == null) {
				result.put("status", "fail");
				result.put("message", "교육생 정보를 찾을 수 없습니다.");
				return result;
			}
			
			String attendYn = (String) student.get("ATTEND_YN");
			String dormYn = (String) student.get("DORM_YN");
			
			int todayCount = badgeMapper.selectTodayAttendance(searchVO);
			if(todayCount > 0) {
				KioskLogVO reLogVO = new KioskLogVO();
				reLogVO.setAction("명찰 재발급");
				logService.insertLog(reLogVO);
				
				result.put("status", "already");
				result.put("message", "이미 출석 처리된 교육생입니다.");
				return result;
			}
			
			// 교육 기간 유효성 검사
	        Map<String, Object> eduInfo = badgeMapper.selectStudentEduInfo(searchVO);
	        if (eduInfo != null) {
	            String startDate = (String) eduInfo.get("START_DATE");
	            String endDate   = (String) eduInfo.get("END_DATE");
	            String today     = new SimpleDateFormat("yyMMdd").format(new java.util.Date());

	            if (today.compareTo(startDate) < 0) {
	                result.put("status", "fail");
	                result.put("message", "교육 시작 전입니다.\n교육 시작일 : 20" + startDate);
	                return result;
	            }
	            if (today.compareTo(endDate) > 0) {
	                result.put("status", "fail");
	                result.put("message", "교육이 종료된 교육생입니다.\n교육 종료일 : 20" + endDate);
	                return result;
	            }
	        }
	        
	        // 첫 출석 처리 (생활관 배정 + ATTEND_YN 세팅)
	        if ("N".equals(attendYn)) {
	            if ("Y".equals(dormYn)) {
	                Map<String, Object> dorm = badgeMapper.selectDormitoryInfo(searchVO);
	                int currentCount = (int) dorm.get("CURRENT_COUNT");
	                int maxCount     = (int) dorm.get("MAX_COUNT");

	                if (currentCount >= maxCount) {
	                    Map<String, Object> available = badgeMapper.selectAvailableDormitory();
	                    if (available == null) {
	                        result.put("status", "fail");
	                        result.put("message", "배정 가능한 생활관이 없습니다.");
	                        return result;
	                    }
	                    searchVO.setDormitoryId((String) available.get("DORMITORY_ID"));
	                    badgeMapper.updateStudentDormitory(searchVO);
	                    result.put("autoAssigned", "Y");
	                }
	                badgeMapper.updateDormitoryCount(searchVO);
	            }
	            badgeMapper.updateAttendYN(searchVO);
	        }
			
	        // 일일 출석 기록
	        AttendVO attendVO = new AttendVO();
	        attendVO.setStudentId(searchVO.getStudentId());
	        attendVO.setAttendDate(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
	        attendVO.setStatus("출석");
	        attendService.insertAttend(attendVO);

	        // 키오스크 로그
	        KioskLogVO kioskLogVO = new KioskLogVO();
	        kioskLogVO.setAction("명찰 발급");
	        logService.insertLog(kioskLogVO);

	        // 운영 로그
	        KioskOperationalLogVO opLogVO = new KioskOperationalLogVO();
	        opLogVO.setStudentId(searchVO.getStudentId());
	        opLogVO.setPrinting("Y");
	        opLogVO.setDorm("Y".equals(dormYn) ? "IN" : null);
	        operService.insertOpLog(opLogVO);

	        result.put("status", "success");
	        result.put("dormAssigned", "O");
		}
		catch(Exception e) {
	        log.error("BadgeService :: updateStudentStatus() 오류 : {}", e);
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        result.put("status", "fail");
	        result.put("message", "처리 중 오류가 발생했습니다.\n잠시 후 다시 시도해주세요.");
		}

		return result;
	}
}
