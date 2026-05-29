package kr.hcnc.mapper.facility;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("cafeteriaMapper")
public interface CafeteriaMapper {
	
	// 구내식당 정보
	public List<Map<String, Object>> selectCafeteriaList();
}
