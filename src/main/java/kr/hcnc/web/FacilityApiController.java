package kr.hcnc.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.FacilityService;

@RestController
@RequestMapping("/api/info")
public class FacilityApiController {

	@Resource(name = "facilityService")
	private FacilityService facilityService;
	
	private static final Logger log = LoggerFactory.getLogger(FacilityService.class);
	
	@GetMapping("/cafe")
	public List<Map<String, Object>> selectCafeteriaList() {
		log.info("FacilityApiController :: /api/info/cafe");
		return facilityService.selectCafeteriaList();
	}
}
