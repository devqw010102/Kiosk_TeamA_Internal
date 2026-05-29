package kr.hcnc.web.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.admin.AdminAttendanceService;
import kr.hcnc.vo.AttendSearchVO;

//출석 관리 API - 출석 현황 조회 및 수동 변경
@RestController
@RequestMapping("/api/admin/attendances")
public class AdminAttendanceController {

	private static final Logger log = LoggerFactory.getLogger(AdminAttendanceController.class);

    @Resource(name = "adminAttendanceService")
    private AdminAttendanceService adminAttendanceService;
   
//    @GetMapping
//    public ResponseEntity<List<Map<String, Object>>> getAttendances(@RequestParam(required = false) String date) {
//    	log.info("Called :: GET /api/admin/attendances");
//    	
//    	return ResponseEntity.ok(adminAttendanceService.selectAttendances(date));
//    }
    
    @GetMapping 
    // 동적 쿼리를 사용해서 조건별로 메소드 구분이 없도록 설계 함
    public ResponseEntity<List<Map<String, Object>>> getAttendace(AttendSearchVO attendSearchVO){
    	log.info("Ansewer :: GET /api/admin/attendances");
    	return ResponseEntity.ok(adminAttendanceService.selectAttendance(attendSearchVO));
    }
    
    @PostMapping
    public ResponseEntity<Integer> updateAttendMsg(@RequestParam(name="msg") String msg,
    							@RequestParam(name="attendDate") String attendDate,
    							@RequestParam(name="studentId") String studentId) {
    	log.info("Called::updateAttendMsg");
    	Map<String, Object> param = new HashMap<>();
    	param.put("msg", msg);
    	param.put("attendDate", attendDate);
    	param.put("studentId", studentId);
    	int result = adminAttendanceService.updateAttendMsg(param);
    	return ResponseEntity.ok(result);
    }
   
}
