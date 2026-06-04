package kr.hcnc.mapper.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.CafeteriaVO;

@Mapper
public interface AdminCafeteriaMapper {
	
	List<CafeteriaVO> selectCafeteriaSummary(@Param("mealYear")String year, @Param("mealMonth")String month);
		
	List<CafeteriaVO> selectCafeteriaDetail(@Param("mealDate") String mealDate);
		
	int insertCafeteria(List<CafeteriaVO> cafeteriaList);
		
	int updateCafeteria(CafeteriaVO cafeteriaVO);
	
	int deleteCafeteria(String cafeteriaId);
}
