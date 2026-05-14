package kr.hcnc.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("facilityMapper")
public interface FacilityMapper {
	
	// 구내식당 정보
	public List<Map<String, Object>> selectCafeteriaList();
	
	// 흡연장 정보
	public List<Map<String, Object>> selectSmokingAreaList();
	
	// 강의실 정보
	public List<Map<String, Object>> selectClassroomList();
	
	// 교통 정보
	public List<Map<String, Object>> selectTransportList();
}
