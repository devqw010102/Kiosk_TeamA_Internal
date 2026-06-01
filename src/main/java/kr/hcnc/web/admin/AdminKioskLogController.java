package kr.hcnc.web.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.admin.AdminKioskLogService;
import kr.hcnc.vo.KioskLogVO;

@RestController
@RequestMapping("/api/admin/kiosk-log")
public class AdminKioskLogController {
	@Resource(name = "adminKioskLogService")
	private AdminKioskLogService adminKioskLogService;
	private static final Logger log = LoggerFactory.getLogger(AdminKioskLogController.class);
	
	@GetMapping
	public ResponseEntity<List<KioskLogVO>> getKiostLog(KioskLogVO kioskLogVO){
		log.info("Called::getKiostLog");
		return ResponseEntity.ok(adminKioskLogService.selectKioskLog(kioskLogVO));
	}
	
	@PostMapping
	public ResponseEntity<Integer> insertLog(@RequestBody KioskLogVO kioskLogVO) {
		log.info("Called::insertLog()");
		int result = adminKioskLogService.insertLog(kioskLogVO);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping
	public ResponseEntity<Integer> deleteLog(@RequestBody KioskLogVO kioskLogVO){
		log.info("Called::deleteLog");
		int result = adminKioskLogService.deleteLog(kioskLogVO);
		return ResponseEntity.ok(result);
	}
}
