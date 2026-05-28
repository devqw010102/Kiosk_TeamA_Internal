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

import kr.hcnc.service.admin.AdminStudentService;

/*
 *     교육생 관리 API
 * 등록 / 수정 / 삭제 / 조회
 * 
 */
@RestController
@RequestMapping("/api/admin/students")
public class AdminStudentController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminStudentController.class);
	
	@Resource(name = "adminStudentService")
	private AdminStudentService adminStudentService;
	
	@GetMapping
	public ResponseEntity<List<Map<String, Object>>> getStudents() {
		log.info("Called :: GET /api/admin/students");
		System.out.println("Called :: GET /api/admin/students");
		
		return ResponseEntity.ok(adminStudentService.selectStudents());
	}
}
