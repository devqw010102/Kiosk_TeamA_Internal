package kr.hcnc.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import kr.hcnc.mapper.admin.AdminTransportMapper;
import kr.hcnc.vo.TransportVO;

@Service("adminTransportService")
public class AdminTransportService extends EgovAbstractServiceImpl {

	@Resource(name = "adminTransportMapper")
	private AdminTransportMapper adminTransportMapper;

	@Resource(name = "transportIdGnService")
	private EgovIdGnrService transportIdGnService;
	
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
		try {
			transportVO.setTransportId(transportIdGnService.getNextStringId());
		}
		catch(FdlException e) {
			log.error("TRANSPORT ID 채번 실패", e);
			throw new RuntimeException("ID 생성에 실패했습니다.");
		}
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
