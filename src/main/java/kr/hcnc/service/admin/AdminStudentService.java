package kr.hcnc.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("adminStudentService")
public class AdminStudentService extends EgovAbstractServiceImpl {

	private static final Logger log = LoggerFactory.getLogger(AdminStudentService.class);
	
	public List<Map<String, Object>> selectStudents() {
		log.info("selectStudents");
		return new ArrayList<>();
	}
}
