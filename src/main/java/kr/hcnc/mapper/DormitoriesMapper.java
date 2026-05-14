package kr.hcnc.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("dormitoriesMapper")
public interface DormitoriesMapper {

	public List<Map<String, Object>> selectTest();
}
