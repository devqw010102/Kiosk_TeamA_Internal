package kr.hcnc.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import kr.hcnc.mapper.admin.AdminEduInfoMapper;
import kr.hcnc.vo.EduInfoVO;

@Service("adminEduInfoService")
public class AdminEduInfoService extends EgovAbstractServiceImpl {

	@Resource(name = "adminEduInfoMapper")
	private AdminEduInfoMapper adminEduInfoMapper;
	
	@Resource(name = "eduInfoIdGnService")
	private EgovIdGnrService eduInfoIdGnService;
	
	private static final Logger log = LoggerFactory.getLogger(AdminEduInfoService.class);
	
	public List<EduInfoVO> selectEduInfo() {
		log.info("selectEduInfo");
		return adminEduInfoMapper.selectEduInfo();
	}
	
	public EduInfoVO selectEduInfoById(String eduId) {
		log.info("selectEduInfoById");
		return adminEduInfoMapper.selectEduInfoById(eduId);
	}
	
	public int insertEduInfo(EduInfoVO eduInfoVO) {
		log.info("insertEduInfo");
		try {
			eduInfoVO.setEduId(eduInfoIdGnService.getNextStringId());
		}
		catch(FdlException e) {
			log.error("EDU_INFO ID 채번 실패", e);
			throw new RuntimeException("ID 생성에 실패했습니다.");
		}
		return adminEduInfoMapper.insertEduInfo(eduInfoVO);
	}
	
	public int updateEduInfo(EduInfoVO eduInfoVO) {
		log.info("updateEduInfo");
		return adminEduInfoMapper.updateEduInfo(eduInfoVO);
	}
	
	public int deleteEduInfo(String eduId) {
		log.info("deleteEduInfo");
		return adminEduInfoMapper.deleteEduInfo(eduId);
	}
}
