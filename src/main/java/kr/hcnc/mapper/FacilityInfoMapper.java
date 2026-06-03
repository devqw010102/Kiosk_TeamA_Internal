package kr.hcnc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.FacilityInfoVO;

@Mapper("facilityInfoMapper")
public interface FacilityInfoMapper {

	List<FacilityInfoVO> selectFacilityList();

}
