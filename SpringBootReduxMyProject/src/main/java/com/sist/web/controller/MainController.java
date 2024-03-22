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
public class MainController {

	@Autowired
	private BookService bService;
	
	@Autowired
	private CdlpService cService;
	
	@GetMapping("/")
	public Map home_list()
	{
		List<Book> bList=bService.bookHomeList();
		List<Cdlp> cList=cService.cdlpHomeList();
		
		Map map=new HashMap();
		map.put("bList", bList);
		map.put("cList", cList);
		
		return map;
	}
}
