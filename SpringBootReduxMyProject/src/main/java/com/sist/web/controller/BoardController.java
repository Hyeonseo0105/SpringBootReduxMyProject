package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.entity.*;
@RestController
@CrossOrigin(origins = "*")
public class BoardController {
	
      @Autowired
      private BoardService bService;
  
	  @GetMapping("/board/list_redux")
	  public Map board_list(int page)
	  {
		  int rowSize=5;
		  int start=(rowSize*page)-rowSize;
		  List<Board> list=bService.boardListData(start);
		  
		  int count=(int)bService.count();
		  int totalpage=(int)(Math.ceil(count/5.0));
		    
	      Map map=new HashMap();
		  map.put("curpage", page);
		  map.put("totalpage", totalpage);
		  map.put("board_list", list);
		  
		  return map;
	  }
	  
	  @PostMapping("/board/insert_redux")
	  public String board_insert(Board vo)
	  {
		  String result="";
		  
		  try
		  {
			  bService.save(vo);
			  result="yes";
		  }
		  catch(Exception ex)
		  {
			  result="no";
		  }
		  
		  return result;
	  }
	  
	  @GetMapping("/board/detail_redux")
	  public Board board_detail(int no)
	  {
		  Board vo=bService.findByNo(no);
		  vo.setHit(vo.getHit()+1);
		  bService.save(vo);
		  vo=bService.findByNo(no);
		  
		  return vo;
	  }
	  
	  @GetMapping("/board/update_redux")
	  public Board board_update(int no)
	  {
		  Board vo=bService.findByNo(no);
		  return vo;
	  }
	  
	  @PostMapping("/board/update_ok_redux")
	  public String board_update_ok(Board vo)
	  {
		  Board dbVO=bService.findByNo(vo.getNo());
		  
		  String result="";
		  if(vo.getPwd().equals(dbVO.getPwd()))
		  {
			  result="yes";
			  vo.setHit(dbVO.getHit());
			  bService.save(vo);
		  }
		  else
		  {
			  result="no";
		  }
		  
		  return result;  
	  }
	  
	  @PostMapping("/board/delete_redux")
	  public String board_delete(int no,String pwd)
	  {
		  String result="";
		  Board vo=bService.findByNo(no);
		  
		  if(vo.getPwd().equals(pwd))
		  {
			 result="yes";
			 bService.delete(vo);
		  }
		  else
		  {
			  result="no";
		  }
		  return result;
	  }
}