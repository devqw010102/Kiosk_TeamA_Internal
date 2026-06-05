package kr.hcnc.web.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.admin.AdminClassroomService;
import kr.hcnc.vo.ClassroomVO;

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
		int result = adminClassroomService.insertClassroom(classroomVO);		
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@PutMapping("/{classroomId}")
	public ResponseEntity<?> updateClassroom(@PathVariable String classroomId, @RequestBody ClassroomVO classroomVO) {
		log.info("Called :: PUT /api/admin/classroom/{}", classroomId);
		classroomVO.setClassroomId(classroomId);
		int result = adminClassroomService.updateClassroom(classroomVO); 
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/{classroomId}")
	public ResponseEntity<?> deleteClassroom(@PathVariable String classroomId) {
		log.info("Called :: DELETE /api/admin/classroom/{}", classroomId);
		int result = adminClassroomService.deleteClassroom(classroomId);
		return ResponseEntity.ok(result);
	}
}


