package kr.hcnc.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("adminDormitoryService")
public class AdminDormitoryService extends EgovAbstractServiceImpl {

	private static final Logger log = LoggerFactory.getLogger(AdminDormitoryService.class);
	
	public List<Map<String, Object>> selectDormitories() {
		log.info("selectDormitories");
		return new ArrayList<>();
	}
}
