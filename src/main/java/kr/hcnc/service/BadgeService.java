package kr.hcnc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.BadgeMapper;
import kr.hcnc.vo.StudentSearchVO;

@Service("badgeService")
public class BadgeService extends EgovAbstractServiceImpl {

	@Resource(name = "badgeMapper")
	private BadgeMapper badgeMapper;
	
	public List<Map<String, Object>> selectStudents(StudentSearchVO searchVO) {
		System.out.println("BadgeService :: selectStudents()");
		
		List<Map<String, Object>> result = badgeMapper.selectStudents(searchVO);
		System.out.println("selectStudents() :: result = " + result);
		
		return result;
	}
	
	public Map<String, Object> selectStudentDetail(StudentSearchVO searchVO) {
		System.out.println("BadgeService :: selectStudentDetail()");
		
		Map<String, Object> result = badgeMapper.selectStudentDetail(searchVO);
		System.out.println("selectStudentDetail() :: result = " + result);
		
		return result;
	}
	
	@Transactional
	public Map<String, Object> updateStudentStatus(StudentSearchVO searchVO) {
		System.out.println("BadgeService :: updateStudentStatus()");
		
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> student = badgeMapper.selectStudentStatus(searchVO);
		System.out.println("student status : " + student);
		
		String attendYn = (String) student.get("ATTEND_YN");

	    System.out.println("attendYn : " + attendYn);
		if("Y".equals(attendYn)) {
			result.put("status", "fail");
			result.put("message", "이미 출석 처리된 교육생입니다.");
			return result;
		}
		
		String dormYn = (String) student.get("DORM_YN");
		if("Y".equals(dormYn)) {
			Map<String, Object> dorm = badgeMapper.selectDormitoryInfo(searchVO);
			int currentCount = (int) dorm.get("CURRENT_COUNT");
			int maxCount = (int) dorm.get("MAX_COUNT");
			
			if(currentCount >= maxCount) {
				result.put("status", "fail");
				result.put("message", "생활관이 만실입니다.");
				return result;
			}
		}
		
		badgeMapper.updateAttendYN(searchVO);
		
		if("Y".equals(dormYn)) {
			badgeMapper.updateDormitoryCount(searchVO);
		}
		
		result.put("status", "success");
		return result;
	}
	
}
