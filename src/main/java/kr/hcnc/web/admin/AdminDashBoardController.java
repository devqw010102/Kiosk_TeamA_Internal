package kr.hcnc.web.admin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.admin.dashBoard.AdminDashBoardService;

@RestController
@RequestMapping("/api/admin/dashboard")
public class AdminDashBoardController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminDashBoardController.class);
	
    @Resource(name = "adminDashBoardService")
	private AdminDashBoardService adminDashBoardService;
    
    @GetMapping("/print-count")
    public ResponseEntity<List<Map<String, Object>>> selectPrintCountByHour() {
    	log.info("Called::selectPrintCountByHour()");
    	return ResponseEntity.ok(adminDashBoardService.selectPrintCountByHour());
    }
    
    @GetMapping("/popular")
    public ResponseEntity<List<Map<String, Object>>> selectPopularFeature() {
    	log.info("Called::selectPopularFeature()");
    	return ResponseEntity.ok(adminDashBoardService.selectPopularFeature());
    }
    
    @GetMapping("/attend-count")
    public ResponseEntity<Map<String, Object>> selectAttendCount() {
    	log.info("Called::selectPrintCountByHour()");
    	return ResponseEntity.ok(adminDashBoardService.selectAttendCount());
    }
    
    @GetMapping("/dorm-stats")
    public ResponseEntity<Map<String, Object>> selectDormStats() {
    	log.info("Called::selectDormStats()");
    	return ResponseEntity.ok(adminDashBoardService.selectDormStats());
    }
}
