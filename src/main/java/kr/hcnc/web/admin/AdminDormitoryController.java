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

import kr.hcnc.service.admin.AdminDormitoryService;

//생활관 관리 API - 호실 배정/입실/퇴실 처리
@RestController
@RequestMapping("/api/admin/dormitories")
public class AdminDormitoryController {

	private static final Logger log = LoggerFactory.getLogger(AdminDormitoryController.class);

    @Resource(name = "adminDormitoryService")
    private AdminDormitoryService adminDormitoryService;
    
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getDormitories() {
    	log.info("Called :: GET /api/admin/dormitories");
    	
    	return ResponseEntity.ok(adminDormitoryService.selectDormitories());
    }
}
