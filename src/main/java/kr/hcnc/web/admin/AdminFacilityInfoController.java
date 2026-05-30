package kr.hcnc.web.admin;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.hcnc.service.admin.AdminFacilityInfoService;
import kr.hcnc.vo.FacilityInfoVO;

@RestController
@RequestMapping("/api/admin/facilityInfo")
public class AdminFacilityInfoController {

	@Resource(name = "adminFacilityInfoService")
	private AdminFacilityInfoService adminFacilityInfoService;

	private static final Logger log = LoggerFactory.getLogger(AdminFacilityInfoController.class);

	@PostMapping
	public Map<String, Object> updateFacility(@RequestBody FacilityInfoVO facilityInfoVO) {
		log.info("Called :: POST /api/admin/facilityInfo");
		return adminFacilityInfoService.updateFacility(facilityInfoVO);
	}

	@PutMapping("/{facilityId}")
	public Map<String, Object> updateFacility(@PathVariable String facilityId, @RequestBody FacilityInfoVO facilityInfoVO) {
		log.info("Called :: PUT /api/admin/facilityInfo/{facilityId}");
		facilityInfoVO.setFacilityId(facilityId);
		return adminFacilityInfoService.updateFacility(facilityInfoVO);
	}
}
