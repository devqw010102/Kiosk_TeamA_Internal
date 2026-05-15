package kr.hcnc.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.FacilityService;

@RestController
@RequestMapping("/api/info")
public class FacilityApiController {

	@Resource(name = "facilityService")
	private FacilityService facilityService;
	
	@GetMapping("/cafe")
	public List<Map<String, Object>> selectCafeteriaList() {
		System.out.println("FacilityApiController :: /api/info/cafe");
		return facilityService.selectCafeteriaList();
	}
}
