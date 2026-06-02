package kr.hcnc.mapper.admin;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.TransportVO;

@Mapper("adminTransportMapper")
public interface AdminTransportMapper {

	List<TransportVO> selectTransportList();

	TransportVO selectTransportById(String transportId);

	int insertTransport(TransportVO transportVO);

	int updateTransport(TransportVO transportVO);

	int deleteTransport(String transportId);
}
