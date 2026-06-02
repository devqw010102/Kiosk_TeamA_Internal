package kr.hcnc.service.admin;

import java.util.List;

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

	public int insertTransport(TransportVO transportVO) {
		log.info("Called :: insertTransport");
		return adminTransportMapper.insertTransport(transportVO);
	}

	public int updateTransport(TransportVO transportVO) {
		log.info("Called :: updateTransport");
    	return adminTransportMapper.updateTransport(transportVO);
	}

	public int deleteTransport(String transportId) {
		log.info("Called :: updateTransport");
    	return adminTransportMapper.deleteTransport(transportId);
	}
}
