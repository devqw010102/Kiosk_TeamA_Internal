package kr.hcnc.mapper;

import java.util.List;
import java.util.Map;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.StudentSearchVO;
@Mapper("badgeMapper")
public interface BadgeMapper {
	
	List<Map<String, Object>> selectStudents(StudentSearchVO searchVO);
	
	Map<String, Object> selectStudentDetail(StudentSearchVO searchVO);
	
	int updateAttendYN(StudentSearchVO searchVO);
	
	int updateDormitoryCount(StudentSearchVO searchVO);
	
	Map<String, Object> selectStudentStatus(StudentSearchVO searchVO);
	
	Map<String, Object> selectDormitoryInfo(StudentSearchVO searchVO);
}
