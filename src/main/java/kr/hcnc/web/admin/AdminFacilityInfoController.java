package kr.hcnc.web.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<Integer> insertFacility(@RequestBody FacilityInfoVO facilityInfoVO) {
	    log.info("Called :: POST /api/admin/facilityInfo");
	    int result = adminFacilityInfoService.insertFacility(facilityInfoVO);
	    return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@PutMapping("/{facilityId}")
	public ResponseEntity<Integer> updateFacility(@PathVariable String facilityId, @RequestBody FacilityInfoVO facilityInfoVO) {
	    log.info("Called :: PUT /api/admin/facilityInfo/{}", facilityId);
	    facilityInfoVO.setFacilityId(facilityId);
	    int result = adminFacilityInfoService.updateFacility(facilityInfoVO);
	    return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/{facilityId}")
	public ResponseEntity<Integer> deleteFacility(@PathVariable String facilityId) {
	    log.info("Called :: DELETE /api/admin/facilityInfo/{}", facilityId);
	    int result = adminFacilityInfoService.deleteFacility(facilityId);
	    return ResponseEntity.ok(result);
	}
}
