package kr.hcnc.mapper.admin;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.KioskLogVO;

@Mapper("adminKioskLogMapper")
public interface AdminKioskLogMapper {
	public List<KioskLogVO> selectKioskLog (KioskLogVO kioskLogVO);
	public int insertLog(KioskLogVO kioskLogVO);
	public int deleteLog(KioskLogVO kioskLogVO);
}
