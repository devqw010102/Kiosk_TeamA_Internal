package kr.hcnc.mapper.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.CafeteriaVO;

@Mapper
public interface AdminCafeteriaMapper {
	
	List<CafeteriaVO> selectCafeteriaSummary(@Param("searchYear")String year, @Param("searchMonth")String month);
		
	List<CafeteriaVO> selectCafeteriaDetail(String mealDate);
		
	int insertCafeteria(CafeteriaVO cafeteriaVO);
		
	int updateCafeteria(CafeteriaVO cafeteriaVO);
	
	int deleteCafeteria(String cafeteriaId);
}
