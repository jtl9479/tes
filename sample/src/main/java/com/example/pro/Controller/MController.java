package com.example.pro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pro.Service.MService;

@Controller
public class MController {

	@Autowired
	MService mService;
	
	
	@RequestMapping("index")
	public String index() {
		return "/index";
	}
}
