package kr.hcnc.service.admin.facility;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.facility.FacilityInfoMapper;

@Service("facilityInfoService")
public class FacilityInfoService  extends EgovAbstractServiceImpl{
	
	@Resource(name = "facilityInfoMapper")
	private FacilityInfoMapper  facilityInfoMapper;
	
	private static final Logger log = LoggerFactory.getLogger(FacilityInfoService.class);
	
	// 흡연장소
	public List<Map<String, Object>> selectSmokingArea() {
		log.info("Called :: selectSmokingArea");
		return facilityInfoMapper.selectSmokingArea();
	}
	
	// 강의실
	public List<Map<String, Object>> selectClassroomList() {
		log.info("Called :: selectClassroomList");
		return facilityInfoMapper.selectClassroomList();
	}
}
