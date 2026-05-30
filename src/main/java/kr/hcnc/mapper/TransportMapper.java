package kr.hcnc.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("transportMapper")
public interface TransportMapper {

	// 교통 정보
	public List<Map<String, Object>> selectTransportList();
}
