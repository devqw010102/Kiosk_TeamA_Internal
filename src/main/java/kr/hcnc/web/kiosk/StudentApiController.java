package kr.hcnc.web.kiosk;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.kiosk.BadgeService;
import kr.hcnc.vo.StudentSearchVO;
@RestController
@RequestMapping("/api/student")
public class StudentApiController {

    @Resource(name = "badgeService")
    private BadgeService badgeService;

    private static final Logger log = LoggerFactory.getLogger(StudentApiController.class);
    
    @GetMapping("/search")
    public List<Map<String, Object>> searchStudent(StudentSearchVO searchVO) {
        log.info("Called :: /api/student/search");
        return badgeService.selectStudents(searchVO);
    }
    
    @GetMapping("/detail")
    public Map<String, Object> searchDetail(StudentSearchVO searchVO) {
    	log.info("Called :: /api/student/detail");
    	return badgeService.selectStudentDetail(searchVO);
    }
    
    @PostMapping("/update")
    public Map<String, Object> updateStudentStatus(StudentSearchVO searchVO) {
    	log.info("Called :: /api/student/update");
    	return badgeService.updateStudentStatus(searchVO);
    }
}