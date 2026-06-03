package kr.hcnc.mapper.admin;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.FacilityInfoVO;

@Mapper("adminFacilityInfoMapper")
public interface AdminFacilityInfoMapper {

	List<FacilityInfoVO> selectFacilityList();

	FacilityInfoVO selectFacilityById(String facilityId);

	int insertFacility(FacilityInfoVO facilityInfoVO);

	int updateFacility(FacilityInfoVO facilityInfoVO);

	int deleteFacility(String facilityId);
}
