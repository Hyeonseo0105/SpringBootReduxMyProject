package com.sist.web.service;

import java.util.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.sist.web.entity.*;

@Service
public interface BookService extends JpaRepository<Book, Integer>{

	public Book findByNo(int no);
	
	@Query(value = "SELECT * FROM book WHERE no<=120 "
			+"ORDER BY no ASC LIMIT :start,20",nativeQuery = true)
	public List<Book> bookListData(@Param("start") int start);

	@Query(value = "SELECT COUNT(*) FROM book WHERE no<=120",nativeQuery = true)
	public int bookListTotalPage();
	
	@Query(value = "SELECT * FROM book WHERE type='소설' "
			+"ORDER BY no ASC LIMIT :start,12",nativeQuery = true)
	public List<Book> novelListData(@Param("start") int start);

	@Query(value = "SELECT COUNT(*) FROM book WHERE type='소설'",nativeQuery = true)
	public int novelTotalPage();
	
	@Query(value = "SELECT * FROM book WHERE type='IT 모바일' "
			+"ORDER BY no ASC LIMIT :start,20",nativeQuery = true)
	public List<Book> itListData(@Param("start") int start);
	
	@Query(value = "SELECT COUNT(*) FROM book WHERE type='IT 모바일'",nativeQuery = true)
	public int itTotalPage();
	
	@Query(value = "SELECT * FROM book "
			+"WHERE name LIKE CONCAT('%',:name,'%') "
			+"ORDER BY no ASC LIMIT :start,20",nativeQuery = true)
	public List<Book> bookFindData(@Param("name") String name,@Param("start") int start);
	
	@Query(value = "SELECT COUNT(*) FROM book "
			+"WHERE name LIKE CONCAT('%',:name,'%')",nativeQuery = true)
	public int bookFindTotalpage(@Param("name") String name);
	
	@Query(value = "SELECT * FROM book WHERE no>=365 "
			+"ORDER BY no ASC LIMIT :start,20",nativeQuery = true)
	public List<Book> newListData(@Param("start") int start);
	
	@Query(value = "SELECT COUNT(*) FROM book WHERE type='신상품'",nativeQuery = true)
	public int newTotalPage();
	
	// 홈
	@Query(value = "SELECT * FROM book WHERE type='IT 모바일' LIMIT 0,4",nativeQuery = true)
	public List<Book> bookHomeList();
	
	// 장바구니
	//@Query(value = "UPDATE ")
}
