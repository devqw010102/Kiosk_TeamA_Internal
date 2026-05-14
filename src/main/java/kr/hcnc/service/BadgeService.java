package kr.hcnc.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.BadgeMapper;

@Service("badgeService")
public class BadgeService extends EgovAbstractServiceImpl {

	@Resource(name = "badgeMapper")
	private BadgeMapper badgeMapper;
	
	public String selectCount() {
		System.out.println("BadgeService :: selectCount()");
		
		String result = badgeMapper.selectCount();
		System.out.println("BadgeService :: result = " + result);
		return result;
	}
	
	public List<Map<String, Object>> selectStudents(String param) {
		System.out.println("BadgeService :: selectStudents()");
		
		List<Map<String, Object>> result = badgeMapper.selectStudents(param);
		System.out.println("BadgeService :: result = " + result);
		
		return result;
	}
}
