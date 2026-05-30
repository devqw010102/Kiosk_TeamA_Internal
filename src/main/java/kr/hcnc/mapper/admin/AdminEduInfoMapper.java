package kr.hcnc.mapper.admin;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.EduInfoVO;

@Mapper("adminEduInfoMapper")
public interface AdminEduInfoMapper {
	
	public List<EduInfoVO> selectEduInfo();
	
	public EduInfoVO selectEduInfoById(String eduId);
	
	public int insertEduInfo(EduInfoVO eduInfoVO);
	
	public int updateEduInfo(EduInfoVO eduInfoVO);
	
	public int deleteEduInfo(String eduId);
}
