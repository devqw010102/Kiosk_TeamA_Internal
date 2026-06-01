package kr.hcnc.web.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import kr.hcnc.service.admin.AdminEduInfoService;
import kr.hcnc.vo.EduInfoVO;

// 교육과정 관리 API - 교육과정 조회 및 등록/수정/삭제(SOFT DELETE)
@RestController
@RequestMapping("/api/admin/eduInfo")
public class AdminEduInfoController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminEduInfoController.class);
	
	@Resource(name = "adminEduInfoService")
	private AdminEduInfoService adminEduInfoService;
	
	@GetMapping
	public ResponseEntity<List<EduInfoVO>> getEduInfos() {
		log.info("Called :: GET /api/admin/eduInfo");
		return ResponseEntity.ok(adminEduInfoService.selectEduInfo());
	}
	
	@GetMapping("/{eduId}")
	public ResponseEntity<EduInfoVO> getEduInfo(@PathVariable String eduId) {
		log.info("Called :: GET /api/admin/eduInfo/{}", eduId);
		return ResponseEntity.ok(adminEduInfoService.selectEduInfoById(eduId));
	}
	
	@PostMapping
	public ResponseEntity<?> insertEduInfo(@RequestBody EduInfoVO eduInfoVO) {
		log.info("Called :: POST /api/admin/eduInfo");
		adminEduInfoService.insertEduInfo(eduInfoVO);
		Map<String, Object> response = new HashMap<>();
		response.put("eduId", eduInfoVO.getEduId());
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/{eduId}")
	public ResponseEntity<?> updateEduInfo(@PathVariable String eduId, @RequestBody EduInfoVO eduInfoVO) {
		log.info("Called :: PUT /api/admin/eduInfo/{}", eduId);
		eduInfoVO.setEduId(eduId);
		adminEduInfoService.updateEduInfo(eduInfoVO);
		Map<String, Object> response = new HashMap<>();
		response.put("eduId", eduInfoVO.getEduId());
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{eduId}")
	public ResponseEntity<?> deleteEduInfo(@PathVariable String eduId) {
		log.info("Called :: DELETE /api/admin/eduInfo/{}", eduId);
		adminEduInfoService.deleteEduInfo(eduId);
		return ResponseEntity.ok().build();
	}
}
