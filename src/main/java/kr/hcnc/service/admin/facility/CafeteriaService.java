package kr.hcnc.service.admin.facility;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.facility.CafeteriaMapper;

@Service("cafeteriaService")
public class CafeteriaService  extends EgovAbstractServiceImpl{
	
	@Resource(name = "cafeteriaMapper")
	private CafeteriaMapper  cafeteriaMapper;
	
	private static final Logger log = LoggerFactory.getLogger(CafeteriaService.class);
	
	// 구내식당 
	public List<Map<String, Object>> selectCafeteriaList() {
		log.info("Called :: selectCafeteriaList");
		return cafeteriaMapper.selectCafeteriaList();
	}
}
