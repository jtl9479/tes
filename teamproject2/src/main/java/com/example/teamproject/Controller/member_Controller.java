package com.example.teamproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class member_Controller {

	//회원 마이페이지 이동
	@GetMapping("member_Main")
	public String member_Main() {
		
		return "/member/member_Main";
	}

	//회원 마이페이지 이동
	@GetMapping("member_Register")
	public String member_Register() {
		
		return "/member/member_Register";
	}
	
	//회원 정보 수정 페이지 이동
	@GetMapping("member_Modify")
	public String member_Modify() {
		
		return "/member/member_Modify";
	}
	
	//회원 정보 수정 페이지 이동
	@GetMapping("member_qua")
	public String member_qua() {
		
		return "/member/member_qua";
	}
}
