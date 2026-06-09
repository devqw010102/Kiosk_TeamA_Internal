package kr.hcnc.service.admin.dashBoard;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.admin.AdminDashBoardMapper;

@Service("adminDashBoardService")
public class AdminDashBoardService extends EgovAbstractServiceImpl{
	
	private static final Logger log = LoggerFactory.getLogger(AdminDashBoardService.class);
    
	@Resource(name="adminDashBoardMapper")
	private AdminDashBoardMapper adminDashBoardMapper;
	public List<Map<String, Object>> selectLogTo10() {
		log.info("Call::selectLog()");
		return adminDashBoardMapper.selectLogTop10();
	}
	public List<Map<String, Object>> selectPrintCountByHour() {
		log.info("Call::selectPrintCountByHour()");
		return adminDashBoardMapper.selectPrintCountByHour(); 
	}
	
	public List<Map<String, Object>> selectPopularFeature() {
		log.info("Call::selectPopulerFeature()");
		return adminDashBoardMapper.selectPopularFeature();
	}
	
	public Map<String, Object> selectAttendCount() {
		log.info("Call::selectAttendCount()");
		return adminDashBoardMapper.selectAttendCount();
	}
	
	public Map<String, Object> selectDormStats() {
		log.info("Call::selectDormStats()");
		return adminDashBoardMapper.selectDormStats();
	}
	
	public Map<String, Object> selectEduStats() {
		log.info("Call :: selectEduStats()");
		return adminDashBoardMapper.selectEduStats();
	}
}


