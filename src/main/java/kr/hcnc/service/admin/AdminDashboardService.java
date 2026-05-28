package kr.hcnc.service.admin;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("adminDashboardService")
public class AdminDashboardService extends EgovAbstractServiceImpl {

	private static final Logger log = LoggerFactory.getLogger(AdminDashboardService.class);
	
	public Map<String, Object> selectDashboard() {
		log.info("selectDashboard");
		return new HashMap<>();
	}
}
