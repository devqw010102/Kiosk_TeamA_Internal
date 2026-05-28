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

import kr.hcnc.service.admin.AdminClassroomService;

//강의실 관리 API - 배치도 이미지 등록/수정/삭제
@RestController
@RequestMapping("/api/admin/classroom")
public class AdminClassroomController {

	private static final Logger log = LoggerFactory.getLogger(AdminClassroomController.class);
	
	@Resource(name = "adminClassroomService")
    private AdminClassroomService adminClassroomService;
	
	@GetMapping
	public ResponseEntity<List<Map<String, Object>>> getClassrooms() {
		log.info("Called :: GET /api/admin/classroom");
		return ResponseEntity.ok(adminClassroomService.selectClassrooms());
	}
}
