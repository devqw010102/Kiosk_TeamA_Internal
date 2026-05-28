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

import kr.hcnc.service.admin.AdminCafeteriaService;

//식단 관리 API - 구내식당 일일 메뉴 등록/수정/삭제
@RestController
@RequestMapping("/api/admin/cafeteria")
public class AdminCafeteriaController {

	private static final Logger log = LoggerFactory.getLogger(AdminCafeteriaController.class);

    @Resource(name = "adminCafeteriaService")
    private AdminCafeteriaService adminCafeteriaService;
    
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getCafeteria(@RequestParam(required = false) String date) {
    	log.info("Called :: GET /api/admin/cafeteria");
    	
    	return ResponseEntity.ok(adminCafeteriaService.selectCafeteria(date));
    }
    
    
}
