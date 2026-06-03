package kr.hcnc.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.admin.AdminFacilityInfoMapper;
import kr.hcnc.vo.FacilityInfoVO;

@Service("adminFacilityInfoService")
public class AdminFacilityInfoService extends EgovAbstractServiceImpl {

	@Resource(name = "adminFacilityInfoMapper")
	private AdminFacilityInfoMapper adminFacilityInfoMapper;

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
