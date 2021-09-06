package com.example.teamproject.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.teamproject.Service.LoginService;
import com.example.teamproject.Vo.AdminVo;
import com.example.teamproject.Vo.FmanagerVo;
import com.example.teamproject.Vo.MemberVo;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	

	//인덱스 페이지
	@GetMapping("index")
	public String index() {
		return "/index";
	}
	
	//로그아웃
	@GetMapping("logout")
	public String logout() {
		return "/logout";
	}

	//로그인페이지 이동
	@GetMapping("login")
	public String login_page() {
		return "/login/login_page";
	}
	
	//회원 로그인페이지 이동
	@PostMapping("login_member")
	public String login_member(@RequestParam (value = "id") String M_ID,
			@RequestParam (value = "pw") String M_PW,
			HttpServletRequest request
			) {
		HttpSession session = request.getSession();
		
		
		MemberVo memberVo = loginService.member_login_check(M_ID,M_PW);
		
		
		if(memberVo != null) {
		session.setAttribute("session_login", memberVo.getM_ID());
		session.setAttribute("session_nick", memberVo.getM_NICKNAME());
		session.setAttribute("session_flag", "session_member");
		}else {
			session.setAttribute("session_flag", "fail");	
		}
		return "/index";
	}
	
	//시설 로그인페이지 이동
	@PostMapping("login_fac")
	public String login_fac(@RequestParam (value = "id") String FM_ID,
			@RequestParam (value = "pw") String FM_PW,
			HttpServletRequest request) {
		HttpSession session = request.getSession();

		
		FmanagerVo fmanagerVo = loginService.Fmanager_login_check(FM_ID,FM_PW);

		
		if(fmanagerVo != null) {
		session.setAttribute("session_login", fmanagerVo.getFM_ID());
		session.setAttribute("session_name", fmanagerVo.getFM_ID());
		session.setAttribute("session_flag", "session_fmanager");
		}else {
			session.setAttribute("session_flag", "fail");	
		}
		return "/index";
	}

	//회원가입 이동
	@GetMapping("Sign_up_form")
	public String Sign_up_form() {
		return "/login/Sign_up_form";
	}
	
	
	//회원 회원가입
	@PostMapping("register_member")
	public String register_member(MemberVo memberVo,
			Model model
			) {
		System.out.println(memberVo.getM_ID());
		int result = loginService.member_register_check(memberVo);
		
		model.addAttribute("result", result);
		
		return "/login/login_page";
	}
	
	
	
	  //시설관리자 회원가입
	 
	  @PostMapping("register_fac") public String register_fac(FmanagerVo
	  fmanagerVo, Model model ) {
	  
	  int result = loginService.fac_register_check(fmanagerVo);
	  
	  model.addAttribute("result1", result);
	  
	  return "/login/login_page"; 
	  }
	
	//아이디 찾기 이동
	@GetMapping("Find")
	public String Find() {
		return "/login/find";
	}
	
	//비밀번호 찾기 이동
	@GetMapping("Find_PW")
	public String Find_PW() {
		return "/login/find_pw";
	}
	
	//회원 아이디 찾기
	@PostMapping("find_member")
	public String Find_member(@RequestParam (value = "nick") String M_NICKNAME,
			@RequestParam (value = "email") String M_eMAIL,
			Model model
			) {
		
		MemberVo memberVo = loginService.member_ld_find_check(M_NICKNAME,M_eMAIL);
		
		if(memberVo != null) {
			model.addAttribute("find_nick", memberVo.getM_NICKNAME());
			model.addAttribute("find_id", memberVo.getM_ID());
			model.addAttribute("find_check", "success");
		}else {
			model.addAttribute("find_check", "fail");
		}
		
		return "/login/find_check";
	}
	
	//시설 관리자 아이디 찾기
	@PostMapping("find_fmanager")
	public String Find_fac(@RequestParam (value = "name") String FM_NAME,
			@RequestParam (value = "phone") String FM_PHONE,
			Model model
			) {
		
		FmanagerVo fmanagerVo = loginService.fac_ld_find_check(FM_NAME,FM_PHONE);
		if(fmanagerVo != null) {
			model.addAttribute("find_nick",fmanagerVo.getFM_NAME());
			model.addAttribute("find_id", fmanagerVo.getFM_ID());
			model.addAttribute("find_check", "success");
		}else {
			model.addAttribute("find_check", "fail");
		}
		return "/login/find_check";
	}

	//회원 비밀번호 찾기
	@PostMapping("find_member_pw")
	public String Find_member_pw(@RequestParam (value = "name") String M_NAME,
			@RequestParam (value = "email") String M_eMAIL,
			Model model
			) {
		System.out.println(M_NAME);
		MemberVo memberVo = loginService.member_pw_find_check(M_NAME,M_eMAIL);
		
		if(memberVo != null) {
			model.addAttribute("find_nick", memberVo.getM_NICKNAME());
			model.addAttribute("find_pw", memberVo.getM_PW());
			model.addAttribute("find_check_pw", "success");
		}else {
			model.addAttribute("find_check_pw", "fail");
		}
		
		return "/login/find_check";
	}
	
	
	//시설 비밀번호 찾기
	@PostMapping("find_fmanager_pw")
	public String find_fmanager_pw(@RequestParam (value = "id") String FM_ID,
			@RequestParam (value = "phone") String FM_PHONE,
			Model model
			) {
		System.out.println(FM_PHONE);
		FmanagerVo fmanagerVo = loginService.fac_pw_find_check(FM_ID,FM_PHONE);
		
		if(fmanagerVo != null) {
			model.addAttribute("find_nick", fmanagerVo.getFM_ID());
			model.addAttribute("find_pw", fmanagerVo.getFM_PW());
			model.addAttribute("find_check_pw", "success");
		}else {
			model.addAttribute("find_check_pw", "fail");
		}
		
		return "/login/find_check";
	}
	
	//관리자 로그인페이지 이동
	@GetMapping("admin_login")
	public String admin_login() {
		return "/login/admin_login";
	}
	
	//관리자 로그인
	@PostMapping("admin_login")
	public String admin_login(@RequestParam (value = "admin_id") String A_ID,
			@RequestParam (value = "admin_id") String A_PW,
			HttpServletRequest request
			) {
		HttpSession session = request.getSession();
		
		System.out.println("값"+A_ID);
		
		AdminVo adminVo = loginService.admin_login(A_ID,A_PW);

		if(adminVo != null) {
			
			session.setAttribute("session_flag", "admin");
			session.setAttribute("session_id", adminVo.getA_ID());
			
		}else {
			session.setAttribute("session_flag", "fail");
		}
		
		
		return "/index";
	}
	
	
	
}
