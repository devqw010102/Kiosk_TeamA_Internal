package kr.hcnc.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("adminClassroomService")
public class AdminClassroomService extends EgovAbstractServiceImpl {

	private static final Logger log = LoggerFactory.getLogger(AdminClassroomService.class);
	
	public List<Map<String, Object>> selectClassrooms() {
		log.info("selectClassrooms");
		return new ArrayList<>();
	}
}
