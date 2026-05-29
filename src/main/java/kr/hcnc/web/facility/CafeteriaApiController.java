package kr.hcnc.web.facility;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.facility.CafeteriaService;

@RestController
@RequestMapping("/api/info")
public class CafeteriaApiController {

	@Resource(name = "cafeteriaService")
	private CafeteriaService cafeteriaService;
	
	private static final Logger log = LoggerFactory.getLogger(CafeteriaApiController.class);
	
	@GetMapping("/cafe")
	public List<Map<String, Object>> selectCafeteriaList() {
		log.info("Called :: /api/info/cafe");
		return cafeteriaService.selectCafeteriaList();
	}
}
