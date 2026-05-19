package kr.hcnc.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.hcnc.service.BisApiService;

@RestController
@RequestMapping("/api/transport")
public class TransportApiController {
	
	@Resource(name = "bisApiService")
	private BisApiService bisApiService;
	
	@GetMapping("/bus/arrival")
	public List<Map<String, Object>> getBusArrival(@RequestParam String stopId) throws Exception {
		return bisApiService.getBusArrival(stopId);
	}

}
