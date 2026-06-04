package kr.hcnc.service.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.admin.AdminCafeteriaMapper;
import kr.hcnc.vo.CafeteriaVO;

@Service("adminCafeteriaService")
public class AdminCafeteriaService extends EgovAbstractServiceImpl {
	
	private static final Logger log = LoggerFactory.getLogger(AdminCafeteriaService.class);
	
	@Autowired
	private AdminCafeteriaMapper adminCafeteriaMapper;
	
	public List<CafeteriaVO> selectCafeteriaSummary(String year, String month) {
		log.info("selectCafeteriaSummary year = {}, month = {}", year, month);
		
		return adminCafeteriaMapper.selectCafeteriaSummary(year, month);
	}
	
	public List<CafeteriaVO> selectCafeteriaDetail(String date) {
		log.info("selectCafeteriaDetail date = {}", date);
		
		return adminCafeteriaMapper.selectCafeteriaDetail(date);
	}
	
	@Transactional
	public int insertCafeteria(List<CafeteriaVO> cafeteriaList) {
		log.info("통합 저장 프로세스 가동 :: 처리할 데이터 건수 = {}", cafeteriaList != null ? cafeteriaList.size() : 0);
		
		if(cafeteriaList != null && !cafeteriaList.isEmpty()) {
			adminCafeteriaMapper.logicalDeleteOldData(cafeteriaList);
		}
		
		return adminCafeteriaMapper.insertCafeteria(cafeteriaList);
	}
	
	public int updateCafeteria(CafeteriaVO cafeteriaVO) {
		log.info("updateCafeteria - body = {}", cafeteriaVO);
		return adminCafeteriaMapper.updateCafeteria(cafeteriaVO);
	}
		
	public int deleteCafeteria(String cafeteriaId) {
		log.info("deleteCafeteria - cafeteriaId = {}", cafeteriaId);
		return adminCafeteriaMapper.deleteCafeteria(cafeteriaId);
	}
}
