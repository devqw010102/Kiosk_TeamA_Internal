package kr.hcnc.web.admin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.admin.AdminAttendanceService;

//출석 관리 API - 출석 현황 조회 및 수동 변경
@RestController
@RequestMapping("/api/admin/attendances")
public class AdminAttendanceController {

	private static final Logger log = LoggerFactory.getLogger(AdminAttendanceController.class);

    @Resource(name = "adminAttendanceService")
    private AdminAttendanceService adminAttendanceService;
   
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAttendances(@RequestParam(required = false) String date) {
    	log.info("Called :: GET /api/admin/attendances");
    	
    	return ResponseEntity.ok(adminAttendanceService.selectAttendances(date));
    }
}
