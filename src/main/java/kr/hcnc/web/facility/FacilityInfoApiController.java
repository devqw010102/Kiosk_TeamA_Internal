package kr.hcnc.web.facility;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.facility.FacilityInfoService;

@RestController
@RequestMapping("/api/info")
public class FacilityInfoApiController {

	@Resource(name = "facilityInfoService")
    private FacilityInfoService facilityInfoService;

    private static final Logger log = LoggerFactory.getLogger(FacilityInfoApiController.class);

    @GetMapping("/smoking")
    public List<Map<String, Object>> selectSmokingArea() {
        log.info("Called :: /api/info/smoking");
        return facilityInfoService.selectSmokingArea();
    }

    @GetMapping("/classroom")
    public List<Map<String, Object>> selectClassroomList() {
        log.info("Called :: /api/info/classroom");
        return facilityInfoService.selectClassroomList();
    }
}
