package kr.hcnc.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.admin.AdminDormitoryMapper;
import kr.hcnc.mapper.admin.AdminKioskOperationalLogMapper;
import kr.hcnc.vo.DormAssignVO;
import kr.hcnc.vo.DormInOutVO;
import kr.hcnc.vo.DormitoryVO;
import kr.hcnc.vo.KioskOperationalLogVO;

@Service("adminDormitoryService")
public class AdminDormitoryService extends EgovAbstractServiceImpl {

	private static final Logger log = LoggerFactory.getLogger(AdminDormitoryService.class);
	
	@Resource(name = "adminDormitoryMapper")
	private AdminDormitoryMapper adminDormitoryMapper;
	
	@Resource(name = "adminKioskOperationalMapper")
	private AdminKioskOperationalLogMapper adminKioskOperationalLogMapper;
	
	public List<DormitoryVO> selectCmbDorm() {
		log.info("Called :: selectCmbDorm()");
		return adminDormitoryMapper.selectCmbDorm();
	}
	
	public List<DormAssignVO> selectDormAssign() {
		log.info("Called :: selectDormAssign()");
		return adminDormitoryMapper.selectDormAssign();
	}
	
	public List<DormInOutVO> selectDormIn() {
		log.info("Called :: selectDormIn()");
		return adminDormitoryMapper.selectDormIn();
	}
	
	public List<DormInOutVO> selectDormOut() {
		log.info("Called :: selectDormOut()");
		return adminDormitoryMapper.selectDormOut();
	}
	
	public List<DormitoryVO> selectDormRoomAssignStatus() {
		log.info("Called :: selectDormAssignStatus()");
		return adminDormitoryMapper.selectDormRoomAssignStatus();
	}
	
	public DormitoryVO selectDormRoomAssignStatusById(String dormitoryId) {
		log.info("Called :: selectDormAssignStatusById");
		return adminDormitoryMapper.selectDormRoomAssignStatusById(dormitoryId);
	}
	
	@Transactional
	public int updateDormId(String studentId, DormAssignVO dormAssignVO) {
		log.info("Called :: updateDormId");
		dormAssignVO.setStudentId(studentId);
		return adminDormitoryMapper.updateDormId(dormAssignVO);
	}
	
	public int updateDormAssignMaxCnt(DormitoryVO dormitoryVO) {
		log.info("Called :: updateDormAssignMaxCnt");
		return adminDormitoryMapper.updateDormAssignMaxCnt(dormitoryVO);
	}
	
	@Transactional
	public int updateDormCurrentCnt(DormitoryVO dormitoryVO, String studentId) {
		log.info("Called :: updateDormCurrentCnt");
		int result = adminDormitoryMapper.updateDormCurrentCnt(dormitoryVO);
		KioskOperationalLogVO logVO = new KioskOperationalLogVO();
		logVO.setStudentId(studentId);
		logVO.setDorm("IN");
		logVO.setPrinting("Y");
		adminKioskOperationalLogMapper.insertOpLog(logVO);
		return result;
	}
	
	@Transactional
	public int updateDormCurrentCntDown(DormitoryVO dormitoryVO, String studentId) {
		log.info("Called :: updateDormCurrentCntDown");
		int result = adminDormitoryMapper.updateDormCurrentCntDown(dormitoryVO);
		KioskOperationalLogVO logVO = new KioskOperationalLogVO();
		logVO.setStudentId(studentId);
		logVO.setDorm("OUT");
		logVO.setPrinting("Y");
		adminKioskOperationalLogMapper.insertDormOutLog(logVO);
		return result;
	}
}
