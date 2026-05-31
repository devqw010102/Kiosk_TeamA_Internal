package kr.hcnc.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Map<String, Object> updateFacility(FacilityInfoVO facilityInfoVO) {
		log.info("Called :: updateFacility");
		Map<String, Object> result = new HashMap<>();

		if (facilityInfoVO == null || facilityInfoVO.getFacilityId() == null || facilityInfoVO.getFacilityType() == null) {
			result.put("status", "fail");
			result.put("message", "잘못된 요청입니다.");
			return result;
		}

		int updated = adminFacilityInfoMapper.updateFacility(facilityInfoVO);
		if (updated > 0) {
			result.put("status", "success");
			result.put("message", "수정되었습니다.");
		} else {
			result.put("status", "fail");
			result.put("message", "수정할 시설 정보를 찾을 수 없습니다.");
		}
		return result;
	}
}
