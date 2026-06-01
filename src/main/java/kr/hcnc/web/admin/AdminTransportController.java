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

import kr.hcnc.service.admin.AdminTransportService;
import kr.hcnc.vo.TransportVO;

@RestController
@RequestMapping("/api/admin/transport")
public class AdminTransportController {

	@Resource(name = "adminTransportService")
	private AdminTransportService adminTransportService;

	private static final Logger log = LoggerFactory.getLogger(AdminTransportController.class);

	@GetMapping
	public ResponseEntity<List<TransportVO>> getTransportList() {
		log.info("Called :: GET /api/admin/transport");
		return ResponseEntity.ok(adminTransportService.selectTransportList());
	}

	@GetMapping("/{transportId}")
	public ResponseEntity<TransportVO> getTransport(@PathVariable String transportId) {
		log.info("Called :: GET /api/admin/transport/{}", transportId);
		return ResponseEntity.ok(adminTransportService.selectTransportById(transportId));
	}

	@PostMapping
	public ResponseEntity<Map<String, Object>> insertTransport(@RequestBody TransportVO transportVO) {
		log.info("Called :: POST /api/admin/transport");
		Map<String, Object> result = adminTransportService.insertTransport(transportVO);
		if ("fail".equals(result.get("status"))) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping("/{transportId}")
	public ResponseEntity<Map<String, Object>> updateTransport(
			@PathVariable String transportId,
			@RequestBody TransportVO transportVO) {
		log.info("Called :: PUT /api/admin/transport/{}", transportId);
		transportVO.setTransportId(transportId);
		Map<String, Object> result = adminTransportService.updateTransport(transportVO);
		if ("fail".equals(result.get("status"))) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}
}
