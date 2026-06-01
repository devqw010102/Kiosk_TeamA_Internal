package kr.hcnc.service.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.hcnc.mapper.admin.AdminKioskOperationalLogMapper;
import kr.hcnc.vo.KioskOperationalLogVO;

@Service("adminKioskOperationalLogService")
public class AdminKioskOperationalLogService {
	private static final Logger log = LoggerFactory.getLogger(AdminKioskOperationalLogService.class);
	
	@Resource(name = "adminKioskOperationalMapper")
	private AdminKioskOperationalLogMapper adminKioskOperationalMapper;
	
	public List<KioskOperationalLogVO> selectOpLog (KioskOperationalLogVO kioskOpVO) {
		log.info("Called::selectOpLog");
		return adminKioskOperationalMapper.selectOpLog(kioskOpVO);
	}
	
	@Transactional
	public int insertOpLog(KioskOperationalLogVO kioskOpVO) {
		log.info("Called::insertOpLog");
		return adminKioskOperationalMapper.insertOpLog(kioskOpVO);
	}
	
	@Transactional
	public int insertDormOutLog(KioskOperationalLogVO kioskOpVO) {
		log.info("Called::insertDormOutLog");
		return adminKioskOperationalMapper.insertDormOutLog(kioskOpVO);
	}
	
	@Transactional
	public int deleteOpLog(KioskOperationalLogVO kioskOpVO) {
		log.info("Called::deleteOpLog");
		return adminKioskOperationalMapper.deleteOpLog(kioskOpVO);
	}
}
