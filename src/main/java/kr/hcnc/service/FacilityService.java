package kr.hcnc.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.FacilityMapper;

@Service("facilityService")
public class FacilityService extends EgovAbstractServiceImpl{
	
	@Resource(name = "facilityMapper")
	private FacilityMapper facilityMapper;
	
	private static final Logger log = LoggerFactory.getLogger(FacilityService.class);
	
	// 구내식당
	public List<Map<String, Object>> selectCafeteriaList() {
		log.info("Called :: selectCafeteriaList");
		return facilityMapper.selectCafeteriaList();
	}
	
	// 흡연장소
	public List<Map<String, Object>> selectSmokingAreaList() {
		log.info("Called :: selectSmokingAreaList");
		return facilityMapper.selectSmokingAreaList();
	}
	
	// 강의실
	public List<Map<String, Object>> selectClassroomList() {
		log.info("Called :: selectClassroomList");
		return facilityMapper.selectClassroomList();
	}
	
	// 교통 정보
	public List<Map<String, Object>> selectTransportList() {
		log.info("Called :: selectTransportList");
		return facilityMapper.selectTransportList();
	}
}
