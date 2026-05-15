package kr.hcnc.web;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.hcnc.service.BadgeService;

@RestController
@RequestMapping("/api/student")
public class StudentApiController {

    @Resource(name = "badgeService")
    private BadgeService badgeService;

    @GetMapping("/search")
    public List<Map<String, Object>> searchStudent(String param) {
        System.out.println("StudentApiController :: /api/student/search");
        return badgeService.selectStudents(param);
    }
    
    @GetMapping("/detail")
    public Map<String, Object> searchDetail(String param) {
    	System.out.println("StudentApiController :: /api/student/detail");
    	return badgeService.selectStudentDetail(param);
    }
}