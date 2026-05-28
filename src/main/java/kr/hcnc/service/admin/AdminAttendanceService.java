package kr.hcnc.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("adminAttendanceService")
public class AdminAttendanceService extends EgovAbstractServiceImpl {

	private static final Logger log = LoggerFactory.getLogger(AdminAttendanceService.class);
	
	public List<Map<String, Object>> selectAttendances(String date) {
		log.info("selectAttendances date = {}", date);
		return new ArrayList<>();
	}
}
