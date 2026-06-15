package kr.hcnc.mapper.admin;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.DormAssignVO;
import kr.hcnc.vo.DormInOutVO;
import kr.hcnc.vo.DormitoryVO;

@Mapper("adminDormitoryMapper")
public interface AdminDormitoryMapper {
	public List<DormitoryVO> selectCmbDorm();
	public List<DormAssignVO> selectDormAssign();
	public List<DormInOutVO> selectDormWaiting();
	public List<DormInOutVO> selectDormInOut();
	public List<DormitoryVO> selectDormRoomAssignStatus(DormitoryVO dormitoryVO);
	public int updateDormId(DormAssignVO dormAssignVO);
	public int updateDormAssignMaxCnt(DormitoryVO dormitoryVO);
	public int updateDormCurrentCnt(DormitoryVO dormitoryVO);
	public int updateDormCurrentCntDown(DormitoryVO dormitoryVO);
}
