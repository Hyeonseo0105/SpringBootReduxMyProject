package com.sist.web.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.entity.*;

@Service
public interface CdlpService extends JpaRepository<Cdlp, Integer>{

	@Query(value = "SELECT * FROM cdlp WHERE no<=956 "
			+"ORDER BY no ASC LIMIT :start,12",nativeQuery = true)
	public List<Cdlp> cdlpListData(@Param("start") int start);
	
	@Query(value = "SELECT COUNT(*)/12.0 FROM cdlp WHERE no<=956",nativeQuery = true)
	public int cdlpListTotalpage();
	
	public Cdlp findByNo(int no);
	
	@Query(value = "SELECT * FROM cdlp WHERE no>956 "
			+"ORDER BY no ASC LIMIT :start,12",nativeQuery = true)
	public List<Cdlp> classicList(@Param("start") int start);
	
	@Query(value = "SELECT COUNT(*)/12.0 FROM cdlp WHERE no>956",nativeQuery = true)
	public int classicTotalpage();
	
	//홈
	@Query(value = "SELECT * FROM cdlp LIMIT 0,6",nativeQuery = true)
	public List<Cdlp> cdlpHomeList();
}
