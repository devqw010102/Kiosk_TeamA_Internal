package kr.hcnc.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.admin.AdminTransportMapper;
import kr.hcnc.vo.TransportVO;

@Service("adminTransportService")
public class AdminTransportService extends EgovAbstractServiceImpl {

	@Resource(name = "adminTransportMapper")
	private AdminTransportMapper adminTransportMapper;

	private static final Logger log = LoggerFactory.getLogger(AdminTransportService.class);

	public List<TransportVO> selectTransportList() {
		log.info("Called :: selectTransportList");
		return adminTransportMapper.selectTransportList();
	}

	public TransportVO selectTransportById(String transportId) {
		log.info("Called :: selectTransportById");
		return adminTransportMapper.selectTransportById(transportId);
	}

	public Map<String, Object> insertTransport(TransportVO transportVO) {
		log.info("Called :: insertTransport");
		Map<String, Object> result = new HashMap<>();

		if (transportVO == null || transportVO.getTransportId() == null || transportVO.getType() == null) {
			result.put("status", "fail");
			result.put("message", "transportId와 type은 필수입니다.");
			return result;
		}

		if (adminTransportMapper.selectTransportById(transportVO.getTransportId()) != null) {
			result.put("status", "fail");
			result.put("message", "이미 존재하는 transportId입니다.");
			return result;
		}

		int inserted = adminTransportMapper.insertTransport(transportVO);
		if (inserted > 0) {
			result.put("status", "success");
			result.put("message", "등록되었습니다.");
			result.put("transportId", transportVO.getTransportId());
		} else {
			result.put("status", "fail");
			result.put("message", "등록에 실패했습니다.");
		}
		return result;
	}

	public Map<String, Object> updateTransport(TransportVO transportVO) {
		log.info("Called :: updateTransport");
		Map<String, Object> result = new HashMap<>();

		if (transportVO == null || transportVO.getTransportId() == null) {
			result.put("status", "fail");
			result.put("message", "잘못된 요청입니다.");
			return result;
		}

		int updated = adminTransportMapper.updateTransport(transportVO);
		if (updated > 0) {
			result.put("status", "success");
			result.put("message", "수정되었습니다.");
		} else {
			result.put("status", "fail");
			result.put("message", "수정할 교통 정보를 찾을 수 없습니다.");
		}
		return result;
	}
}
