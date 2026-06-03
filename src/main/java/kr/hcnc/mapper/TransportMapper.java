package kr.hcnc.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.TransportVO;

@Mapper("transportMapper")
public interface TransportMapper {

	// 교통 정보
	public List<TransportVO> selectTransportList();
}
