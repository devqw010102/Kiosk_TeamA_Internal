package kr.hcnc.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.admin.AdminSubjectMapper;
import kr.hcnc.vo.SubjectVO;

@Service("adminSubjectService")
public class AdminSubjectService extends EgovAbstractServiceImpl {
	
	@Resource(name = "adminSubjectMapper")
	private AdminSubjectMapper adminSubjectMapper;
	
	private static final Logger log = LoggerFactory.getLogger(AdminSubjectService.class);
	
	public List<SubjectVO> selectSubject() {
		log.info("selectSubject");
		return adminSubjectMapper.selectSubject();
	}
	
	public SubjectVO selectSubjectById(String subjectId) {
		log.info("selectSubjectById");
		return adminSubjectMapper.selectSubjectById(subjectId);
	}
	
	public int insertSubject(SubjectVO subjectVO) {
		log.info("insertSubject");
		return adminSubjectMapper.insertSubject(subjectVO);
	}
	
	public int updateSubject(SubjectVO subjectVO) {
		log.info("updateSubject");
		return adminSubjectMapper.updateSubject(subjectVO);
	}
	
	public int deleteSubject(String subjectId) {
		log.info("deleteSubject");
		return adminSubjectMapper.deleteSubject(subjectId);
	}
}
