package kr.hcnc.mapper.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.CafeteriaVO;

@Mapper
public interface AdminCafeteriaMapper {
	// 선택 달 전체 조회
	List<CafeteriaVO> selectCafeteriaSummary(@Param("searchYear")String year, @Param("searchMonth")String month);
		
	// 일일 메뉴표 전체 조회
	List<CafeteriaVO> selectCafeteriaDetail(String mealDate);
		
	// 일일 메뉴 단건 등록
	int insertCafeteria(CafeteriaVO cafeteriaVO);
		
	// 일일 메뉴 및 운영유무 수정
	int updateCafeteria(CafeteriaVO cafeteriaVO);
	
	int deleteCafeteria(String cafeteriaId);
	
	// int selectNextCafeteriaSeq();
}
