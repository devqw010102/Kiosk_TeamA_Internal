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

import kr.hcnc.service.admin.AdminSubjectService;
import kr.hcnc.vo.SubjectVO;

@RestController
@RequestMapping("/api/admin/subject")
public class AdminSubjectController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminSubjectController.class);
	
	@Resource(name = "adminSubjectService")
	private AdminSubjectService adminSubjectService;
	
	@GetMapping
	public ResponseEntity<List<SubjectVO>> getSubjects() {
		log.info("Called :: GET /api/admin/subject");
		return ResponseEntity.ok(adminSubjectService.selectSubject());
	}
	
	@GetMapping("/{subjectId}")
	public ResponseEntity<SubjectVO> getSubject(@PathVariable String subjectId) {
		log.info("Called :: GET /api/admin/subject/{}", subjectId);
		return ResponseEntity.ok(adminSubjectService.selectSubjectById(subjectId));
	}
	
	@PostMapping
	public ResponseEntity<?> insertSubject(@RequestBody SubjectVO subjectVO) {
		log.info("Called :: POST /api/admin/subject");
		int result = adminSubjectService.insertSubject(subjectVO);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@PutMapping("/{subjectId}")
	public ResponseEntity<?> updateSubject(@PathVariable String subjectId, @RequestBody SubjectVO subjectVO) {
		log.info("Called :: PATCH /api/admin/subject/{}", subjectId);
		subjectVO.setSubjectId(subjectId);
		int result = adminSubjectService.updateSubject(subjectVO);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/{subjectId}")
	public ResponseEntity<?> deleteSubject(@PathVariable String subjectId) {
		log.info("Called :: DELETE /api/admin/subject/{}", subjectId);
		int result = adminSubjectService.deleteSubject(subjectId);
		return ResponseEntity.ok(result);
	}
}
