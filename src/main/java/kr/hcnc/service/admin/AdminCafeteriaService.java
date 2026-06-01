package kr.hcnc.service.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.admin.AdminCafeteriaMapper;
import kr.hcnc.vo.CafeteriaVO;

@Service("adminCafeteriaService")
public class AdminCafeteriaService extends EgovAbstractServiceImpl {
	
	private static final Logger log = LoggerFactory.getLogger(AdminCafeteriaService.class);
	
	@Autowired
	private AdminCafeteriaMapper adminCafeteriaMapper;
	
	// 선택 달 전체 조회
	public List<CafeteriaVO> selectCafeteriaSummary(String year, String month) {
		log.info("selectCafeteriaSummary year = {}, month = {}", year, month);
		
		return adminCafeteriaMapper.selectCafeteriaSummary(year, month);
	}
	
	// 일일 메뉴표 전체 조회
	public List<CafeteriaVO> selectCafeteriaDetail(String date) {
		log.info("selectCafeteriaDetail date = {}", date);
		
		return adminCafeteriaMapper.selectCafeteriaDetail(date);
	}
	
	// 일일 메뉴 단건 등록
	public int insertCafeteria(CafeteriaVO cafeteriaVO) {
		log.info("insertCafeteria - body = {}", cafeteriaVO);
		
	    // int nextSeq = adminCafeteriaMapper.selectNextCafeteriaSeq();
	    // String year  = cafeteriaVO.getMealDate().substring(2, 4); // "26"
	    // String month = cafeteriaVO.getMealDate().substring(5, 7); // "06"
	    // String id = String.format("CAF%s%s%03d", year, month, nextSeq); // "CAF2606091"

	    // cafeteriaVO.setCafeteriaId(id);
		
		return adminCafeteriaMapper.insertCafeteria(cafeteriaVO);
	}
	
	// 일일 메뉴 및 운영유무 수정
	public int updateCafeteria(CafeteriaVO cafeteriaVO) {
		log.info("updateCafeteria - body = {}", cafeteriaVO);
		
		return adminCafeteriaMapper.updateCafeteria(cafeteriaVO);
	}
	
	// 일일 메뉴 단건 삭제 (논리 삭제)
	public int deleteCafeteria(String cafeteriaId) {
		log.info("deleteCafeteria - cafeteriaId = {}", cafeteriaId);
		
		return adminCafeteriaMapper.deleteCafeteria(cafeteriaId);
	}
}
