package kr.hcnc.web.kiosk;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.kiosk.FacilityInfoService;
import kr.hcnc.vo.FacilityInfoVO;

@RestController
@RequestMapping("/api/facilityInfo")
public class FacilityInfoApiController {
    private static final Logger log = LoggerFactory.getLogger(FacilityInfoApiController.class);

    @Resource(name = "facilityInfoService")
    private FacilityInfoService facilityInfoService;

    @GetMapping
    public List<FacilityInfoVO> selectFacilityList() {
        log.info("Called :: GET /api/facilityInfo");
        return facilityInfoService.selectFacilityList();
    }
}
