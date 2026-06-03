package kr.hcnc.web.kiosk;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.kiosk.ClassroomService;
import kr.hcnc.vo.ClassroomVO;

@RestController
@RequestMapping("/api/classroom")
public class ClassroomApiController {

	@Resource(name = "classroomService")
	private ClassroomService classroomService;
	
	private static final Logger log = LoggerFactory.getLogger(ClassroomApiController.class);
	
	@GetMapping
	public List<ClassroomVO> selectClassroom() {
		log.info("Called :: GET /api/classroom");
		return classroomService.selectClassroom();
	}
}
