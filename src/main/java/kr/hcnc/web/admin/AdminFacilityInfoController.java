package kr.hcnc.web.admin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.admin.AdminFacilityInfoService;
import kr.hcnc.vo.FacilityInfoVO;

@RestController
@RequestMapping("/api/admin/facilityInfo")
public class AdminFacilityInfoController {

	@Resource(name = "adminFacilityInfoService")
	private AdminFacilityInfoService adminFacilityInfoService;

	private static final Logger log = LoggerFactory.getLogger(AdminFacilityInfoController.class);

	@GetMapping
	public ResponseEntity<List<FacilityInfoVO>> getFacilityList() {
		log.info("Called :: GET /api/admin/facilityInfo");
		return ResponseEntity.ok(adminFacilityInfoService.selectFacilityList());
	}

	@GetMapping("/{facilityId}")
	public ResponseEntity<FacilityInfoVO> getFacilityInfo(@PathVariable String facilityId) {
		log.info("Called :: GET /api/admin/facilityInfo/{}", facilityId);
		return ResponseEntity.ok(adminFacilityInfoService.selectFacilityById(facilityId));
	}

	@PostMapping
	public ResponseEntity<Map<String, Object>> insertFacility(@RequestBody FacilityInfoVO facilityInfoVO) {
		log.info("Called :: POST /api/admin/facilityInfo");
		Map<String, Object> result = adminFacilityInfoService.insertFacility(facilityInfoVO);
		if ("fail".equals(result.get("status"))) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping("/{facilityId}")
	public ResponseEntity<Map<String, Object>> updateFacility(
			@PathVariable String facilityId,
			@RequestBody FacilityInfoVO facilityInfoVO) {
		log.info("Called :: PUT /api/admin/facilityInfo/{}", facilityId);
		facilityInfoVO.setFacilityId(facilityId);
		Map<String, Object> result = adminFacilityInfoService.updateFacility(facilityInfoVO);
		if ("fail".equals(result.get("status"))) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}
}
