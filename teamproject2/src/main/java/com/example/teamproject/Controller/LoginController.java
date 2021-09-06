package com.example.teamproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("index")
	public String index() {
		return "/index";
	}
	
	//로그인페이지 이동
	@GetMapping("login")
	public String login() {
		return "/login/login_resist_form";
	}

	//회원가입 이동
	@GetMapping("Sign_up_form")
	public String Sign_up_form() {
		return "/login/Sign_up_form";
	}
	
	//찾기 이동
	@GetMapping("Find")
	public String Find() {
		return "/login/find";
	}
}
