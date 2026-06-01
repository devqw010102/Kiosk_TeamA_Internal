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
    
    // 선택 달 전체 조회 API
    @GetMapping("")
    public ResponseEntity<List<CafeteriaVO>> getCafeteria(@RequestParam String date) {
    	log.info("Called :: GET /api/admin/cafeteria?date={}", date);
    	
    	String[] dateParts = date.split("-");
    	String year = dateParts[0];
    	String month = dateParts[1];
    	
    	List<CafeteriaVO> result = adminCafeteriaService.selectCafeteriaSummary(year, month);
    	
    	return ResponseEntity.ok(result);
    }
    
    // 일일 메뉴표(조식, 중식, 석식) 전체 조회 API
    @GetMapping("/detail")
    public ResponseEntity<List<CafeteriaVO>> getCafeteriaDetail(@RequestParam String date) {
    	log.info("Called :: GET /api/admin/cafeteria/detail?date={}", date);
    	
    	List<CafeteriaVO> result = adminCafeteriaService.selectCafeteriaDetail(date);
    	
    	return ResponseEntity.ok(result);
    }
    
    // 일일 메뉴 단건 등록 API
    @PostMapping(value = "/register", produces = "application/json; charset=utf8")
    public ResponseEntity<?> insertCafeteria(@RequestBody CafeteriaVO cafeteriaVO) {
    	log.info("Called :: POST /api/admin/cafeteria - body: {}", cafeteriaVO);
    	
    	adminCafeteriaService.insertCafeteria(cafeteriaVO);
    	
    	Map<String, Object> response = new HashMap<>();
    	response.put("caferterId", cafeteriaVO.getCafeteriaId());
    	return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    // 일일 메뉴 및 운영유무 수정 API
    @PutMapping("/update")
    public ResponseEntity<?> updateCafeteria(@RequestBody CafeteriaVO cafeteriaVO) {
    	log.info("Called :: PUT / api/admin/cafeteria/ - body: {}", cafeteriaVO);
    	
    	adminCafeteriaService.updateCafeteria(cafeteriaVO);
    	
    	String mealDate = cafeteriaVO.getMealDate();
    	List<CafeteriaVO> updatedData = adminCafeteriaService.selectCafeteriaDetail(mealDate);
    	return ResponseEntity.ok(updatedData);
    }
    
    // 일일 메뉴 단건 삭제 (논리 삭제)
    @DeleteMapping("/delete/{cafeteriaId}")
    public ResponseEntity<?> deleteCafeteria(@PathVariable String cafeteriaId) {
    	log.info("Called :: DELETE / api/admin/cafeteria/delete/{}", cafeteriaId);
    	adminCafeteriaService.deleteCafeteria(cafeteriaId);
    	return ResponseEntity.ok().build();
    }
}
