package kr.hcnc.web.admin;

import java.util.HashMap;
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

import kr.hcnc.service.admin.AdminClassroomService;
import kr.hcnc.vo.admin.ClassroomVO;

//강의실 관리 API - 배치도 이미지 등록/수정/삭제
@RestController
@RequestMapping("/api/admin/classroom")
public class AdminClassroomController {

	private static final Logger log = LoggerFactory.getLogger(AdminClassroomController.class);
	
	@Resource(name = "adminClassroomService")
    private AdminClassroomService adminClassroomService;
	
	@GetMapping
	public ResponseEntity<List<ClassroomVO>> getClassrooms() {
		log.info("Called :: GET /api/admin/classroom");
		return ResponseEntity.ok(adminClassroomService.selectClassroom());
	}
	
	@GetMapping("/{classroomId}")
	public ResponseEntity<ClassroomVO> getClassroom(@PathVariable String classroomId) {
		log.info("Called :: GET /api/admin/classroom/{}", classroomId);
		return ResponseEntity.ok(adminClassroomService.selectClassroomById(classroomId));
	}
	
	@PostMapping
	public ResponseEntity<?> insertClassroom(@RequestBody ClassroomVO classroomVO) {
		log.info("Called :: POST /api/admin/classroom");
		System.out.println(classroomVO.toString());
		System.out.println(classroomVO.getClassroomId());
		System.out.println(classroomVO.getClassroomName());
		System.out.println(classroomVO.getFloor());
		System.out.println(classroomVO.getImageId());
		System.out.println(classroomVO.getImagePath());
		adminClassroomService.insertClassroom(classroomVO);
		Map<String, Object> response = new HashMap<>();
		response.put("classroomId", classroomVO.getClassroomId());		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/{classroomId}")
	public ResponseEntity<?> updateClassroom(@PathVariable String classroomId, @RequestBody ClassroomVO classroomVO) {
		log.info("Called :: PUT /api/admin/classroom/{}", classroomId);
		classroomVO.setClassroomId(classroomId);
		adminClassroomService.updateClassroom(classroomVO);
		Map<String, Object> response = new HashMap<>();
		response.put("classroomId", classroomVO.getClassroomId());
		return ResponseEntity.ok(response);
	}
}


