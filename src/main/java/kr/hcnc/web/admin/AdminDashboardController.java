package kr.hcnc.web.admin;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.admin.AdminDashboardService;

//대시보드 API - 출석/생활관/트래픽 통계 조회
@RestController
@RequestMapping("/api/admin/dashboard")
public class AdminDashboardController {

	private static final Logger log = LoggerFactory.getLogger(AdminDashboardController.class);
	
    @Resource(name = "adminDashboardService")
    private AdminDashboardService adminDashboardService;
    
    @GetMapping
    public ResponseEntity<Map<String, Object>> getDashboard() {
    	log.info("Called :: GET /api/admin/dashboard");
    	
    	return ResponseEntity.ok(adminDashboardService.selectDashboard());
    }
}
