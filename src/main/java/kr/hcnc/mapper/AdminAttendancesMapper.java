package kr.hcnc.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.AttendVO;

@Mapper("adminAttendancesMapper")
public interface AdminAttendancesMapper {
	public List<AttendVO> selectAttend(AttendVO attendVO);
	public int updateAttendMsg(AttendVO attendVO);
}
