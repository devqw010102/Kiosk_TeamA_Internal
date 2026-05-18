package kr.hcnc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.hcnc.service.BadgeService;
import kr.hcnc.vo.StudentSearchVO;
@RestController
@RequestMapping("/api/student")
public class StudentApiController {

    @Resource(name = "badgeService")
    private BadgeService badgeService;

    @GetMapping("/search")
    public List<Map<String, Object>> searchStudent(StudentSearchVO searchVO) {
        System.out.println("StudentApiController :: /api/student/search");
        return badgeService.selectStudents(searchVO);
    }
    
    @GetMapping("/detail")
    public Map<String, Object> searchDetail(StudentSearchVO searchVO) {
    	System.out.println("StudentApiController :: /api/student/detail");
    	return badgeService.selectStudentDetail(searchVO);
    }
    
    @PostMapping("/update")
    public Map<String, Object> updateStudentStatus(StudentSearchVO searchVO) {
    	System.out.println("StudentApiController :: /api/student/update");
    	return badgeService.updateStudentStatus(searchVO);
    }
}