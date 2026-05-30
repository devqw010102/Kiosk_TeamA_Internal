package kr.hcnc.mapper.dashboard;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("adminDashBoardMapper")
public interface AdminDashBoardMapper {
	public List<Map<String, Object>> selectPrintCountByHour();
	public List<Map<String, Object>> selectPopularFeature();
	public Map<String, Object> selectAttendCount(); 
}
