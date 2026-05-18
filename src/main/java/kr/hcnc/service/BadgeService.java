package kr.hcnc.service;

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
	public void updateStudentStatus(StudentSearchVO searchVO) {
		System.out.println("BadgeService :: updateStudentStatus()");
		
		badgeMapper.updateAttendYN(searchVO);
		badgeMapper.updateDormitoryCount(searchVO);
	}
	
}
