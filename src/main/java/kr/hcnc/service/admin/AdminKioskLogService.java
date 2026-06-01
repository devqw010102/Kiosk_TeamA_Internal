package kr.hcnc.service.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.admin.AdminKioskLogMapper;
import kr.hcnc.vo.KioskLogVO;
@Service("adminKioskLogService")
public class AdminKioskLogService extends EgovAbstractServiceImpl{
	@Resource(name = "adminKioskLogMapper")
	private AdminKioskLogMapper adminKioskLogMapper; 
	
	private static final Logger log = LoggerFactory.getLogger(AdminKioskLogService.class);
	
	public List<KioskLogVO> selectKioskLog(KioskLogVO kioskLogVO) {
		log.info("Called::selectKioskLog");
		return adminKioskLogMapper.selectKioskLog(kioskLogVO);
	}
	
	@Transactional
	public int insertLog(KioskLogVO kioskLogVO) {
		log.info("Called::insertLog()");
		return adminKioskLogMapper.insertLog(kioskLogVO);
	}
	
	@Transactional
	public int deleteLog(KioskLogVO kioskLogVO) {
		log.info("Called::deleteLog()");
		return adminKioskLogMapper.deleteLog(kioskLogVO);
	}
}
