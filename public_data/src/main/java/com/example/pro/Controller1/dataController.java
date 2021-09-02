package com.example.pro.Controller1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class dataController {

	@RequestMapping("index")
	public String index() {
		return "/index";
	}
	
	
	@RequestMapping("tourinfo")
	public String tourinfo() {
		return "/tourinfo";
	}
	
	/*
	 * @RequestMapping("dataApi")
	 * 
	 * @ResponseBody public String dataApi() throws Exception {
	 * 
	 * data_api data_api = new data_api(); String data =
	 * data_api.data_access();//sb.toString이 넘어온다.
	 * 
	 * return data; }
	 */
	
	
	//관광사진정보 목록조회
	@RequestMapping("dataApi")
	@ResponseBody
	public String dataApi(@RequestParam(value = "pageNo", defaultValue = "1") String pageNo) throws Exception {
		
		data_api data_api = new data_api();
		String data = data_api.data_access(pageNo);//sb.toString이 넘어온다.
		
		return data;
	}
	
	//관광사진정보 검색조회
	@RequestMapping("/dataApiSearch")
	@ResponseBody
	public String dataApiSearch(@RequestParam String word) throws Exception {
		
		data_api data_api = new data_api();
		String data = data_api.data_search(word);//sb.toString이 넘어온다.
		
		return data;
	}
	
	
	@RequestMapping("/dataApi2")
	@ResponseBody
	public String dataApi2() throws Exception {
		
		data_api2 data_api = new data_api2();
		String data = data_api.data_access();//sb.toString이 넘어온다.
		
		return data;
	}
	
	
	@RequestMapping("/dataApi3")
	@ResponseBody
	public String dataApi3() throws Exception {
		
		data_api3 data_api = new data_api3();
		String data = data_api.data_access();//sb.toString이 넘어온다.
		
		return data;
	}
}
