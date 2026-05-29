package kr.hcnc.mapper.admin;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.admin.ClassroomVO;

@Mapper("adminClassroomMapper")
public interface AdminClassroomMapper {
	
	public List<ClassroomVO> selectClassroom();
	
	public ClassroomVO selectClassroomById(String classroomId);
	
	public int insertClassroom(ClassroomVO classroomVO);
	
	public int updateClassroom(ClassroomVO classroomVO);
}
