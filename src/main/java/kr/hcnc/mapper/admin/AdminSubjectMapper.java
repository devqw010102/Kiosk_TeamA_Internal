package kr.hcnc.mapper.admin;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.SubjectVO;

@Mapper("adminSubjectMapper")
public interface AdminSubjectMapper {
	
	public List<SubjectVO> selectSubject();
	
	public SubjectVO selectSubjectById(String subjectId);
	
	public int insertSubject(SubjectVO subjectVO);
	
	public int updateSubject(SubjectVO subjectVO);
	
	public int deleteSubject(String subjectId);
}
