package kr.hcnc.web.admin.facility;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.facility.TransportService;

@RestController
@RequestMapping("/api/info")
public class TransportApiController {

	@Resource(name = "transportService")
    private TransportService transportService;

    private static final Logger log = LoggerFactory.getLogger(TransportApiController.class);

    @GetMapping("/transport")
    public List<Map<String, Object>> selectTransportList() {
        log.info("Called :: /api/info/transport");
        return transportService.selectTransportList();
    }
}
