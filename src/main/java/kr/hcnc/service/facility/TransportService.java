package kr.hcnc.service.facility;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.facility.TransportMapper;

@Service("transportService")
public class TransportService  extends EgovAbstractServiceImpl{
	
	@Resource(name = "transportMapper")
	private TransportMapper  transportMapper;
	
	private static final Logger log = LoggerFactory.getLogger(TransportService.class);
	
	// 교통 정보
	public List<Map<String, Object>> selectTransportList() {
		log.info("Called :: selectTransportList");
		return transportMapper.selectTransportList();
	}
}
