package kr.hcnc.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("adminCafeteriaService")
public class AdminCafeteriaService extends EgovAbstractServiceImpl {
	
	private static final Logger log = LoggerFactory.getLogger(AdminCafeteriaService.class);
	
	public List<Map<String, Object>> selectCafeteria(String date) {
		log.info("selectCafeteria date = {}", date);
		return new ArrayList<>();
	}
}
