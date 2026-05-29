package kr.hcnc.mapper.facility;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("facilityInfoMapper")
public interface FacilityInfoMapper {
	
	// 흡연장 정보
	public List<Map<String, Object>> selectSmokingArea();
	
	// 강의실 정보
	public List<Map<String, Object>> selectClassroomList();
}
