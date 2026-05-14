package kr.hcnc.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.hcnc.mapper.DormitoriesMapper;

@Service("dormitoriesService")
public class DormitoriesService extends EgovAbstractServiceImpl {

	@Resource(name = "dormitoriesMapper")
	private DormitoriesMapper dormitoriesMapper;
	
	
	@Resource(name = "dataSource")
	private javax.sql.DataSource dataSource;
	
	public List<Map<String, Object>> selectTest() {
	    System.out.println("DormitoriesService :: selectTest()");
	    System.out.println("Mapper 호출 전");
	    
	    // DB 직접 연결 테스트
	    try {
	        java.sql.Connection conn = dataSource.getConnection();
	        System.out.println("DB 연결 성공!");
	        conn.close();
	    } catch (Exception e) {
	        System.out.println("DB 연결 실패 : " + e.getMessage());
	    }
	    
	    List<Map<String, Object>> list = dormitoriesMapper.selectTest();
	    System.out.println("Mapper 호출 후");
	    return list;
	}
}
