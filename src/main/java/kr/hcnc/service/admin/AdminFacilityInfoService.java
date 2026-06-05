package kr.hcnc.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import kr.hcnc.mapper.admin.AdminFacilityInfoMapper;
import kr.hcnc.vo.FacilityInfoVO;

@Service("adminFacilityInfoService")
public class AdminFacilityInfoService extends EgovAbstractServiceImpl {

	@Resource(name = "adminFacilityInfoMapper")
	private AdminFacilityInfoMapper adminFacilityInfoMapper;

	@Resource(name = "facilityIdGnService")
	private EgovIdGnrService facilityIdGnService;
	
	private static final Logger log = LoggerFactory.getLogger(AdminFacilityInfoService.class);

	public List<FacilityInfoVO> selectFacilityList() {
		log.info("Called :: selectFacilityList");
		return adminFacilityInfoMapper.selectFacilityList();
	}

	public FacilityInfoVO selectFacilityById(String facilityId) {
		log.info("Called :: selectFacilityById");
		return adminFacilityInfoMapper.selectFacilityById(facilityId);
	}

	public int insertFacility(FacilityInfoVO facilityInfoVO) {
	    log.info("Called :: insertFacility");
	    try {
	    	facilityInfoVO.setFacilityId(facilityIdGnService.getNextStringId());
	    }
	    catch(FdlException e) {
	    	log.error("FACILITY ID 채번 실패", e);
	    	throw new RuntimeException("ID 생성에 실패했습니다.");
	    }
	    return adminFacilityInfoMapper.insertFacility(facilityInfoVO);
	}
	
	public int updateFacility(FacilityInfoVO facilityInfoVO) {
	    log.info("Called :: updateFacility");
	    return adminFacilityInfoMapper.updateFacility(facilityInfoVO);
	}
	
	public int deleteFacility(String facilityId) {
	    log.info("Called :: deleteFacility");
	    return adminFacilityInfoMapper.deleteFacility(facilityId);
	}
}
