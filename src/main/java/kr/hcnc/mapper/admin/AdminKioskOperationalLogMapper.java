package kr.hcnc.mapper.admin;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.hcnc.vo.KioskOperationalLogVO;

@Mapper("adminKioskOperationalMapper")
public interface AdminKioskOperationalLogMapper {
	public List<KioskOperationalLogVO> selectOpLog (KioskOperationalLogVO kioskOpVO);
	public int insertOpLog(KioskOperationalLogVO kioskOpVO);
	public int insertDormOutLog(KioskOperationalLogVO kioskOpVO);
	public int deleteOpLog(KioskOperationalLogVO kioskOpVO);
}
