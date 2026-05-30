package kr.hcnc.mapper.admin;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.FacilityInfoVO;

@Mapper("adminFacilityInfoMapper")
public interface AdminFacilityInfoMapper {

	int updateFacility(FacilityInfoVO facilityInfoVO);
}
