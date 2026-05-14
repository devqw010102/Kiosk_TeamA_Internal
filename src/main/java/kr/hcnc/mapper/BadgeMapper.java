package kr.hcnc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("badgeMapper")
public interface BadgeMapper {

	public String selectCount();
	
	public List<Map<String, Object>> selectStudents(@Param("birthDate") String param);
}
