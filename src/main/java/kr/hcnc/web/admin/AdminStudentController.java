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

import kr.hcnc.service.admin.AdminStudentService;
import kr.hcnc.vo.StudentVO;

/*
 *     교육생 관리 API
 * 등록 / 수정 / 삭제 / 조회
 * 
 */
@RestController
@RequestMapping("/api/admin/student")
public class AdminStudentController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminStudentController.class);
	
	@Resource(name = "adminStudentService")
	private AdminStudentService adminStudentService;
	
	@GetMapping
	public ResponseEntity<List<StudentVO>> getStudents() {
		log.info("Called :: GET /api/admin/student");
		return ResponseEntity.ok(adminStudentService.selectStudent());
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<StudentVO> getStudent(@PathVariable String studentId) {
		log.info("Called :: GET /api/admin/student/{}", studentId);
		return ResponseEntity.ok(adminStudentService.selectStudentById(studentId));
	}
	
	@PostMapping
	public ResponseEntity<?> insertStudent(@RequestBody StudentVO studentVO) {
		log.info("Called :: POST /api/admin/student");
		int result = adminStudentService.insertStudent(studentVO);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@PutMapping("/{studentId}")
	public ResponseEntity<?> updateStudent(@PathVariable String studentId, @RequestBody StudentVO studentVO) {
		log.info("Called :: PUT /api/admin/student/{}", studentId);
		studentVO.setStudentId(studentId);
		int result = adminStudentService.updateStudent(studentVO);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable String studentId) {
		log.info("Called :: DELETE /api/admin/student/{}", studentId);
		int result = adminStudentService.deleteStudent(studentId);
		return ResponseEntity.ok(result);
	}
	
	// batch 엔드포인트 추가예정 :: 엑셀 대량 업로드 시 Insert 로직
	// 엑셀 양식, C# 에서의 비즈니스 로직 등 어떻게 구현할지 미정이라 엔드포인트 구현 불가능에따라 주석 작성
	
	@PostMapping("/batch")
	public ResponseEntity<?> batchInsertStudent(@RequestBody List<StudentVO> students) {
		log.info("Called :: POST /api/admin/student/batch");
		int result = adminStudentService.batchInsertStudent(students);
		return ResponseEntity.ok(result);
	}
}
