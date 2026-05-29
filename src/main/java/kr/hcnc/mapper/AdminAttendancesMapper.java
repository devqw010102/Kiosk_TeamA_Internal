package kr.hcnc.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.AttendSearchVO;

@Mapper("adminAttendancesMapper")
public interface AdminAttendancesMapper {
	public List<Map<String, Object>> selectAttend(AttendSearchVO attendSearchVO);
}
