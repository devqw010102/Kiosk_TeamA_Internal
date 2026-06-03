package kr.hcnc.mapper.kiosk;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.FacilityInfoVO;

@Mapper("facilityInfoMapper")
public interface FacilityInfoMapper {

	List<FacilityInfoVO> selectFacilityList();

}
