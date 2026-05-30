package kr.hcnc.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.admin.AdminDormitoryMapper;
import kr.hcnc.vo.DormitoryVO;

@Service("adminDormitoryService")
public class AdminDormitoryService extends EgovAbstractServiceImpl {

	private static final Logger log = LoggerFactory.getLogger(AdminDormitoryService.class);
	@Resource(name = "adminDormitoryMapper")
	private AdminDormitoryMapper adminDormitoryMapper;
	
//	public List<Map<String, Object>> selectDormitories() {
//		log.info("selectDormitories");
//		return new ArrayList<>();
//	}
	
	public List<DormitoryVO> selectDormRoomAssignStatus() {
		log.info("Called :: selectDormAssignStatus()");
		return adminDormitoryMapper.selectDormRoomAssignStatus();
	}
	
	public DormitoryVO selectDormRoomAssignStatusById(String dormitoryId) {
		log.info("Called :: selectDormAssignStatusById");
		return adminDormitoryMapper.selectDormRoomAssignStatusById(dormitoryId);
	}
	
	public int updateDormAssignMaxCnt(DormitoryVO dormitoryVO) {
		log.info("Called :: updateDormAssignMaxCnt");
		return adminDormitoryMapper.updateDormAssignMaxCnt(dormitoryVO);
	}
	
	public int updateDormCurrentCnt(DormitoryVO dormitoryVO) {
		log.info("Called :: updateDormCurrentCnt");
		return adminDormitoryMapper.updateDormCurrentCnt(dormitoryVO);
	}
	
	public int updateDormCurrentCntDown(DormitoryVO dormitoryVO) {
		log.info("Called :: updateDormCurrentCnt");
		return adminDormitoryMapper.updateDormCurrentCntDown(dormitoryVO);
	}
}
