package kr.hcnc.mapper.kiosk;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.ClassroomVO;

@Mapper("classroomMapper")
public interface ClassroomMapper {

	List<ClassroomVO> selectClassroom();
}
