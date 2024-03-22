package com.sist.web.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.entity.*;
import com.sist.web.service.*;

@RestController
@CrossOrigin(origins = "*")
public class BookController {

	@Autowired
	private BookService bService;
	
	@GetMapping("/book/list_redux")
	public Map book_list(int page)
	{
		int rowSize=20;
		int start=(rowSize*page)-rowSize;
		List<Book> list=bService.bookListData(start);
		
		int totalpage=bService.bookListTotalPage();
		
		Map map=new HashMap();
		
		map.put("book_list", list);
		map.put("totalpage", totalpage);
		
		
		return map;
	}
	
	@GetMapping("/book/novel_list_redux")
	public Map novel_list(int page)
	{
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		List<Book> list=bService.novelListData(start);
		
		int totalpage=bService.novelTotalPage();
		
		Map map=new HashMap();
		
		map.put("novel_list", list);
		map.put("totalpage", totalpage);
		
		
		return map;
	}
	
	@GetMapping("/book/it_list_redux")
	public Map it_list(int page)
	{
		int rowSize=20;
		int start=(rowSize*page)-rowSize;
		List<Book> list=bService.itListData(start);
		
		int totalpage=bService.itTotalPage();
		
		Map map=new HashMap();
		
		map.put("it_list", list);
		map.put("totalpage", totalpage);
		
		
		return map;
	}
	
	@GetMapping("/book/new_list_redux")
	public Map new_list(int page)
	{
		int rowSize=20;
		int start=(rowSize*page)-rowSize;
		List<Book> list=bService.newListData(start);
	
		int totalpage=bService.newTotalPage();
		
		Map map=new HashMap();
		map.put("new_list", list);
		map.put("totalpage", totalpage);
		
		return map;
	}
	
	@GetMapping("/book/detail_redux")
	public Book book_detail(int no)
	{
		Book book=bService.findByNo(no);
		
		return book;
	}
	
	@GetMapping("/book/find_redux")
	public Map book_find(int page,String name)
	{
		int rowSize=20;
		int start=(rowSize*page)-rowSize;
		List<Book> list=bService.bookFindData(name, start);
		
		int totalpage=bService.bookFindTotalpage(name);
		
		Map map=new HashMap();
		map.put("find_list", list);
		map.put("totalpage", totalpage);
		
		return map;
	}
	
}
