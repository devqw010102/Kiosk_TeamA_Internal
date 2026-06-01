package kr.hcnc.mapper.admin;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.DormitoryVO;

@Mapper("adminDormitoryMapper")
public interface AdminDormitoryMapper {
	public List<DormitoryVO> selectDormRoomAssignStatus();
	public DormitoryVO selectDormRoomAssignStatusById(String dormitoryId);
	public int updateDormAssignMaxCnt(DormitoryVO dormitoryVO);
	public int updateDormCurrentCnt(DormitoryVO dormitoryVO);
	public int updateDormCurrentCntDown(DormitoryVO dormitoryVO);
}
