package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.entity.*;

@RestController
@CrossOrigin(origins = "*")
public class CdlpController {

	@Autowired
	private CdlpService cService;
	
	@GetMapping("/cdlp/list_redux")
	public Map cdlp_list(int page)
	{
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		List<Cdlp> list=cService.cdlpListData(start);
	
		int totalpage=cService.cdlpListTotalpage();
		
		Map map=new HashMap();
		map.put("cdlp_list", list);
		map.put("totalpage", totalpage);
		
		return map;
	}
	
	@GetMapping("/cdlp/classic_list_redux")
	public Map classic_list(int page)
	{
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		int totalpage=cService.classicTotalpage();
		List<Cdlp> list=cService.classicList(start);
		
		Map map=new HashMap();
		map.put("classic_list", list);
		map.put("totalpage", totalpage);
		
		return map;
	}
	
	@GetMapping("/cdlp/detail_redux")
	public Cdlp cdlp_detail(int no)
	{
		Cdlp cdlp=cService.findByNo(no);
		
		return cdlp;
	}
}
