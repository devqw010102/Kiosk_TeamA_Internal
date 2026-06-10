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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.admin.AdminCafeteriaService;
import kr.hcnc.vo.CafeteriaVO;

//식단 관리 API - 구내식당 일일 메뉴 등록/수정/삭제
@RestController
@RequestMapping("/api/admin/cafeteria")
public class AdminCafeteriaController {

	private static final Logger log = LoggerFactory.getLogger(AdminCafeteriaController.class);

    @Resource(name = "adminCafeteriaService")
    private AdminCafeteriaService adminCafeteriaService;
    
    @GetMapping("/{date}")
    public ResponseEntity<List<CafeteriaVO>> getCafeteria(@PathVariable String date) {
    	log.info("Called :: GET /api/admin/cafeteria/{}", date);
    	
    	String[] dateParts = date.split("-");
    	String year = dateParts[0];
    	String month = dateParts[1];
    	
    	List<CafeteriaVO> result = adminCafeteriaService.selectCafeteriaSummary(year, month);
    	
    	return ResponseEntity.ok(result);
    }
    
    @GetMapping("/detail/{date}")
    public ResponseEntity<List<CafeteriaVO>> getCafeteriaDetail(@PathVariable String date) {
    	log.info("Called :: GET /api/admin/cafeteria/detail/{}", date);
    	
    	List<CafeteriaVO> result = adminCafeteriaService.selectCafeteriaDetail(date);
    	
    	return ResponseEntity.ok(result);
    }
    
    @PostMapping(produces = "application/json; charset=utf8")
    public ResponseEntity<?> insertCafeteria(@RequestBody List<CafeteriaVO> cafeteriaList) {
    	log.info("Called :: POST /api/admin/cafeteria - body list size: {}", cafeteriaList);
    	
    	adminCafeteriaService.insertCafeteria(cafeteriaList);
    	
    	Map<String, Object> response = new HashMap<>();
    	response.put("count", cafeteriaList != null ? cafeteriaList.size() : 0);
    	return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PutMapping("/{cafeteriaId}")
    public ResponseEntity<?> updateCafeteria(@PathVariable String cafeteriaId, @RequestBody CafeteriaVO cafeteriaVO) {
    	log.info("Called :: PUT /api/admin/cafeteria/{} - body: {}", cafeteriaId, cafeteriaVO);
    	cafeteriaVO.setCafeteriaId(cafeteriaId);
    	return ResponseEntity.ok(adminCafeteriaService.updateCafeteria(cafeteriaVO));
    }
    
    @DeleteMapping("/{cafeteriaId}")
    public ResponseEntity<?> deleteCafeteria(@PathVariable String cafeteriaId) {
    	log.info("Called :: DELETE /api/admin/cafeteria/{}", cafeteriaId);
    	return ResponseEntity.ok(adminCafeteriaService.deleteCafeteria(cafeteriaId));
    }

}
