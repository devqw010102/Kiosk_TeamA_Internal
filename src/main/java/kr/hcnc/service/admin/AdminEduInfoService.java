package kr.hcnc.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.admin.AdminEduInfoMapper;
import kr.hcnc.vo.EduInfoVO;

@Service("adminEduInfoService")
public class AdminEduInfoService extends EgovAbstractServiceImpl {

	@Resource(name = "adminEduInfoMapper")
	private AdminEduInfoMapper adminEduInfoMapper;
	
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
