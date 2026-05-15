package kr.hcnc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    
    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> updateStudentStatus(String param) {
    	System.out.println("StudentApiController :: /api/student/update");
    	
    	Map<String, Object> map = new HashMap<>();
    	
    	try {
    		badgeService.updateStudentStatus(param);
    		map.put("status", "success");
    	}
    	catch(Exception e) {
    		map.put("status", "fail");
    		map.put("message", e.getMessage());
    	}
    	
    	return map;
    }
}