package kr.hcnc.web.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.admin.AdminDormitoryService;
import kr.hcnc.vo.DormAssignVO;
import kr.hcnc.vo.DormInOutVO;
import kr.hcnc.vo.DormitoryVO;

//생활관 관리 API - 호실 배정/입실/퇴실 처리
@RestController
@RequestMapping("/api/admin/dormitories")
public class AdminDormitoryController {

	private static final Logger log = LoggerFactory.getLogger(AdminDormitoryController.class);

    @Resource(name = "adminDormitoryService")
    private AdminDormitoryService adminDormitoryService;
    
    // 생활관 배정 여부 조회
    @GetMapping
    public ResponseEntity<List<DormAssignVO>> getDormAssign() {
    	log.info("Called :: GET /api/admin/dormitories");
    	List<DormAssignVO> list = adminDormitoryService.selectDormAssign();
    	return ResponseEntity.ok(list);
    }
    
    // 생활관 배정, 변경, 취소 콤보박스
    @GetMapping("/combo-box")
    public ResponseEntity<List<DormitoryVO>> getCmbDorm() {
    	log.info("Called :: GET /api/admin/dormitories/combo-box");
    	List<DormitoryVO> list = adminDormitoryService.selectCmbDorm();
    	return ResponseEntity.ok(list);
    }
    
    // 생활관 대기 조회
    @GetMapping("/waiting")
    public ResponseEntity<List<DormInOutVO>> getDormWaiting(){
    	log.info("Called :: GET /api/admin/dormitories/waiting");
    	List<DormInOutVO> list = adminDormitoryService.selectDormWaiting();
    	return ResponseEntity.ok(list);
    }
    // ==================== 삭제 예정 =========================
    // 생활관 입실 조회
    @GetMapping("/check-in")
    public ResponseEntity<List<DormInOutVO>> getDormIn(){
    	log.info("Called :: GET /api/admin/dormitories");
    	List<DormInOutVO> list = adminDormitoryService.selectDormIn();
    	return ResponseEntity.ok(list);
    }
    // =================== 삭제 예정 ==========================
    // 생활관 퇴실 조회
    @GetMapping("/check-out")
    public ResponseEntity<List<DormInOutVO>> getDormOut(){
    	log.info("Called :: GET /api/admin/dormitories");
    	List<DormInOutVO> list = adminDormitoryService.selectDormOut();
    	return ResponseEntity.ok(list);
    }
    
    // 생활관 입/퇴실 통합 조회
    @GetMapping("/in-out")
    public ResponseEntity<List<DormInOutVO>> getDormInOut(){
    	log.info("Called :: GET /api/admin/dormitories/in-out");
    	List<DormInOutVO> list = adminDormitoryService.selectDormInOut();
    	return ResponseEntity.ok(list);
    }
    // 생활관 전체  배정인원/최대 인원 가져오기
    @GetMapping("/assign-status")
    public ResponseEntity<List<DormitoryVO>> gettDormRoomAssignStatus(DormitoryVO dormitoryVO) {
    	log.info("Called :: GET /api/admin/dormitories/assign-status");
    	List<DormitoryVO> list = adminDormitoryService.selectDormRoomAssignStatus(dormitoryVO);
    	return ResponseEntity.ok(list);
    }
    
    // 생활관 호실별  배정인원/최대 인원 가져오기
//    @GetMapping("/{dormitoryId}")
//    public ResponseEntity<DormitoryVO> getDormRoomAssignStatusById(@PathVariable String dormitoryId) {
//    	log.info("Called :: GET /api/admin/dormitories/{}", dormitoryId);
//    	DormitoryVO result = adminDormitoryService.selectDormRoomAssignStatusById(dormitoryId);
//    	return ResponseEntity.ok(result);
//    }
    
    // 생활관 배정
    @PatchMapping("/{studentId}")
    public ResponseEntity<Integer> updateDormId(@PathVariable String studentId,
    											@RequestBody DormAssignVO dormAssignVO){
    	log.info("Called :: PATCH /api/admin/dormitories/{studentId}");
    	int result = adminDormitoryService.updateDormId(studentId, dormAssignVO);
    	return ResponseEntity.ok(result);
    }
    
    // 최대인원 수정
    @PatchMapping("/max-count")
    public ResponseEntity<Integer> updateDormAssignMaxCnt (@RequestBody DormitoryVO dormitoryVO){
    	log.info("Called :: PATCH /api/admin/dormitories/max-count");
    	int result = adminDormitoryService.updateDormAssignMaxCnt(dormitoryVO);
    	return ResponseEntity.ok(result);
    }
    // 배정인원 증가
    @PatchMapping("/current-count")
    public ResponseEntity<Integer> updateDormCurrentCnt (@RequestBody DormitoryVO dormitoryVO, @RequestParam String studentId){
    	log.info("Called :: PATCH /api/admin/dormitories/current-count");
    	int result = adminDormitoryService.updateDormCurrentCnt(dormitoryVO, studentId);
    	return ResponseEntity.ok(result);
    }
    // 배정인원 감소
    @PatchMapping("/current-down")
    public ResponseEntity<Integer> updateDormCurrentCntDown (@RequestBody DormitoryVO dormitoryVO, @RequestParam String studentId){
    	log.info("Called :: PATCH /api/admin/dormitories/current-down");
    	int result = adminDormitoryService.updateDormCurrentCntDown(dormitoryVO, studentId);
    	return ResponseEntity.ok(result);
    }
}
