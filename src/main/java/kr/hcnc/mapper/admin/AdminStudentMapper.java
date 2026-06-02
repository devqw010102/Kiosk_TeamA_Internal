package kr.hcnc.mapper.admin;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.StudentVO;

@Mapper("adminStudentMapper")
public interface AdminStudentMapper {
	
	public List<StudentVO> selectStudent();
	
	public StudentVO selectStudentById(String studentId);
	
	public int insertStudent(StudentVO studentVO);
	
	public int updateStudent(StudentVO studentVO);
	
	public int deleteStudent(String studentId);
}
