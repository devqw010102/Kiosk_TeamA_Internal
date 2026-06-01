package kr.hcnc.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.TransportMapper;
import kr.hcnc.vo.TransportVO;

@Service("transportService")
public class TransportService extends EgovAbstractServiceImpl {

	@Resource(name = "transportMapper")
	private TransportMapper transportMapper;

	private static final Logger log = LoggerFactory.getLogger(TransportService.class);

	public List<TransportVO> selectTransportList() {
		log.info("Called :: selectTransportList");
		return transportMapper.selectTransportList();
	}
}
