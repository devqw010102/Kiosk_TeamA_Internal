package kr.hcnc.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.FacilityInfoService;
import kr.hcnc.vo.FacilityInfoVO;

@RestController
@RequestMapping("/api/info")
public class FacilityInfoApiController {

	@Resource(name = "facilityInfoService")
	private FacilityInfoService facilityInfoService;

	private static final Logger log = LoggerFactory.getLogger(FacilityInfoApiController.class);

	@GetMapping("/smoking")
	public List<FacilityInfoVO> selectSmokingArea() {
		log.info("Called :: /api/info/smoking");
		return facilityInfoService.selectSmokingArea();
	}

	@GetMapping("/cafeteria")
	public List<FacilityInfoVO> selectCafeteriaLocation() {
		log.info("Called :: /api/info/cafeteria");
		return facilityInfoService.selectCafeteriaLocation();
	}
}
