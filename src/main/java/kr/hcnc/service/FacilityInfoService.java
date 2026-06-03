package kr.hcnc.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.FacilityInfoMapper;
import kr.hcnc.vo.FacilityInfoVO;

@Service("facilityInfoService")
public class FacilityInfoService extends EgovAbstractServiceImpl {

	@Resource(name = "facilityInfoMapper")
	private FacilityInfoMapper facilityInfoMapper;

	private static final Logger log = LoggerFactory.getLogger(FacilityInfoService.class);

	public List<FacilityInfoVO> selectFacilityList() {
	    log.info("Called::selectFacilityList");
	    return facilityInfoMapper.selectFacilityList();
	}
}
